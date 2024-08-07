package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.UserBean;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		セッションの取得
		HttpSession session = request.getSession(false);

		if (session != null) {
//			UserBeanをセッションから取得
			UserBean user = (UserBean) session.getAttribute("user");
//			ユーザIDを取得
			String userId = user.getUserId();
//			セッションの無効化
			session.invalidate();
//			ユーザーIDをリクエスト属性に設定
			request.setAttribute("userId", userId);
		}

//		ログアウト後のリダイレクト転送
		RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
		rd.forward(request, response);

	}

}
