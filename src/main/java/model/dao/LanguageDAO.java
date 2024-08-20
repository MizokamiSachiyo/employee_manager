package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.LanguageBean;

public class LanguageDAO {
	public List<LanguageBean> getLanguages() throws ClassNotFoundException, SQLException {
		List<LanguageBean> LanguageList = new ArrayList<>();

		String sql = "SELECT * FROM m_language";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				LanguageBean Language = new LanguageBean();
				Language.setLanguageCode(res.getString("language_code"));
				Language.setLanguageName(res.getString("language_name"));
				LanguageList.add(Language);
			}
		}
		return LanguageList;
	}
}
