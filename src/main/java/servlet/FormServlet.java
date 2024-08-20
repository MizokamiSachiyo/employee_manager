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

import model.dao.LanguageDAO;
import model.dao.SectionDAO;
import model.entity.LanguageBean;
import model.entity.SectionBean;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		String url = "employeeRegister.jsp";

//				DAOのインスタンス化
		LanguageDAO languageDao = new LanguageDAO();
		SectionDAO sectionDao = new SectionDAO();

		try {
			// DAOのメソッド呼び出しで言語リストを取得
			List<LanguageBean> languageList = languageDao.getLanguages();
			// DAOのメソッド呼び出しで部署リストを取得
			List<SectionBean> sectionList = sectionDao.getSections();

			// リクエストスコープにリストをセット
			request.setAttribute("languageList", languageList);
			request.setAttribute("sectionList", sectionList);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			url = "error.jsp"; // エラーが発生した場合、エラーページへ転送
		}

		// 転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
