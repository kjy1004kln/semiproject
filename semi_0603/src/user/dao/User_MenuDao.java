package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.dao.Admin_ProductDao;
import admin.vo.Admin_ProductVo;
import admin.vo.Admin_ProductVo2;
import test.db.DBConnection;
import user.vo.User_ProductVo;

public class User_MenuDao {
	private static User_MenuDao instance=new User_MenuDao();
	private User_MenuDao() {}
	public static User_MenuDao getInstance() {
		return instance;
	}
	public ArrayList<Admin_ProductVo2> mainbest8(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid order by p.psell desc) where rownum<=8";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	public ArrayList<Admin_ProductVo2> mainlist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid order by p.prdate desc) board) where rnum<=30";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public ArrayList<Admin_ProductVo2> newlist(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid order by p.prdate desc) board) where rnum<=30";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public ArrayList<Admin_ProductVo2> best50list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid order by p.psell desc) board) where rnum<=30";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	public ArrayList<Admin_ProductVo2> outerbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%아우터%' or s.sname like '%outer%') order by p.psell desc) where rownum<=4";
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OUTER' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> outerlist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OUTER' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	public int outergetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OUTER'";
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
	
	public ArrayList<Admin_ProductVo2> topbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%탑%' or s.sname like '%top%') order by p.psell desc) where rownum<=4";
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='TOP' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> toplist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='TOP' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int topgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='TOP'";
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
	
	public ArrayList<Admin_ProductVo2> opsbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OPS' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> opslist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%원피스%' or s.sname like '%ops%') order by p.prdate desc) board) where rnum>=? and rnum<=?";
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OPS' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int opsgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select NVL(count(*),0) from product p join stock s on p.sid = s.sid where (s.sname like '%원피스%' or s.sname like '%ops%')";
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='OPS'";
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
	
	public ArrayList<Admin_ProductVo2> skirtbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%스커트%' or s.sname like '%skirt%') order by p.psell desc) where rownum<=4";
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SKIRT' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> skirtlist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%스커트%' or s.sname like '%skirt%') order by p.prdate desc) board) where rnum>=? and rnum<=?";
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SKIRT' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int skirtgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select NVL(count(*),0) from product p join stock s on p.sid = s.sid where (s.sname like '%스커트%' or s.sname like '%skirt%')";
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SKIRT'";
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
	
	public ArrayList<Admin_ProductVo2> pantsbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='PANTS' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> pantslist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%팬츠%' or s.sname like '%pants%') order by p.prdate desc) board) where rnum>=? and rnum<=?";
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='PANTS' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int pantsgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select NVL(count(*),0) from product p join stock s on p.sid = s.sid where (s.sname like '%팬츠%' or s.sname like '%pants%')";
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='PANTS'";
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
	
	
	public ArrayList<Admin_ProductVo2> shoesbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%신발%' or s.sname like '%shoes%' or s.sname like '%백%' or s.sname like '%bag%') order by p.psell desc) where rownum<=4";
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SHOES/BAG' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> shoeslist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%신발%' or s.sname like '%shoes%' or s.sname like '%백%' or s.sname like '%bag%') order by p.prdate desc) board) where rnum>=? and rnum<=?";
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SHOES/BAG' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int shoesgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='SHOES/BAG'";
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
	
	public ArrayList<Admin_ProductVo2> accbest4(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1,substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%acc%' or s.sname like '%비키니%' or s.sname like '%벨트%' or s.sname like '%시계%') order by p.psell desc) where rownum<=4";
			String sql="select * from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='ACC' order by p.psell desc ) where rownum<=4";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	public ArrayList<Admin_ProductVo2> acclist(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select * from(select board.*,rownum rnum from (select p.pid as pid, substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) as pimage1, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, p.pprice as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from product p join stock s on p.sid = s.sid where (s.sname like '%acc%' or s.sname like '%비키니%' or s.sname like '%벨트%' or s.sname like '%시계%') order by p.prdate desc) board) where rnum>=? and rnum<=?";
			String sql="select * from(select board.*,rownum rnum from (select  DISTINCT p.pid as pid ,substr(p.pimage1,(instr(p.pimage1,'/',-1)+1)) AS pimage1, p.psell, substr(p.pimage2,(instr(p.pimage2,'/',-1)+1)) as pimage2, (p.pprice-(p.pprice/100*p.pdiscount)) as pprice, p.pdiscount as pdiscount, p.sid as sid, s.sname as sname from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='ACC' order by p.psell desc ) board) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<Admin_ProductVo2> list=new ArrayList<Admin_ProductVo2>();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				int pprice=rs.getInt("pprice");
				int pdiscount=rs.getInt("pdiscount");
				String pimage1=rs.getString("pimage1");
				String pimage2=rs.getString("pimage2");
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");//이름 가져오기
				Admin_ProductVo2 vo=new Admin_ProductVo2(pid, pprice, pdiscount, pimage1, pimage2, null, 0, sid, sname, null, null);
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
	
	
	public int accgetCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			//String sql="select NVL(count(*),0) from product p join stock s on p.sid = s.sid where (s.sname like '%acc%' or s.sname like '%비키니%' or s.sname like '%벨트%' or s.sname like '%시계%')";
			String sql="select NVL(count(*),0) from inbound i, stock s,product p where s.sname=i.inname and p.sid=s.sid and i.INCATEGORY='ACC'";
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
}
