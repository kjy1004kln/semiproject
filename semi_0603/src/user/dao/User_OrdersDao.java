package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBConnection;
import user.vo.UserOrderlistVo;

public class User_OrdersDao {
	public ArrayList<UserOrderlistVo> OrderList(int startRow, int endRow, String field, String id, String startdate,
			String enddate) { // string인지 date인지 확인
		String sql = null;
		if (field == null || field.equals("")) {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete, o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid , s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) where ordate>=sysdate-90 and ordate<=sysdate";
		} else if (field.equals("orderall")) {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=?";
		} else if (field.equals("halfway")) {
			sql = " select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) "
					+ "where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=? and ordelivery = 'N'";
		} else if (field.equals("finish")) {
			sql = " select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?)"
					+ " where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=? and ordelivery = 'Y'";
		} else if (field.equals("cancel")) {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname , od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) "
					+ "where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=? and ordelivery ='N' and orcancle ='Y'";
		} else if (field.equals("return")) {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname , od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) "
					+ "where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=? and ordelivery ='Y' and orcancle ='Y'";
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			if (startdate != null && enddate != null) {
				pstmt.setString(2, startdate);
				pstmt.setString(3, enddate);
			}
			rs = pstmt.executeQuery();
			ArrayList<UserOrderlistVo> list = new ArrayList<UserOrderlistVo>();
			while (rs.next()) {
				Date ordate = rs.getDate("ordate");
				int orid = rs.getInt("orid");
				String pimage2 = rs.getString("pimage2");
				String sname = rs.getString("sname");
				String odcolor = rs.getString("odcolor");
				String odsize = rs.getString("odsize");
				int odcount = rs.getInt("odcount");
				int pprice = rs.getInt("pprice");
				String ordelivery = rs.getString("ordelivery");
				String orcomplete= rs.getString("orcomplete");
				String orcancle = rs.getString("orcancle");
				int odid = rs.getInt("odid");
				int pid = rs.getInt("pid");
				int sid = rs.getInt("sid");
				UserOrderlistVo vo = new UserOrderlistVo(ordate, orid, pimage2, sname, odcolor, odsize, odcount, pprice,
						ordelivery,orcomplete, orcancle, odid, pid, sid);
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int getCount(String field) { // 전체 글의 개수
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders";
			if (field == "halfway") {
				sql += " where ordelivery = 'N'";
			} else if (field == "finish") {
				sql += " where ordelivery = 'Y'";
			} else if (field == "cancel") {
				sql += " where ordelivery ='N' and orcancle ='N'";
			} else if (field == "return") {
				sql += " where ordelivery ='Y' and orcancle ='N'";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int mnum = rs.getInt(1); // NVL(count(num),0)이 컬럼1
			return mnum;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int CountOrid(String id) { // 주문개수 얻어오기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select count(orid) from orders where mid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int countorid = rs.getInt(1);
			return countorid;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public ArrayList<UserOrderlistVo> refundList(String id, String startdate,
			String enddate) { // 취소,환불탭
		String sql = null;
		if (startdate == null || enddate == null) {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) where ordate>=sysdate-90 and ordate<=sysdate and orcancle ='Y'";
		} else {
			sql = "select * from (select o.orid, o.ordate, o.ordelivery, o.orcomplete,  o.orcancle, od.odcolor, od.odsize, od.odcount, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice*(1-(0.01*p.pdiscount)) as pprice, s.sname, od.odid, p.pid, s.sid "
					+ "from orders o, order_detail od, product p, stock s "
					+ "where o.orid=od.orid and od.pid=p.pid and p.sid=s.sid and o.mid=?) "
					+ " where TO_CHAR(ordate,'MM/DD/YYYY')>=? and TO_CHAR(ordate,'MM/DD/YYYY')<=? and orcancle ='Y'";
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			if (startdate != null && enddate != null) {
				pstmt.setString(2, startdate);
				pstmt.setString(3, enddate);
			}
			rs = pstmt.executeQuery();
			ArrayList<UserOrderlistVo> list1 = new ArrayList<UserOrderlistVo>();
			while (rs.next()) {
				Date ordate = rs.getDate("ordate");
				int orid = rs.getInt("orid");
				String pimage2 = rs.getString("pimage2");
				String sname = rs.getString("sname");
				String odcolor = rs.getString("odcolor");
				String odsize = rs.getString("odsize");
				int odcount = rs.getInt("odcount");
				int pprice = rs.getInt("pprice");
				String ordelivery = rs.getString("ordelivery");
				String orcomplete= rs.getString("orcomplete");
				String orcancle = rs.getString("orcancle");
				int odid = rs.getInt("odid");
				int pid = rs.getInt("pid");
				int sid = rs.getInt("sid");
				UserOrderlistVo vo = new UserOrderlistVo(ordate, orid, pimage2, sname, odcolor, odsize, odcount, pprice,
						ordelivery,orcomplete, orcancle, odid, pid, sid);
				list1.add(vo);
				System.out.println();
			}
			return list1;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int getCountref() { // 취소, 환불용 전체 글의 개수
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where orcancle ='Y'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int mnum = rs.getInt(1); // NVL(count(num),0)이 컬럼1
			return mnum;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int buyproduct(String name, String phone, String addr, int ortotal, int orpaymoney, String mid) {
		// 수령자 이름,번호, 주소ㅡ우편번호,총가격,결제금액 mid
		String sql = "insert into orders values(ORDERS_seq.nextval,sysdate,?,?,?,null,0,0,0,'N','N',null,?,?,?)";
		int n = 0;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.setInt(4, ortotal);
			pstmt.setInt(5, orpaymoney);
			pstmt.setString(6, mid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}


	public int UnderDel(String id) { // 마이페이지 - 배송중 ??
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where mid=? and ORDELIVERY= 'Y' and ORCOMPLETE ='N' and ORCANCLE= 'N' and ordate>=sysdate-90 and ordate<=sysdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int DelFin(String id) { // 마이페이지 - 배송완료~
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where mid=? and ORDELIVERY= 'Y' and ORCOMPLETE ='Y' and ordate>=sysdate-90 and ordate<=sysdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int OrderCc(String id) { // 마이페이지 - 취소
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where mid=? and ORDELIVERY= 'N' and ORCOMPLETE ='N' and ORCANCLE= 'Y' and ordate>=sysdate-90 and ordate<=sysdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

	public int OrderReturn(String id) { // 마이페이지 - 반품
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getCon();
			String sql = "select NVL(count(orid),0) from orders where mid=? and ORDELIVERY= 'Y' and ORCOMPLETE ='N' and ORCANCLE= 'Y' and ordate>=sysdate-90 and ordate<=sysdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			return n;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0; // 글번호가 -1이 들어가지 않을꺼니까 -1주기
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

//	상품을 구매했을 때 주문테이블에 등록
	public int buyproduct(int seq, String name, String phone, String addr, int ortotal, int orpaymoney, String mid) {
		// 수령자 이름,번호, 주소ㅡ우편번호,총가격,결제금액 mid
		String sql = "insert into orders values(?,sysdate,?,?,?,null,0,0,0,'N','N',null,?,?,?)";
		int n = 0;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, seq);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setInt(5, ortotal);
			pstmt.setInt(6, orpaymoney);
			pstmt.setString(7, mid);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int selectseq() {
		String sql = "select ORDERS_seq.nextval FROM DUAL";
		int n = 0;
		try (Connection con = DBConnection.getCon(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					n = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}