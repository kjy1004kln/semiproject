<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int orid=Integer.parseInt(request.getParameter("orid"));
	Connection con=null;
	PreparedStatement pstmt=null;
	try{
		con=DBConnection.getCon();
		String sql="update orders set orcancle='Y' where orid=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, orid);
		pstmt.executeUpdate();
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt,null);
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>");
	pw.print("<code>success</code>");
	pw.print("</result>");	

%>