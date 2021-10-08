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
	String qid=null;
	try{
		con=DBConnection.getCon();
		String sql="select count(*) qid from userqna where qlev=0";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()){
			qid=rs.getString("qid");
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt, rs);
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>");
	pw.print("<qid>"+qid+"</qid>");
	pw.print("</result>");
%>