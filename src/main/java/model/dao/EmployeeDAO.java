package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeListBean;

public class EmployeeDAO {

	public List<EmployeeListBean> getEmployeeList() throws ClassNotFoundException, SQLException {
		List<EmployeeListBean> employeeList = new ArrayList<>();
		
		String sql = "SELECT * FROM m_employee";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				EmployeeListBean employee = new EmployeeListBean();
				employee.setEmployeeId(res.getInt("employee_id"));
				employee.setLName(res.getString("l_name"));
				employee.setFName(res.getString("f_name"));
				employee.setGender(res.getString("gender"));
				employee.setBirthday(res.getString("birthday"));
				employee.setPhoneNumber(res.getString("phone_number"));
				employee.setSectionCode(res.getString("section_code"));
				employee.setLanguageCode(res.getString("language_code"));
				employee.setHireDate(res.getString("hire_date"));
				employeeList.add(employee);
			}
		}
		return employeeList;
	}
}
