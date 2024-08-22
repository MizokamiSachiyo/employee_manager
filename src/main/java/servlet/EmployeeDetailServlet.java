package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.entity.EmployeeListBean;

/**
 * Servlet implementation class EmployeeDetailServlet
 */
@WebServlet("/EmployeeDetail")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailServlet() {
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
		String url = "employeeDetail.jsp";

		// DAOのインスタンス化
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			//リクエストパラメーターから従業員IDを取得
			String employeeId = request.getParameter("employeeId");
			
			// 従業員情報を取得
            EmployeeListBean employee = dao.getEmployeeId(employeeId);
            
            if(employee != null) {
            	// 従業員情報をリクエストスコープにセット
                request.setAttribute("employee", employee);
            } else {
                // 従業員が見つからない場合
                url = "employeeList.jsp"; // 従業員一覧ページにリダイレクト
                
            } catch (ClassNotFoundException | SQLException e) {
                
            }
		
		}
		
		

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
