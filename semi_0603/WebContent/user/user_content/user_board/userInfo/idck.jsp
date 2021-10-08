<%@page import="org.json.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mname=request.getParameter("mname");
	String memail=request.getParameter("memail");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject json=new JSONObject();
	try{
		con=DBConnection.getCon();
		String sql="select mid from members where mname=? and memail=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, mname);
		pstmt.setString(2, memail);
		rs=pstmt.executeQuery();
		if(rs.next()){
			json.put("mid",rs.getString("mid"));
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt, rs);
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print(json);
%>