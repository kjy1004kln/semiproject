package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.UserQnaVo;
import user.vo.User_GoReviewVo;
import user.vo.User_ProductReview;
import user.vo.User_ReviewVo;

public class User_ReviewDao { 
	public int getMaxNum() {//rid
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(max(rid),0) rid from review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int rid = rs.getInt("rid");
			return rid;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	//리뷰작성
	public int insertReview(String id, String rtitle, String rcontent, String rphoto1, int sid) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		String sql=null;
		try {
			con = DBConnection.getCon();
			int rid=getMaxNum()+1;
			if(rphoto1==null || rphoto1.equals("")) {
				System.out.println("sid:"+sid);
				sql = "insert into review values(?,null,?,?,null,'Y',null,sysdate,0,'" +id+ "', '" +sid+ "')"; //사진이 없는 리뷰
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setInt(1, rid);
				pstmt1.setString(2, rtitle);
				pstmt1.setString(3, rcontent);
			}else {
				sql = "insert into review values(?,null,?,?,?,'Y',null,sysdate,0,'" +id+ "', '" +sid+ "')"; //사진이 1개만 있는 리뷰
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setInt(1, rid);
				pstmt1.setString(2, rtitle);
				pstmt1.setString(3, rcontent);
				pstmt1.setString(4, rphoto1);
			}
			int n=pstmt1.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt1, null);
		}
	}
	public int checkReview(String id, int sid, String sname, String odcolor, String odsize) { //리뷰 여부 체크
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		String sql=null;
		try {
			con = DBConnection.getCon();
			sql=" select rid from review " + 
					"    where mid=? and sid=  " + 
					"    (select sid from stock s, order_detail od where sid=? and sname=? and od.odcolor=? and od.odsize=?)";
			pstmt.setString(1, id);
			pstmt.setInt(2, sid);
			pstmt.setString(3, sname);
			pstmt.setString(4, odcolor);
			pstmt.setString(5, odsize);
			pstmt=con.prepareStatement(sql);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	//productDetail.jsp 상세페이지 리뷰 목록 뜨게하기
	public ArrayList<User_ProductReview> PDRlist(String sname, int startRow, int endRow) { //목록 불러오기
		ArrayList<User_ProductReview> list = new ArrayList<>();
		String sql ="select * from (select r.mid,s.sname,r.rtitle,r.rcontent,substr(r.rphoto1,(instr(r.rphoto1,'/',-1)+1)) as rphoto1,r.rrdate,s.scolor,s.ssize"
				+" from review r ,stock s where r.sid = s.sid and s.sname = ?) where rownum>=? and rownum<=?";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, sname);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					String mid = rs.getString("mid");
					String sname1 = rs.getString("sname");
					String rtitle = rs.getString("rtitle");
					String rcontent = rs.getString("rcontent");
					String rphoto1 = rs.getString("rphoto1");
					Date rrdate = rs.getDate("rrdate");
					String scolor = rs.getString("scolor");
					String ssize = rs.getString("ssize");
					
					User_ProductReview vo = new User_ProductReview(mid,sname1,rtitle,rcontent,rphoto1,rrdate,scolor,ssize);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getCount(String id) { //상세페이지 리뷰 전체글 개수
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(*),0) from review where mid=? ";
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
}
