package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.vo.Admin_InboundVo;
import test.db.DBConnection;

public class Admin_InboundDao {
	private static Admin_InboundDao instance=new Admin_InboundDao();
	private Admin_InboundDao() {}
	public static Admin_InboundDao getInstance() {
		return instance;
	}
	public ArrayList<Admin_InboundVo> list(int startRow, int endRow, String field, String keyword){
		String sql=null;
		if(field==null || field.equals("")) {
			sql="select * from "
					+ "("
					+ "select board.*,rownum rnum from "
					+ "("
					+ "select * from inbound order by inid desc"
					+ ") board"
					+ ") where rnum>=? and rnum<=?";
		}else {
			sql="select * from " + 
					"( " + 
					"  select board.*,rownum rnum from " + 
					"  (" + 
					"	  select * from inbound where "+ field +" like '%"+ keyword + "%' order by inid desc" + 
					"  ) board" + 
					") where rnum>=? and rnum<=?";
			 }
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				int inid=rs.getInt("inid");
				Date indate=rs.getDate("indate");
				String inname=rs.getString("inname");
				int inprice=rs.getInt("inprice");
				int inamount=rs.getInt("inamount");
				String incolor=rs.getString("incolor");
				String insize=rs.getString("insize");
				String incategory=rs.getString("incategory");
				Admin_InboundVo vo=new Admin_InboundVo(inid, indate, inname, inprice, inamount, incolor, insize, incategory);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con,pstmt,rs);
		}
	}
	public ArrayList<Admin_InboundVo> category(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select INCATEGORY, sum(inamount) as inamount,  sum(inprice) as inprice from inbound where indate > add_months(sysdate,-1) group by incategory";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				int inamount=rs.getInt("inamount");
				int inprice=rs.getInt("inprice");
				String incategory=rs.getString("incategory");
				Admin_InboundVo vo=new Admin_InboundVo(0, null, null, inprice, inamount, null, null, incategory);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con,pstmt,rs);
		}
	}
	
	public int getCount(String field, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from inbound";
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
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int insert(Admin_InboundVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into inbound values(inbound_seq.nextval,?,?,?,?,?,?,?)";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, vo.getIndate());
			pstmt.setString(2, vo.getInname());
			pstmt.setInt(3, vo.getInprice());
			pstmt.setInt(4, vo.getInamount());
			pstmt.setString(5, vo.getIncolor());
			pstmt.setString(6,vo.getInsize());
			pstmt.setString(7,vo.getIncategory());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int delete(int inid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from inbound where inid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, inid);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int update(Admin_InboundVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update inbound set indate=?, inname=?, inprice=?, inamount=?, incolor=?, insize=?, incategory=? where inid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, vo.getIndate());
			pstmt.setString(2, vo.getInname());
			pstmt.setInt(3, vo.getInprice());
			pstmt.setInt(4, vo.getInamount());
			pstmt.setString(5, vo.getIncolor());
			pstmt.setString(6,vo.getInsize());
			pstmt.setString(7,vo.getIncategory());
			pstmt.setInt(8, vo.getInid());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public Admin_InboundVo selectinid(int inid) {
		String sql="select * from inbound where inid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, inid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				inid=rs.getInt("inid");
				Date indate=rs.getDate("indate");
				String inname=rs.getString("inname");
				int inprice=rs.getInt("inprice");
				int inamount=rs.getInt("inamount");
				String incolor=rs.getString("incolor");
				String insize=rs.getString("insize");
				String incategory=rs.getString("incategory");
				Admin_InboundVo vo=new Admin_InboundVo(inid, indate, inname, inprice, inamount, incolor, insize, incategory);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
}
