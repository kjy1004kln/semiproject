package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.USer_FaqVo;

public class User_FaqDao {
	public ArrayList<USer_FaqVo> faqList() {
		ArrayList<USer_FaqVo> list = new ArrayList<>();
		USer_FaqVo vo = null;
		String sql = "select ftitle,fcontent from faq";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					String ftitle = rs.getString("ftitle");
					String fcontent = rs.getString("fcontent");
					vo = new USer_FaqVo(0, ftitle, fcontent, 0, 0, null);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
