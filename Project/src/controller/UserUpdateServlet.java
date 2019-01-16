package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインセッションがない場合
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") == null) {

			//ログイン画面にリダイレクト
			response.sendRedirect("LoginServlet");
			return;
		}

		//URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		//確認用：idをコンソールに出力
		System.out.println(id);

		//idを引数にしてidに紐づくユーザ情報を取得
		UserDao userDao = new UserDao();
		User user = userDao.findDetail(id);

		//ユーザ情報をリクエストスコープにセットしてjspにフォワード
		request.setAttribute("userDetail", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを取得
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String id = request.getParameter("id");

		//パスワードが不一致の場合
		if (!(password.equals(passwordCon))) {

			//ログインID取得のためユーザ情報を取得
			UserDao userDao = new UserDao();
			User user = userDao.findDetail(id);

			//リクエストスコープにユーザをセット
			request.setAttribute("user", user);

			//リクエストスコープにエラーメッセージと入力内容をセット
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			request.setAttribute("name", name);
			request.setAttribute("birthDate", birthDate);
			request.setAttribute("id", id);

			//jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		try {
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

			//リクエストパラメータをもとにユーザ情報を更新

			//パスワードが2つとも入力されていない場合
			if (password.equals("") && passwordCon.equals("")) {

				//ユーザ情報を更新
				UserDao userDao = new UserDao();
				userDao.updateNoPas(name, birthDate, id);

				//ユーザ一覧にリダイレクト
				response.sendRedirect("UserListServlet");
				return;

			}

			//パスワードが2つとも入力された場合
			//ユーザ情報を更新
			UserDao userDao = new UserDao();
			userDao.update(name, birthDate, result, id);

			//ユーザ一覧にリダイレクト
			response.sendRedirect("UserListServlet");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
	}

}
