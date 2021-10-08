<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");
	String sql = "select * from members where mid =?";
	JSONArray arr = new JSONArray();
	try(Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql);){
		pstmt.setString(1, mid);
		try(ResultSet rs = pstmt.executeQuery();){
			if(rs.next()){
				JSONObject obj = new JSONObject(); 
				String ssize = rs.getString("ssize");
				obj.put("ssize",ssize);
				arr.put(obj);
			}
		}
	}
	JSONObject result = new JSONObject();
	result.put("list",arr);
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.print(result);
%>