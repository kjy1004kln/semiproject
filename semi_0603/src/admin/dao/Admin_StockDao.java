package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.startup.ConnectorCreateRule;

import admin.vo.Admin_StockVo;
import test.db.DBConnection;

public class Admin_StockDao {
	private static Admin_StockDao instance=new Admin_StockDao();
	private Admin_StockDao() {}
	public static Admin_StockDao getInstance() {
		return instance;
	}
	public ArrayList<Admin_StockVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from stock where slev=0 order by sid asc";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_StockVo> list=new ArrayList<Admin_StockVo>();
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String scolor=rs.getString("scolor");
				String ssize=rs.getString("ssize");
				int samount=rs.getInt("samount");
				Admin_StockVo vo=new Admin_StockVo(sid, sname, scolor, ssize, samount,0);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public ArrayList<Admin_StockVo> alllist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from stock";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_StockVo> list=new ArrayList<Admin_StockVo>();
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String scolor=rs.getString("scolor");
				String ssize=rs.getString("ssize");
				int samount=rs.getInt("samount");
				int slev=rs.getInt("slev");
				Admin_StockVo vo=new Admin_StockVo(sid, sname, scolor, ssize, samount,slev);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public ArrayList<Admin_StockVo> agglist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select sname,listagg(scolor,',') within group(order by scolor) as scolor,listagg(ssize,',') within group(order by ssize) as ssize, sum(samount) as samount from stock where slev=0 group by sname";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_StockVo> list=new ArrayList<Admin_StockVo>();
			while(rs.next()) {
				String sname=rs.getString("sname");
				String scolor=rs.getString("scolor");
				String ssize=rs.getString("ssize");
				int samount=rs.getInt("samount");
				Admin_StockVo vo=new Admin_StockVo(0, sname, scolor, ssize, samount,0);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	public int update(Admin_StockVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update stock set sname=?,scolor=?,ssize=?,samount=? where sid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getScolor());
			pstmt.setString(3, vo.getSsize());
			pstmt.setInt(4, vo.getSamount());
			pstmt.setInt(5, vo.getSid());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int updatelev(String sname) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update stock set slev=1 where sname=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, sname);
			int n= pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int updatelev2(String sname) {//sid 다시 돌려놓기
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update stock set slev=0 where sname=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, sname);
			int n= pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int insert(Admin_StockVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into stock values(STOCK_seq.nextval,?,?,?,?,0)";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getScolor());
			pstmt.setString(3, vo.getSsize());
			pstmt.setInt(4, vo.getSamount());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public Admin_StockVo selectsid(int sid) {
		String sql="select * from stock where sid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String scolor=rs.getString("scolor");
				String ssize=rs.getString("ssize");
				int samount=rs.getInt("samount");
				Admin_StockVo vo=new Admin_StockVo(sid, sname, scolor, ssize, samount,0);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con,pstmt,rs);
		}
	}
	public int delete(int sid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from stock where sid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
}
