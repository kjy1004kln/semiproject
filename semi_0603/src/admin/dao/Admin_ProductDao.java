package admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.vo.Admin_AdminVo;
import admin.vo.Admin_InboundVo;
import admin.vo.Admin_ProductVo;
import admin.vo.Admin_ProductVo2;
import admin.vo.Admin_StockVo;
import test.db.DBConnection;

public class Admin_ProductDao {
	private static Admin_ProductDao instance=new Admin_ProductDao();
	private Admin_ProductDao() {}
	public static Admin_ProductDao getInstance() {
		return instance;
	}
	public int insert(Admin_ProductVo2 vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into product values(PRODUCT_SEQ.nextval,?,?,?,?,sysdate,0,(select MIN(sid) from stock where sname=?))";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPprice());
			pstmt.setInt(2, vo.getPdiscount());
			pstmt.setString(3, vo.getPimage1());
			pstmt.setString(4, vo.getPimage2());
			pstmt.setString(5, vo.getSname());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public ArrayList<Admin_ProductVo> list(int startRow, int endRow, String field, String keyword){
		String sql=null;
		if(field==null || field.equals("")) {
			sql="select pid,pprice,pdiscount,prdate,psell,sid, substr(pimage1,(instr(pimage1,'/',-1)+1)) as PIMAGENAME1,"
					+ " substr(pimage2,(instr(pimage2,'/',-1)+1)) as PIMAGENAME2  from ("
					+"select board.*,rownum rnum from"
					+"("
					+"select * from product order by pid desc"
					+") board"
					+")where rnum>=? and rnum<=?";
		}else {
			sql="select pid,pprice,pdiscount,prdate,psell,sid, substr(pimage1,(instr(pimage1,'/',-1)+1)) as PIMAGENAME1,"
					+ " substr(pimage2,(instr(pimage2,'/',-1)+1)) as PIMAGENAME2  from ("
					+"select board.*,rownum rnum from"
					+"("
					+"select * from product where " + field + " like '%"+ keyword + "%' order by pid desc"
					+") board"
					+")where rnum>=? and rnum<=?";
			
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
			ArrayList<Admin_ProductVo> list=new ArrayList<Admin_ProductVo>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("PIMAGENAME1");
				String pimage2=rs.getString("PIMAGENAME2");
				Date prdate=rs.getDate("prdate");
				int psell=rs.getInt("psell");
				int sid=rs.getInt("sid");
				Admin_ProductVo vo=new Admin_ProductVo(pid, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid);
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
			String sql="select NVL(count(*),0) from product";
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
	public Admin_ProductVo getimage(int pid) {
		String sql="select * from product where pid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				Admin_ProductVo vo=new Admin_ProductVo(0, 0, 0, pimage1, pimage2, null, 0, 0);
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
	public ArrayList<Admin_ProductVo> best3(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from (select p.pimage1 as pimage1, s.sname as sname from product p, stock s order by p.psell desc) where rownum<=3";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo> list=new ArrayList<Admin_ProductVo>();
			while(rs.next()) {
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("sname");//이름 가져오기
				Admin_ProductVo vo=new Admin_ProductVo(0, 0, 0, pimage1, pimage2, null, 0, 0);
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
	public ArrayList<Admin_InboundVo> ppricelist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select to_char(indate,'yyyy') as indate, sum(inprice) as inprice from inbound group by to_char(indate, 'yyyy')";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_InboundVo> list=new ArrayList<Admin_InboundVo>();
			while(rs.next()) {
				int indate=rs.getInt("indate");
				int inprice=rs.getInt("inprice");
				Admin_InboundVo vo=new Admin_InboundVo(indate, null,null, inprice,0,null,null,null);
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
	public int delete(int pid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from product where pid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public int update(Admin_ProductVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update product set pprice=?,pdiscount=?,pimage1=?,pimage2=? where pid=?";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPprice());
			pstmt.setInt(2, vo.getPdiscount());
			pstmt.setString(3, vo.getPimage1());
			pstmt.setString(4, vo.getPimage2());
			pstmt.setInt(5, vo.getPid());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public Admin_ProductVo2 img() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from (select pid,pprice,pdiscount,substr(pimage1,(instr(pimage1,'/',-1)+1)) as PIMAGENAME1,substr(pimage2,(instr(pimage2,'/',-1)+1)) as PIMAGENAME2,prdate,psell, s.sid as sid,s.sname as sname, s.ssize as ssize, s.scolor as scolor from product p join stock s on p.sid = s.sid order by p.pid desc) where rownum<=1";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("PIMAGENAME1");
				String pimage2=rs.getString("PIMAGENAME2");
				Date prdate=rs.getDate("prdate");
				int psell=rs.getInt("psell");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String ssize=rs.getString("ssize");
				String scolor=rs.getString("scolor");
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, prdate, psell, sid, sname,ssize,scolor);
				return vo;
			}
			else {
				return null;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	public ArrayList<Admin_ProductVo> month(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select pid,psell,prdate,psell*pprice as pprice from product where prdate > add_months(sysdate,-1) and psell*pprice > 0";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo> list=new ArrayList<Admin_ProductVo>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int psell=rs.getInt("psell");
				Date prdate=rs.getDate("prdate");
				int pprice=rs.getInt("pprice");
				Admin_ProductVo vo=new Admin_ProductVo(pid, pprice, 0, null, null, prdate, psell, 0);
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
