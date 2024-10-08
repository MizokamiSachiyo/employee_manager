package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.entity.EmployeeListBean;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/employeeList")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング
		request.setCharacterEncoding("UTF-8");

		// 転送用パスを格納する変数
		String url = "employeeList.jsp";

		// 検索ワードを取得
		String searchWord = request.getParameter("searchWord");

		// DAOのインスタンス化
		EmployeeDAO dao = new EmployeeDAO();

		try {
			List<EmployeeListBean> employeeList;

			// 検索ワードが空の場合は全リストを取得
			if (searchWord == null || searchWord.isEmpty()) {
				employeeList = dao.getEmployeeList();
			} else {
				// 検索ワードが指定されている場合は検索を行う
				employeeList = dao.searchEmployee(searchWord);
			}

			// リクエストスコープにリストをセット
			if (employeeList.isEmpty()) {
				request.setAttribute("message", "該当する従業員がいません");
			} else {
				request.setAttribute("employeeList", employeeList);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			url = "error.jsp";
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
