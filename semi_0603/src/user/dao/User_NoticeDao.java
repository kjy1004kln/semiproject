package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.User_NoticeVo;

public class User_NoticeDao {
	public ArrayList<User_NoticeVo> noticeList(int startRow, int endRow) {
		ArrayList<User_NoticeVo> list = new ArrayList<>();
		String sql = "select * from (select g.*,rownum rnum from (select fid,aid,ftitle from notice"
				+ " where fpublic_private=1 order by fid desc) g) where rnum>=? and rnum<=?";
		User_NoticeVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int fid = rs.getInt("fid");
					String ftitle = rs.getString("ftitle");
					String aid = rs.getString("aid");
					vo = new User_NoticeVo(fid, ftitle, null, null, null, 0, 0, aid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getCount(String field, String keyword) {
		String sql = "select NVL(count(fid),0) from notice";
		if (field != null && !field.equals("")) {
			sql += " where " + field + " like '%" + keyword + "%'";
		}
		int mnum = 0;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				rs.next();
				mnum = rs.getInt(1);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return mnum;
	}

	public ArrayList<User_NoticeVo> findList(String field, String keyword, int startNum, int endNum) {
		ArrayList<User_NoticeVo> list = new ArrayList<>();
		String sql = "select * from (select g.*,rownum rnum from((select * from notice where " + field + " like'%"
				+ keyword + "%')g)) where rnum>=? and rnum<=?";
		User_NoticeVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int fid = rs.getInt("fid");
					String ftitle = rs.getString("ftitle");
					String aid = rs.getString("aid");
					vo = new User_NoticeVo(fid, ftitle, null, null, null, 0, 0, aid);
					list.add(vo);
				}
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return list;
	}

	public User_NoticeVo noticeDetail(String fid) {
		String sql = "select * from notice where fid = " + fid;
		User_NoticeVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int fid2 = rs.getInt("fid");
					String ftitle = rs.getString("ftitle");
					String fcontent = rs.getString("fcontent");
					String ffile = rs.getString("ffile");
					Date frdate = rs.getDate("frdate");
					int fhit = rs.getInt("fhit");
					String aid = rs.getString("aid");
					vo = new User_NoticeVo(fid2, ftitle, fcontent, ffile, frdate, fhit, fhit, aid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public User_NoticeVo backNotice(String fid) {
		String sql = "select * from notice where fid = " + (Integer.parseInt(fid) - 1) + " order by fid desc";
		User_NoticeVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int fid2 = rs.getInt("fid");
					String ftitle = rs.getString("ftitle");
					String fcontent = rs.getString("fcontent");
					String ffile = rs.getString("ffile");
					Date frdate = rs.getDate("frdate");
					int fhit = rs.getInt("fhit");
					String aid = rs.getString("aid");
					vo = new User_NoticeVo(fid2, ftitle, fcontent, ffile, frdate, fhit, fhit, aid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public User_NoticeVo nextNotice(String fid) {
		String sql = "select * from notice where fid = " + (Integer.parseInt(fid) + 1) + " order by fid desc";
		User_NoticeVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int fid2 = rs.getInt("fid");
					String ftitle = rs.getString("ftitle");
					String fcontent = rs.getString("fcontent");
					String ffile = rs.getString("ffile");
					Date frdate = rs.getDate("frdate");
					int fhit = rs.getInt("fhit");
					String aid = rs.getString("aid");
					vo = new User_NoticeVo(fid2, ftitle, fcontent, ffile, frdate, fhit, fhit, aid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
