package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.UserStockVo;

public class UserStockDAO {

	public String sid(int sid) {
		String sql = "select sname from stock where sid=?";
		String sname = "";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, sid);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					sname = rs.getString("sname");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sname;
	}

	public UserStockVo stockDetail(int sid) {
		String sql = "select * from stock where sid=?";
		UserStockVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, sid);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int sid1 = rs.getInt("sid");
					String sname = rs.getString("sname");
					String scolor = rs.getString("scolor");
					String ssize = rs.getString("ssize");
					int samount = rs.getInt("samount");
					vo = new UserStockVo(sid1, sname, scolor, ssize, samount);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public ArrayList<String> chooseColor(String sname) {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select scolor from stock where sname = '" + sname + "'";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					String scolor = rs.getString("scolor");
					list.add(scolor);
					for (int i = 0; i < list.size(); i++) {
						for (int j = i + 1; j < list.size(); j++) {
							if (list.get(i).equals(list.get(j))) {
								list.remove(j);
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> chooseSize(String color, String sname) {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select ssize from stock where sname = '" + sname + "' and scolor ='" + color + "'";
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					String ssize = rs.getString("ssize");
					list.add(ssize);
					for (int i = 0; i < list.size(); i++) {
						for (int j = i + 1; j < list.size(); j++) {
							if (list.get(i).equals(list.get(j))) {
								list.remove(j);
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int sellamount(int odid, int pid, String color, String size) {
		String sql1 = "select odcount from order_detail where orid=?";
		String sql = "update stock set samount= samount-? where sid=(select sid from stock where sname=(select sname from stock where sid=(select sid from product where pid=?)) and scolor=? and ssize=?)";
		int n = 0;
		ArrayList<Integer> odList = new ArrayList<>();
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);
				 PreparedStatement pstmt1 = con.prepareStatement(sql1);) {
			pstmt1.setInt(1, odid);
			try(ResultSet rs = pstmt1.executeQuery();){
				while(rs.next()) {
					int odcount = rs.getInt("odcount");
					odList.add(odcount);
				}
			}
			for (int i = 0; i < odList.size(); i++) {
				pstmt.setInt(1, odList.get(i));
				pstmt.setInt(2, pid);
				pstmt.setString(3, color);
				pstmt.setString(4, size);
				n = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
