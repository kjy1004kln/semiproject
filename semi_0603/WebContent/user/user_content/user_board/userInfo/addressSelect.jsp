<%@page import="java.util.ArrayList"%>
<%@page import="test.db.DBConnection"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String pid = request.getParameter("pid");
String sql = "select * from members where pid ="+pid;
try(Connection con = DBConnection.getCon();
		PreparedStatement pstmt= con.prepareStatement(sql);){
	JSONObject obj = new JSONObject();
	try(ResultSet rs = pstmt.executeQuery();){
		if(rs.next()){
			String maddress = rs.getString("maddress");
			String mpost = rs.getString("mpost");
			String addphone = rs.getString("addphone");
			String addname = rs.getString("addname");
			String addtitle = rs.getString("addtitle");
			ArrayList<String> list = new ArrayList<>();
			obj.put("maddress",maddress);
			obj.put("mpost",mpost);
			obj.put("addphone",addphone);
			obj.put("addname",addname);
			obj.put("addtitle",addtitle);
		}
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.print(obj);
}
%>