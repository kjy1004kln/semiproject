<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="user.vo.UserQnaVo"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//check.jsp
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String ordelivery=null;
	try{
		con=DBConnection.getCon();
		String sql="select count(ORDELIVERY) as ORDELIVERY from orders where ORDELIVERY='N'";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()){
			ordelivery=rs.getString("ordelivery");
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt, rs);
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result1>");
	pw.print("<ordelivery>"+ordelivery+"</ordelivery>");
	pw.print("</result1>");
%>