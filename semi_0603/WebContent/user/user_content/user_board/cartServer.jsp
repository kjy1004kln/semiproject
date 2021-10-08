<%@page import="user.dao.User_CartDao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int wid = Integer.parseInt(request.getParameter("wid"));
	User_CartDao cartdao = new User_CartDao();
	int n =cartdao.deletecart(wid);
	JSONObject result = new JSONObject();
	result.put("n",n);
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.print(n);
%>