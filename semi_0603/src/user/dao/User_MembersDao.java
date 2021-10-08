package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.User_MembersVo;

public class User_MembersDao {
	
	public int findaccount(String id, String pwd) { // 로그인
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n = 0;
		try {
			con = DBConnection.getCon();
			String sql = "select * from members where mid=? and mpw=? and mdrop='0'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				n = 1;
			}
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int join(String mid, String mpw, String mname, String mphone, String memail) { // 회원가입
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String sql = "insert into members(mid, mpw,mname,mphone,mrdate,mdrop, mmileage,memail) "
				+ "values(?,?,?,?,sysdate,0,1000,?)";
		String sql1 = "insert into grade values(GRADE_seq.nextval,'friend',0,?)";
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt1 = con.prepareStatement(sql1);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			pstmt.setString(3, mname);
			pstmt.setString(4, mphone);
			pstmt.setString(5, memail);
			pstmt1.setString(1, mid);
			int n = pstmt.executeUpdate();
			int n1 = pstmt1.executeUpdate();
			return 1;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	public boolean idcheck(String id) { //아이디 중복확인
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select mid from members where mid=?";
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, id);
			if (rs.next()) {
				if (rs.getString("id").equals(id)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return false;
	}

	public int passcheck(String id, String pwd) { // 비밀번호 더블체크
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n = 0;
		try {
			con = DBConnection.getCon();
			String sql = "select * from members where mid=? and mpw=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				n = 1;
			}
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int delAccount(String mid) { // 회원탈퇴
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getCon();
			String sql = "update members set mdrop='1' where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	public User_MembersVo findInfo(String id) { // update.jsp에 정보 뜨게하기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select * from members where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String maddress = rs.getString("maddress");
				String mpost = rs.getString("mpost");
				String mphone = rs.getString("mphone");
				Date mrdate = rs.getDate("mrdate");
				Date mbirth = rs.getDate("mbirth");
				int mdrop = rs.getInt("mdrop");
				int mmileage = rs.getInt("mmileage");
				String memail = rs.getString("memail");
				String addphone = rs.getString("addphone");
				String addname = rs.getString("addname");
				String addtitle = rs.getString("addtitle");
				User_MembersVo vo = new User_MembersVo(mid, mpw, mname, maddress, mpost, mphone, mrdate, mbirth, mdrop,
						mmileage, memail, addphone, addname, addtitle);
				return vo;
			} else {
				return null;
			}

		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int updateInfo(User_MembersVo vo) {// 개인정보 수정
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = DBConnection.getCon();
			String sql = "update members set mpw=?, mphone=?, memail=?, mbirth=? where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMphone());
			pstmt.setString(3, vo.getMemail());
			pstmt.setDate(4, vo.getMbirth());
			pstmt.setString(5, vo.getMid());
			n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	public int addInsert(User_MembersVo vo) { // 배송지 추가
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		String sql = "update members set addtitle=?,addname=?,addphone=?,maddress=?,mpost=? where mid=?";
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getAddtitle());
			pstmt.setString(2, vo.getAddname());
			pstmt.setString(3, vo.getAddphone());
			pstmt.setString(4, vo.getMaddress());
			pstmt.setString(5, vo.getMpost());
			pstmt.setString(6, vo.getMid());
			n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	public ArrayList<User_MembersVo> list(String id) { //배송지 목록
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where mid=?";
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			ArrayList<User_MembersVo> list = new ArrayList<User_MembersVo>();
			while (rs.next()) {
				String addtitle = rs.getString("addtitle");
				String addname = rs.getString("addname");
				String addphone = rs.getString("addphone");
				String maddress = rs.getString("maddress");
				String mpost = rs.getString("mpost");
				User_MembersVo vo = new User_MembersVo(id, null, null, maddress, mpost, null, null, null, 0, 0, null,
						addtitle, addname, addphone);
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int delAdd(String id) { // 배송지 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		String sql = "update members set addtitle=null,addname=null,addphone=null,maddress=null, mpost=null where mid=?";
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	public User_MembersVo findAdd(String id) { // 배송지 수정을 위한 값 불러오기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select * from members where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String addtitle = rs.getString("addtitle");
				String addname = rs.getString("addname");
				String addphone = rs.getString("addphone");
				String maddress = rs.getString("maddress");
				String mpost = rs.getString("mpost");
				User_MembersVo vo = new User_MembersVo(id, null, null, maddress, mpost, null, null, null, 0, 0, null,
						addtitle, addname, addphone);
				return vo;
			} else {
				return null;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int updateAdd(User_MembersVo vo) { // 배송지 수정
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = DBConnection.getCon();
			String sql = "update members set addtitle=?, addname=?, addphone=?, maddress=? where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getAddtitle());
			pstmt.setString(2, vo.getAddname());
			pstmt.setString(3, vo.getAddphone());
			pstmt.setString(4, vo.getMaddress());
			pstmt.setString(5, vo.getMid());
			n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int getCountOrder(String id) { //마이페이지 총주문 횟수
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
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
	public int getCountTotal(String id) { //마이페이지 총주문 합계
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select sum(orpaymoney) from orders where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int n = rs.getInt(1);
				return n;
			}
			return 0;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
//	상품을 구매했을때 마일리지 쌓이게 추가하기
	public int addMil(int addMil, String mid) {
		String sql = "update members set mmileage = mmileage+? where mid = ?";
		int n = 0;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, addMil);
			pstmt.setString(2, mid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
