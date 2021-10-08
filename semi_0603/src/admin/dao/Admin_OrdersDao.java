package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.vo.Admin_OrderVo;
import test.db.DBConnection;

public class Admin_OrdersDao {
	private static Admin_OrdersDao instance=new Admin_OrdersDao();
	private Admin_OrdersDao() {}
	public static Admin_OrdersDao getInstance() {
		return instance;
	}
	public int ordelivery_update(int orid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="update orders set ordelivery='Y' where orid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,orid);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int orcomplete_update(int orid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="update orders set orcomplete='Y' where orid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,orid);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	//배송중
	public ArrayList<Admin_OrderVo> ordelivery(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from orders where ordelivery='N'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_OrderVo> list=new ArrayList<Admin_OrderVo>();
			while(rs.next()) {
				int orid=rs.getInt("orid");
				Date ordate=rs.getDate("ordate");
				String orname=rs.getString("orname");
				String orphone=rs.getString("orphone");
				String oraddress=rs.getString("oraddress");
				String orpost=rs.getString("orpost");
				String orpayment=rs.getString("orpayment");
				int orinvoice=rs.getInt("orinvoice");
				int ordelpay=rs.getInt("ordelpay");
				String ordelivery=rs.getString("ordelivery");
				String orcomplete=rs.getString("orcomplete");
				String orcancle=rs.getString("orcancle");
				String mid=rs.getString("mid");
				Admin_OrderVo vo=new Admin_OrderVo(orid, ordate, orname, orphone, oraddress, orpost, orpayment, orinvoice, ordelpay, ordelivery, orcomplete, orcancle, mid);
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
	//배송완료
	public ArrayList<Admin_OrderVo> ordelivery_completion(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from orders where ordelivery='Y' and orcomplete='N'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_OrderVo> list=new ArrayList<Admin_OrderVo>();
			while(rs.next()) {
				int orid=rs.getInt("orid");
				Date ordate=rs.getDate("ordate");
				String orname=rs.getString("orname");
				String orphone=rs.getString("orphone");
				String oraddress=rs.getString("oraddress");
				String orpost=rs.getString("orpost");
				String orpayment=rs.getString("orpayment");
				int orinvoice=rs.getInt("orinvoice");
				int ordelpay=rs.getInt("ordelpay");
				String ordelivery=rs.getString("ordelivery");
				String orcomplete=rs.getString("orcomplete");
				String orcancle=rs.getString("orcancle");
				String mid=rs.getString("mid");
				Admin_OrderVo vo=new Admin_OrderVo(orid, ordate, orname, orphone, oraddress, orpost, orpayment, orinvoice, ordelpay, ordelivery, orcomplete, orcancle, mid);
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
	//구매확정
	public ArrayList<Admin_OrderVo> orcomplete(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from orders where ordelivery='Y' and orcomplete='Y'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_OrderVo> list=new ArrayList<Admin_OrderVo>();
			while(rs.next()) {
				int orid=rs.getInt("orid");
				Date ordate=rs.getDate("ordate");
				String orname=rs.getString("orname");
				String orphone=rs.getString("orphone");
				String oraddress=rs.getString("oraddress");
				String orpost=rs.getString("orpost");
				String orpayment=rs.getString("orpayment");
				int orinvoice=rs.getInt("orinvoice");
				int ordelpay=rs.getInt("ordelpay");
				String ordelivery=rs.getString("ordelivery");
				String orcomplete=rs.getString("orcomplete");
				String orcancle=rs.getString("orcancle");
				String mid=rs.getString("mid");
				Admin_OrderVo vo=new Admin_OrderVo(orid, ordate, orname, orphone, oraddress, orpost, orpayment, orinvoice, ordelpay, ordelivery, orcomplete, orcancle, mid);
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
	//취소환불
	public ArrayList<Admin_OrderVo> orcancle(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from orders where orcancle='Y'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_OrderVo> list=new ArrayList<Admin_OrderVo>();
			while(rs.next()) {
				int orid=rs.getInt("orid");
				Date ordate=rs.getDate("ordate");
				String orname=rs.getString("orname");
				String orphone=rs.getString("orphone");
				String oraddress=rs.getString("oraddress");
				String orpost=rs.getString("orpost");
				String orpayment=rs.getString("orpayment");
				int orinvoice=rs.getInt("orinvoice");
				int ordelpay=rs.getInt("ordelpay");
				String ordelivery=rs.getString("ordelivery");
				String orcomplete=rs.getString("orcomplete");
				String orcancle=rs.getString("orcancle");
				String mid=rs.getString("mid");
				Admin_OrderVo vo=new Admin_OrderVo(orid, ordate, orname, orphone, oraddress, orpost, orpayment, orinvoice, ordelpay, ordelivery, orcomplete, orcancle, mid);
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
}
