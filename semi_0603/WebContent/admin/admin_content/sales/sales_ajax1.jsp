<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//check.jsp
	
	Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	ResultSet rs=null;
	String mid=null;
	String price=null;
	String sname=null;
	try{
		con=DBConnection.getCon();
		String sql1="select count(*) as mid from members";
		String sql2="select sum(p.psell*p.pprice)-sum(inprice*inamount) as price from inbound i, product p";
		String sql3="select * from (select s.sname as sname from product p, stock s order by p.psell desc) where rownum<=1";
		pstmt1=con.prepareStatement(sql1);
		pstmt2=con.prepareStatement(sql2);
		pstmt3=con.prepareStatement(sql3);
		rs=pstmt1.executeQuery();
		if(rs.next()){
			mid=rs.getString("mid");
		}
		rs=pstmt2.executeQuery();
		if(rs.next()){
			price=rs.getString("price");
		}
		rs=pstmt3.executeQuery();
		if(rs.next()){
			sname=rs.getString("sname");
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt1, rs);
		DBConnection.close(null, pstmt2, null);
		DBConnection.close(null, pstmt3, null);
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result1>");
	pw.print("<mid>"+mid+"</mid>");
	pw.print("<price>"+price+"</price>");
	pw.print("<sname>"+sname+"</sname>");
	pw.print("</result1>");
%>