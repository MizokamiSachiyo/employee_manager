package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.entity.EmployeeListBean;

/**
 * Servlet implementation class EmployeeRegisterServlet
 */
@WebServlet("/employeeRegister")
public class EmployeeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegisterServlet() {
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

		// フォームからのデータ取得
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String phoneNumber = request.getParameter("phoneNumber");
		String sectionCode = request.getParameter("sectionCode");
		String languageCode = request.getParameter("languageCode");
		String hireDate = request.getParameter("hireDate");

		// EmployeeListBeanにデータをセット
		EmployeeListBean employee = new EmployeeListBean();
		employee.setLName(lastName);
		employee.setFName(firstName);
		employee.setGender(gender);
		employee.setBirthday(birthday);
		employee.setPhoneNumber(phoneNumber);
		employee.setSectionCode(sectionCode);
		employee.setLanguageCode(languageCode);
		employee.setHireDate(hireDate);

		// EmployeeDAOを使ってデータベースに追加
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			employeeDAO.addEmployee(employee);
			request.getRequestDispatcher("employeeList").forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}