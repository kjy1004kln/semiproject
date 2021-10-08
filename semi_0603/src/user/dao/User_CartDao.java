package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.User_CartVo;

public class User_CartDao {
	public int addcart(User_CartVo vo) {
		int n = 0;
		String sql = "insert into cart values(cart_seq.nextval,?,?,?,?,?)";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, vo.getCcolor());
			pstmt.setString(2, vo.getCsize());
			pstmt.setInt(3, vo.getCamount());
			pstmt.setString(4, vo.getMid());
			pstmt.setInt(5, vo.getPid());
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int deletecart(int wid) {
		int n = 0;
		String sql = "delete from cart where cid=?";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, wid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int deleteAll() {
		int n = 0;
		String sql = "delete from cart";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int selectDel(String wid) {
		int n = 0;
		String sql = "delete from cart where cid=?";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, wid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public ArrayList<User_CartVo> cartList() {
		String sql = "select * from cart";
		ArrayList<User_CartVo> list = new ArrayList<>();
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int wid = rs.getInt("cid");
					String scolor = rs.getString("ccolor");
					String ssize = rs.getString("csize");
					int samount = rs.getInt("camount");
					String mid = rs.getString("mid");
					int pid = rs.getInt("pid");
					User_CartVo vo = new User_CartVo(wid, scolor, ssize, samount, mid, pid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
