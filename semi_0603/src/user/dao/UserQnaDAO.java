package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.UserQnaVo;

public class UserQnaDAO {
	public UserQnaVo productQnaList(int pid) {
		UserQnaVo vo = null;
		String sql = "select * from userqna where pid = " + pid;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int qid = rs.getInt("qid");
					String qcate = rs.getString("qcate");
					String qpw = rs.getString("qpw");
					String qtitle = rs.getString("qtitle");
					String qcontent = rs.getString("qcontent");
					String qfile = rs.getString("qfile");
					Date qrdate = rs.getDate("qrdate");
					int qlev = rs.getInt("qlev");
					int qref = rs.getInt("qref");
					String mid = rs.getString("mid");
					int pid1 = rs.getInt("pid");
					int qstep = rs.getInt("qstep");
					vo = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public ArrayList<UserQnaVo> list(int startRow, int endRow) {
		UserQnaVo vo = null;
		ArrayList<UserQnaVo> list = new ArrayList<>();
		String sql = "select * from (select g.*,rownum rnum from (select * from userqna order by qid desc) g) where rnum>=? and rnum<=?";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int qid = rs.getInt("qid");
					String qcate = rs.getString("qcate");
					String qpw = rs.getString("qpw");
					String qtitle = rs.getString("qtitle");
					String qcontent = rs.getString("qcontent");
					String qfile = rs.getString("qfile");
					Date qrdate = rs.getDate("qrdate");
					int qlev = rs.getInt("qlev");
					int qref = rs.getInt("qref");
					String mid = rs.getString("mid");
					int pid1 = rs.getInt("pid");
					int qstep = rs.getInt("qstep");
					UserQnaVo vo1 = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid1);
					list.add(vo1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<UserQnaVo> findlist(int startRow, int endRow, String field, String keyword) {
		UserQnaVo vo = null;
		ArrayList<UserQnaVo> list = new ArrayList<>();
		String sql = "select * from (select g.*,rownum rnum from ((select * from userqna where " + field + " like '%"
				+ keyword + "%')g)) where rnum>=? and rnum<=?";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int qid = rs.getInt("qid");
					String qcate = rs.getString("qcate");
					String qpw = rs.getString("qpw");
					String qtitle = rs.getString("qtitle");
					String qcontent = rs.getString("qcontent");
					String qfile = rs.getString("qfile");
					Date qrdate = rs.getDate("qrdate");
					int qlev = rs.getInt("qlev");
					int qref = rs.getInt("qref");
					String mid = rs.getString("mid");
					int pid1 = rs.getInt("pid");
					int qstep = rs.getInt("qstep");
					UserQnaVo vo1 = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid1);
					list.add(vo1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getCount(String field, String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(*),0) from userqna";
			if (field != null && !field.equals("")) {
				sql += " where " + field + " like '%" + keyword + "%'";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int n = rs.getInt(1);
				return n;
			}
			return -1;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public ArrayList<UserQnaVo> qlist(int qlev) {
		String sql = "select * from userqna where qlev=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qlev);
			rs = pstmt.executeQuery();
			ArrayList<UserQnaVo> list = new ArrayList<UserQnaVo>();
			while (rs.next()) {
				int qid = rs.getInt("qid");
				String qcate = rs.getString("qcate");
				String qpw = rs.getString("qpw");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qfile = rs.getString("qfile");
				Date qrdate = rs.getDate("qrdate");
				qlev = rs.getInt("qlev");
				int qref = rs.getInt("qref");
				String mid = rs.getString("mid");
				int pid = rs.getInt("pid");
				int qstep = rs.getInt("qstep");
				UserQnaVo vo = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid);
				list.add(vo);
			}
			return list;
		} catch (SQLException s) {
			s.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public ArrayList<UserQnaVo> all_list(int startRow, int endRow, String field, String keyword) {
		String sql = null;
		if (field == null || field.equals("")) {
			sql = "select * from " + "( " + "  select board.*,rownum rnum from " + "  ("
					+ "     select * from userqna order by qref desc, qstep asc" + "  ) board" + ") where rnum>=? and rnum<=?";
		} else {
			sql = "select * from " + "( " + "  select board.*,rownum rnum from " + "  ("
					+ "     select * from userqna where " + field + " like '%" + keyword + "%' order by qref desc, qstep asc"
					+ "  ) board" + ") where rnum>=? and rnum<=?";
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<UserQnaVo> qlist = new ArrayList<UserQnaVo>();
			while (rs.next()) {
				int qid = rs.getInt("qid");
				String qcate = rs.getString("qcate");
				String qpw = rs.getString("qpw");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qfile = rs.getString("qfile");
				Date qrdate = rs.getDate("qrdate");
				int qlev = rs.getInt("qlev");
				int qref = rs.getInt("qref");
				String mid = rs.getString("mid");
				int pid = rs.getInt("pid");
				int qstep = rs.getInt("qstep");
				UserQnaVo vo = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid);
				qlist.add(vo);
			}
			return qlist;
		} catch (SQLException s) {
			s.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public UserQnaVo detail(int qid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select * from userqna where qid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qid = rs.getInt("qid");
				String qcate = rs.getString("qcate");
				String qpw = rs.getString("qpw");
				String qtitle = rs.getString("qtitle");
				String qcontent = rs.getString("qcontent");
				String qfile = rs.getString("qfile");
				Date qrdate = rs.getDate("qrdate");
				int qlev = rs.getInt("qlev");
				int qref = rs.getInt("qref");
				String mid = rs.getString("mid");
				int pid = rs.getInt("pid");
				int qstep = rs.getInt("qstep");
				UserQnaVo vo = new UserQnaVo(qid, qcate, qpw, qtitle, qcontent, qfile, qrdate, qlev, qref, qstep, mid, pid);
				return vo;
			}
			return null;
		} catch (SQLException s) {
			s.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(max(qid),0) qid from userqna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int qid = rs.getInt("qid");
			return qid;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int reply(UserQnaVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
	
		try {
			con = DBConnection.getCon();
			int boardNum=getMaxNum()+1;
			int qid=vo.getQid();
			int qref = vo.getQref();
			int qlev = vo.getQlev();
			int qstep = vo.getQstep();
			
				String sql="update userqna set qstep=qstep+1 where qref=? and qstep>? ";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,qref);
				pstmt.setInt(2,qstep);
				pstmt.executeUpdate();
				qlev+=1;
				qstep+=1;
						
			String sql1="insert into userqna values(?,?,?,?,?,?,sysdate,?,?,?,?,?)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, boardNum);
			pstmt1.setString(2, vo.getQcate());
			pstmt1.setString(3, vo.getQpw());
			pstmt1.setString(4, vo.getQtitle());
			pstmt1.setString(5, vo.getQcontent());
			pstmt1.setString(6, vo.getQfile());
			pstmt1.setInt(7, qlev);
			pstmt1.setInt(8, qref);
			pstmt1.setString(9, vo.getMid());
			pstmt1.setInt(10, vo.getPid());
			pstmt1.setInt(11, qstep);
			return pstmt1.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(con);
		}
	}
	public int insert(UserQnaVo vo) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=DBConnection.getCon();
			int qid=getMaxNum()+1;
			int qref=vo.getQref();
			int qlev=vo.getQlev();
			int qstep=vo.getQstep();
			if(qref==0) {
				qref=qid;
			}
					
			String sql="insert into userqna values(?,?,?,?,?,?,sysdate,?,?,?,?,?)";
			pstmt1=con.prepareStatement(sql);
			pstmt1.setInt(1, qid);
			pstmt1.setString(2, vo.getQcate());
			pstmt1.setString(3, vo.getQpw());
			pstmt1.setString(4, vo.getQtitle());
			pstmt1.setString(5, vo.getQcontent());
			pstmt1.setString(6, vo.getQfile());
			pstmt1.setInt(7, qlev);
			pstmt1.setInt(8, qref);
			pstmt1.setInt(9, qstep);
			pstmt1.setString(10, vo.getMid());
			pstmt1.setInt(11, vo.getPid());
			return pstmt1.executeUpdate();
			//테스트
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(pstmt2);
			DBConnection.close(pstmt1);
			DBConnection.close(con);
		}
	}
}
