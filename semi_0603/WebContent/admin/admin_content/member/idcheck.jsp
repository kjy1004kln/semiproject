<%@page import="org.json.JSONObject"%>
<%@page import="netscape.javascript.JSObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid=request.getParameter("mid1");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean using=false;
	try{
		con=DBConnection.getCon();
		String sql="select mid from members where mid=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, mid);
		rs=pstmt.executeQuery();
		if(rs.next()){
			using=true;
		}
	}catch(SQLException s){
		s.printStackTrace();
	}finally{
		DBConnection.close(con, pstmt, rs);
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	JSONObject json=new JSONObject();
	json.put("using",using);
	pw.print(json);
%>