package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.vo.Admin_InboundVo;
import admin.vo.Admin_ProductVo;
import admin.vo.Admin_StockVo;
import test.db.DBConnection;
import user.vo.UserQnaVo;
import user.vo.User_MembersVo;

public class Admin_ChartDao {
	private static Admin_ChartDao instance=new Admin_ChartDao();
	private Admin_ChartDao() {}
	public static Admin_ChartDao getInstacne() {
		return instance;
	}
	public ArrayList<Admin_InboundVo> inbound_2019(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(indate,'mm') as month,"
					+ "sum(inprice) as cnt "
					+ "FROM inbound "
					+ "WHERE indate >='2019-01-01' AND indate <= '2019-12-31' "
					+ "GROUP BY to_char(indate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				int inprice=rs.getInt("cnt");
				Admin_InboundVo vo=new Admin_InboundVo(0, null,null, inprice,0,null,null,null);
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
	
	
	public ArrayList<Admin_ProductVo> product_2019(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(prdate,'mm') as month,"
					+ "sum((pprice*psell)-(pprice/100*pdiscount)) as cnt "
					+ "FROM product "
					+ "WHERE prdate >='2019-01-01' AND prdate <= '2019-12-31' "
					+ "GROUP BY to_char(prdate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo> list=new ArrayList<Admin_ProductVo>();
			while(rs.next()) {
				int pprice=rs.getInt("cnt");
				Admin_ProductVo vo=new Admin_ProductVo(0, pprice, 0, null, null, null, 0, 0);
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
	public ArrayList<Admin_InboundVo> inbound_year(String fryear, String endyear){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(indate,'mm') as month,"
					+ "sum(inprice) as cnt "
					+ "FROM inbound "
					+ "WHERE indate >=? AND indate <= ? "
					+ "GROUP BY to_char(indate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, fryear);
			pstmt.setString(2, endyear);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				int inprice=rs.getInt("cnt");
				Admin_InboundVo vo=new Admin_InboundVo(0, null,null, inprice,0,null,null,null);
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
	public ArrayList<Admin_ProductVo> product_year(String fryear, String endyear){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(prdate,'mm') as month,"
					+ "sum((pprice*psell)-(pprice/100*pdiscount)) as cnt "
					+ "FROM product "
					+ "WHERE prdate >=? AND prdate <= ? "
					+ "GROUP BY to_char(prdate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, fryear);
			pstmt.setString(2, endyear);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo> list=new ArrayList<Admin_ProductVo>();
			while(rs.next()) {
				int pprice=rs.getInt("cnt");
				Admin_ProductVo vo=new Admin_ProductVo(0, pprice, 0, null, null, null, 0, 0);
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
	public UserQnaVo qlist(int qlev){
		String sql="select count(*) qid from userqna where qlev=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qlev);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int qid = rs.getInt("qid");
				UserQnaVo vo=new UserQnaVo(qid, null, null, null, null, null, null, 0,0,0,null,0);
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
	public ArrayList<User_MembersVo> joinmember(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(mrdate,'mm') as month,"
					+ "count(mid) as cnt "
					+ "FROM members "
					+ "GROUP BY to_char(mrdate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<User_MembersVo> list=new ArrayList<User_MembersVo>();
			while(rs.next()) {
				int mmileage=rs.getInt("cnt");
				User_MembersVo vo=new User_MembersVo(null, null, null, null, null, null,null, null, 0, mmileage, null, null, null, null);
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
	public ArrayList<User_MembersVo> adultmember(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(mrdate,'mm') as month,"
					+ "count(mid) as cnt "
					+ "FROM members "
					+ "where trunc(months_between(sysdate,mbirth)/12) > 18 "
					+ "GROUP BY to_char(mrdate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<User_MembersVo> list=new ArrayList<User_MembersVo>();
			while(rs.next()) {
				int mmileage=rs.getInt("cnt");
				User_MembersVo vo=new User_MembersVo(null, null, null, null, null, null,null, null, 0, mmileage, null, null, null, null);
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
	public ArrayList<User_MembersVo> minormember(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select a.month, nvl(b.cnt,0) cnt from "
					+ "(select 1 month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 2 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 3 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 4 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 5 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 6 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 7 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 8 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 9 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 10 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 11 as month, 0 as cnt "
					+ "from dual "
					+ "union all "
					+ "select 12 as month, 0 as cnt "
					+ "from dual "
					+ ")a left outer join ("
					+ "SELECT to_char(mrdate,'mm') as month,"
					+ "count(mid) as cnt "
					+ "FROM members "
					+ "where trunc(months_between(sysdate,mbirth)/12) <= 18  "
					+ "GROUP BY to_char(mrdate,'mm') "
					+ ") b "
					+ "on a.month = b.month "
					+ "ORDER BY a.month";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<User_MembersVo> list=new ArrayList<User_MembersVo>();
			while(rs.next()) {
				int mmileage=rs.getInt("cnt");
				User_MembersVo vo=new User_MembersVo(null, null, null, null, null, null,null, null, 0, mmileage, null, null, null, null);
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
	public ArrayList<Admin_StockVo> underlist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select sname,samount from stock where samount <50";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_StockVo> list=new ArrayList<Admin_StockVo>();
			while(rs.next()) {
				String sname=rs.getString("sname");
				int samount=rs.getInt("samount");
				Admin_StockVo vo=new Admin_StockVo(0, sname,null , null, samount, 0);
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
	public ArrayList<Admin_InboundVo> categorylist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select incategory, sum(inamount) as inamount from inbound group by incategory";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				String incategory=rs.getString("incategory");
				int inamount=rs.getInt("inamount");
				Admin_InboundVo vo=new Admin_InboundVo(0, null, null, 0, inamount, null, null, incategory);
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
