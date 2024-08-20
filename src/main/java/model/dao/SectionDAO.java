package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SectionBean;

public class SectionDAO {
	public List<SectionBean> getSections() throws ClassNotFoundException, SQLException {
		List<SectionBean>  SectionList = new ArrayList<>();

		String sql = "SELECT * FROM m_section";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				SectionBean Section = new SectionBean();
				Section.setSectionCode(res.getString("section_code"));
				Section.setSectionName(res.getString("section_name"));
				SectionList.add(Section);
			}
		}
		return SectionList;
	}
}
