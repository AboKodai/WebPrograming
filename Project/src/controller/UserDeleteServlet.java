package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class userDelete
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteServlet() {
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
				dispatcher.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを取得
		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		String id = request.getParameter("id");

		//キャンセルが押された場合
		if (no != null) {

			//ユーザ一覧にリダイレクト
			response.sendRedirect("UserListServlet");
			return;
		}

		//OKが押された場合
		if(yes != null) {

			//ユーザを削除
			UserDao userDao = new UserDao();
			userDao.userDelete(id);
		}

		//ユーザ一覧にリダイレクト
		response.sendRedirect("UserListServlet");


	}

}
