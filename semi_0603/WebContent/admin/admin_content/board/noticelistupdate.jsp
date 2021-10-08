<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id=(String)session.getAttribute("id");
	String ftitle=request.getParameter("ftitle");
	String fcontent=request.getParameter("fcontent");
	String fpublic_private=request.getParameter("fpublic_private");
	String fid=request.getParameter("fid");
	
	System.out.println(fid);
	System.out.println(id);
%>
	
<div id="faqbox" style="border :1px solid #8BBDFF; position:fixed; top:10px; left:10px; width:480px; height:450px;">

<form method="post" action="<%=request.getContextPath()%>/admin/notice/update">
<input type="hidden" name="fid" value="${vo.fid }"><br>
	<label style="position:absolute;top:50px;left:50px; height:30px;font-size:15px;">작성자</label>
	<input type="text" value=<%=id %> name="fwriter"  style="position:absolute; top:50px;left:150px;width:300px;height:30px;font-size:15px;" readonly="readonly">
	<label style="position:absolute;top:110px;left:50px; height:30px;font-size:15px;">제목</label>
	<input type="text" name="ftitle" value="${vo.ftitle }" style="position:absolute;top:110px;left:150px; width:300px;height:30px;font-size:15px;"><br>
	<label style="position:absolute;top:170px;left:50px; height:30px;font-size:15px;">내용</label>
	<textarea rows="5" cols="50" name="fcontent"style="position:absolute;top:170px;left:150px; width:300px;height:120px;font-size:15px;">${vo.fcontent }</textarea><br>
	<label style="position:absolute;top:300px;left:50px; height:30px;font-size:15px;">첨부파일</label><br>
	<input type="file" name="file1"  style="position:absolute;top:300px;left:200px; font-size:15px;"><br>
	<c:choose>
	<c:when test="${vo.fpublic_private==1 }">
	<label style="position:absolute;top:350px;left:150px; height:30px;font-size:20px;">공개</label>
	<input type="radio" name="fpublic_private" value="1" checked="checked" style="position:absolute;top:355px;left:200px; font-size:20px;">
	<label style="position:absolute;top:350px;left:250px; height:30px;font-size:20px;">비공개</label>
	<input type="radio" name="fpublic_private" value="0" style="position:absolute;top:355px;left:320px; font-size:20px;">
	</c:when>
	<c:otherwise>
	<label style="position:absolute;top:350px;left:150px; height:30px;font-size:20px;">공개</label>
	<input type="radio" name="fpublic_private" value="1" style="position:absolute;top:355px;left:200px; font-size:20px;">
	<label style="position:absolute;top:350px;left:250px; height:30px;font-size:20px;">비공개</label>
	<input type="radio" name="fpublic_private" value="0" checked="checked" style="position:absolute;top:355px;left:320px; font-size:20px;">
	</c:otherwise>
	</c:choose>
	<input type="submit" name="submit" value="수정" style="position:absolute;top:350px;left:360px; font-size:20px;">
</form>
</div>
