package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ConnectionManager;

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
	    
        // データベースに接続し、データを挿入する
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO m_employee (l_name, f_name, gender, birthday, phone_number, section_code, language_code, hire_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            // プレースホルダに値を設定
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            pstmt.setString(3, gender);
            pstmt.setString(4, birthday);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, sectionCode);
            pstmt.setString(7, languageCode);
            pstmt.setString(8, hireDate);

            // SQL文を実行
            pstmt.executeUpdate();

            // 成功した場合の処理
            request.getRequestDispatcher("success.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // エラーページに転送
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}