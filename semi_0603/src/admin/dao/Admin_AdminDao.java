package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import admin.vo.Admin_AdminVo;
import test.db.DBConnection;

public class Admin_AdminDao {
	public Admin_AdminVo getinfo(String aid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from head_admin where aid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String aid1=rs.getString("aid");
				String apw=rs.getString("apw");
				String aname=rs.getString("aname");
				Date ardate=rs.getDate("ardate");
				Admin_AdminVo vo=new Admin_AdminVo(aid1, apw, aname, ardate);
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int insert(Admin_AdminVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="insert into head_admin values(?,?,?,,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAid());
			pstmt.setString(2, vo.getApw());
			pstmt.setString(3, vo.getAname());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
}
