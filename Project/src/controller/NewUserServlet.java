package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインセッションがない場合
				HttpSession session = request.getSession();
				if(session.getAttribute("userInfo") == null) {

					//ログイン画面にリダイレクト
					response.sendRedirect("LoginServlet");
					return;
				}

				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		//パスワードが不一致の場合
		if(!(password.equals(passwordCon))) {

			//リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			//リクエストスコープに入力内容をセット
			request.setAttribute("loginId", loginId);
			request.setAttribute("name", name);
			request.setAttribute("birthDate", birthDate);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//現在時刻を取得
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate = f.format(d);
		String updateDate = f.format(d);

		//入力項目を引数に渡して新規登録
		UserDao userDao = new UserDao();
		boolean result = userDao.newUser(loginId, name, birthDate, password, createDate, updateDate);

		//新規登録に失敗した場合
		if(result == false ) {

			//リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			//リクエストスコープに入力内容をセット
			request.setAttribute("loginId", loginId);
			request.setAttribute("name", name);
			request.setAttribute("birthDate", birthDate);

			//新規登録画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//成功したらユーザ一覧にリダイレクト
		response.sendRedirect("UserListServlet");


	}

}
