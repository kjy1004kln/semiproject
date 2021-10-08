<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@page import="user.dao.User_CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String wid = request.getParameter("num");
User_CartDao dao = new User_CartDao();
int n = dao.selectDel(wid);
JSONObject result = new JSONObject();
result.put("n",n);
response.setContentType("text/plain;charset=utf-8");
PrintWriter pw = response.getWriter();
pw.print(n);
%>