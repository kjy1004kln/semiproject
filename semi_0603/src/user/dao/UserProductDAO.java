package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.User_ProductVo;

public class UserProductDAO {
	public ArrayList<User_ProductVo> Bestlist() {
		String sql = "select g.*, rownum from (select * from product order by psell desc)g where rownum>=1 and rownum<=10";
		ArrayList<User_ProductVo> list = new ArrayList<>();
		User_ProductVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int pid1 = rs.getInt("pid");
					int pprice = rs.getInt("pprice");
					int pdiscount = rs.getInt("pdiscount");
					String pimage1 = rs.getString("pimage1");
					String pimage2 = rs.getString("pimage2");
					Date prdate = rs.getDate("prdate");
					int psell = rs.getInt("psell");
					int sid = rs.getInt("sid");
					vo = new User_ProductVo(pid1, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User_ProductVo> cateBestlist() {
		String sql = "select g.*, rownum from (select * from product order by psell desc)g where rownum>=1 and rownum<=10";
		ArrayList<User_ProductVo> list = new ArrayList<>();
		User_ProductVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int pid1 = rs.getInt("pid");
					int pprice = rs.getInt("pprice");
					int pdiscount = rs.getInt("pdiscount");
					String pimage1 = rs.getString("pimage1");
					String pimage2 = rs.getString("pimage2");
					Date prdate = rs.getDate("prdate");
					int psell = rs.getInt("psell");
					int sid = rs.getInt("sid");
					vo = new User_ProductVo(pid1, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User_ProductVo> newList() {
		String sql = "select g.*, rownum from (select * from product order by prdate desc)g where rownum>=1 and rownum<=10";
		ArrayList<User_ProductVo> list = new ArrayList<>();
		User_ProductVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int pid1 = rs.getInt("pid");
					int pprice = rs.getInt("pprice");
					int pdiscount = rs.getInt("pdiscount");
					String pimage1 = rs.getString("pimage1");
					String pimage2 = rs.getString("pimage2");
					Date prdate = rs.getDate("prdate");
					int psell = rs.getInt("psell");
					int sid = rs.getInt("sid");
					vo = new User_ProductVo(pid1, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User_ProductVo> category(String category) {
		String sql = "select  DISTINCT p.* from inbound i, stock s,product p "
				+ "where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='" + category + "'";
		ArrayList<User_ProductVo> list = new ArrayList<>();
		User_ProductVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					int pid = rs.getInt("pid");
					int pprice = rs.getInt("pprice");
					int pdiscount = rs.getInt("pdiscount");
					String pimage1 = rs.getString("pimage1");
					String pimage2 = rs.getString("pimage2");
					int psid = rs.getInt("sid");
					vo = new User_ProductVo(pid, pprice, pdiscount, pimage1, pimage2, null, 0, psid);
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}

	public User_ProductVo productDetail(int pid) {
		String sql = "select pid,pprice,pdiscount,substr(pimage1,(instr(pimage1,'/',-1)+1)) as PIMAGE1,"
				+ "substr(pimage2,(instr(pimage2,'/',-1)+1)) as PIMAGE2,prdate,psell,sid from product where pid =" + pid;
		User_ProductVo vo = null;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					int pid1 = rs.getInt("pid");
					int pprice = rs.getInt("pprice");
					int pdiscount = rs.getInt("pdiscount");
					String pimage1 = rs.getString("pimage1");
					String pimage2 = rs.getString("pimage2");
					Date prdate = rs.getDate("prdate");
					int psell = rs.getInt("psell");
					int sid = rs.getInt("sid");
					vo = new User_ProductVo(pid1, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int psellplus(int orid, int pid) {
		String sql1 = "select odcount from order_detail where orid=?";
		String sql = "update product set psell = psell + ? where pid=?";
		int n = 0;
		ArrayList<Integer> orList = new ArrayList<>();
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);) {
			pstmt1.setInt(1, orid);
			try(ResultSet rs = pstmt1.executeQuery();){
				while(rs.next()) {
					int odcount = rs.getInt("odcount");
					orList.add(odcount);
				}
			}
			for (int i = 0; i < orList.size(); i++) {
				pstmt.setInt(1, orList.get(i));
				pstmt.setInt(2, pid);
				n = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
