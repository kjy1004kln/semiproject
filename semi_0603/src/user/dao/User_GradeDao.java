package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.db.DBConnection;
import user.vo.User_GradeVo;

public class User_GradeDao {
	public User_GradeVo getGrade(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int n=0;
		String sql="select * from grade where mid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int gid=rs.getInt("gid");
				String glevel=rs.getString("glevel");
				int gbuy=rs.getInt("gbuy");
				User_GradeVo vo=new User_GradeVo(gid,glevel,gbuy,id);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con,pstmt,rs);;
		}
	}
}
