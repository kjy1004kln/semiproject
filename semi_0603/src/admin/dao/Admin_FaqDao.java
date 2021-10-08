package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.vo.Admin_FaqVo;
import admin.vo.Admin_MembersVo;
import test.db.DBConnection;

public class Admin_FaqDao {
	public Admin_FaqVo detail(int fid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select * from faq where fid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fid = rs.getInt("fid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fpublic_private = rs.getInt("fpublic_private");
				String aid = rs.getString("aid");
				Admin_FaqVo vo = new Admin_FaqVo(fid, ftitle, fcontent, frdate, fhit, fpublic_private, aid);
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
	public ArrayList<Admin_FaqVo> publiclist(int startRow,int endRow,String field,String keyword){
		String sql=null;
		if(field==null || field.equals("")) { 
		    sql= "select * from " + 
				"( " + 
				"  select board.*,rownum rnum from " + 
				"  (" + 
				"	  select * from faq order by fid desc" + 
				"  ) board" + " where fpublic_private=1" +
				") where rnum>=? and rnum<=?";
		}else{ 
			sql="select * from " + 
				"( " + 
				"  select board.*,rownum rnum from " + 
				"  (" + 
				"	  select * from faq where "+ field +" like '%"+ keyword + "%' order by fid desc" + 
				"  ) board" + " where fpublic_private=1" +
				") where rnum>=? and rnum<=?";
		 }
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_FaqVo> list=new ArrayList<Admin_FaqVo>();
			while(rs.next()) {
				Admin_FaqVo vo=new Admin_FaqVo(
						rs.getInt("fid"),
						rs.getString("ftitle"),
						rs.getString("fcontent"), 
						rs.getDate("frdate"),
						rs.getInt("fhit"),
						rs.getInt("fpublic_private"),
						rs.getString("aid"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public ArrayList<Admin_FaqVo> privatelist(int startRow,int endRow,String field,String keyword){
		String sql=null;
		if(field==null || field.equals("")) { 
		    sql= "select * from " + 
				"( " + 
				"  select board.*,rownum rnum from " + 
				"  (" + 
				"	  select * from faq order by fid desc" + 
				"  ) board" + " where fpublic_private=0" +
				") where rnum>=? and rnum<=?";
		}else{ 
			sql="select * from " + 
				"( " + 
				"  select board.*,rownum rnum from " + 
				"  (" + 
				"	  select * from faq where "+ field +" like '%"+ keyword + "%' order by fid desc" + 
				"  ) board" + " where fpublic_private=0" +
				") where rnum>=? and rnum<=?";
		 }
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_FaqVo> list=new ArrayList<Admin_FaqVo>();
			while(rs.next()) {
				Admin_FaqVo vo=new Admin_FaqVo(
						rs.getInt("fid"),
						rs.getString("ftitle"),
						rs.getString("fcontent"), 
						rs.getDate("frdate"),
						rs.getInt("fhit"),
						rs.getInt("fpublic_private"),
						rs.getString("aid"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int getCount(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from faq";
			if(field!=null && !field.equals("")) {
				sql += " where " + field + " like '%" + keyword +"%'";
			}		
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int getCountprivate(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from faq where fpublic_private=0";
			if(field!=null && !field.equals("")) {
				sql += " where " + field + " like '%" + keyword +"%'";
			}		
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int getCountpublic(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from faq where fpublic_private=1";
			if(field!=null && !field.equals("")) {
				sql += " where " + field + " like '%" + keyword +"%'";
			}		
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int insert(Admin_FaqVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="insert into faq values(seq.nextval,?,?,sysdate,0,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getFtitle());
			pstmt.setString(2, vo.getFcontent());
			pstmt.setInt(3, vo.getFpublic_private());
			pstmt.setString(4, vo.getAid());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int update(Admin_FaqVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="update faq set ftitle=?, fcontent=?, fpublic_private=? where fid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getFtitle());
			pstmt.setString(2, vo.getFcontent());
			pstmt.setInt(3, vo.getFpublic_private());
			pstmt.setInt(4, vo.getFid());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int delete(int fid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="delete from faq where fid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, fid);
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
}
