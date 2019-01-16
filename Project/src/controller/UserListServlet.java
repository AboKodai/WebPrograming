package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListServlet() {
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

		//セッションスコープからユーザインスタンスにセット
		User u = (User) session.getAttribute("userInfo");

		//管理者がログインした場合
		if (u.getLoginId().equals("admin")) {

			//ユーザ一覧情報を取得
			UserDao userDao = new UserDao();
			List<User> userList = userDao.findAll();

			//リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);

			//ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//管理者以外がログインした場合
		if (!(u.getLoginId().equals("admin"))) {

			//ユーザ一覧情報を取得
			UserDao userDao = new UserDao();
			List<User> userList = userDao.findAll();

			//リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList2", userList);

			//ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//入力された値を取得
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDateMin = request.getParameter("birthDateMin");
		String birthDateMax = request.getParameter("birthDateMax");

		//セッションスコープの情報をユーザインスタンスにセット
		User u = (User) session.getAttribute("userInfo");

		//管理者が検索した場合
		if (u.getLoginId().equals("admin")) {

			UserDao userDao = new UserDao();
			List<User> userList = userDao.searchUser(loginId, name, birthDateMin, birthDateMax);

			//リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);

			//ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//管理者以外が検索した場合
		if (!u.getLoginId().equals("admin")) {

			UserDao userDao = new UserDao();
			List<User> userList = userDao.searchUser(loginId, name, birthDateMin, birthDateMax);

			//リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList2", userList);

			//ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}

}
