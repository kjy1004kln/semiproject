<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");
%>
<div id="noticebox" style="border :1px solid #8BBDFF; position:fixed; top:10px; left:10px; width:480px; height:450px;">
<form method="post" action="<%=request.getContextPath()%>/admin/notice/insert" enctype="multipart/form-data">
	<label style="position:absolute;top:50px;left:50px; height:30px;font-size:15px;">작성자</label>
	<input type="text" value="<%=id %>" name="fwriter" style="position:absolute; top:50px;left:150px;width:300px;height:30px;font-size:15px;">
	<label style="position:absolute;top:110px;left:50px; height:30px;font-size:15px;">제목</label>
	<input type="text" name="ftitle" style="position:absolute;top:110px;left:150px; width:300px;height:30px;font-size:15px;"><br>
	<label style="position:absolute;top:170px;left:50px; height:30px;font-size:15px;">내용</label>
	<textarea rows="5" cols="50" name="fcontent"style="position:absolute;top:170px;left:150px; width:300px;height:120px;font-size:15px;"></textarea><br>
	<label style="position:absolute;top:300px;left:50px; height:30px;font-size:15px;">첨부파일</label><br>
	<input type="file" name="file1" style="position:absolute;top:300px;left:200px; font-size:15px;"><br>
	<label style="position:absolute;top:360px;left:150px; height:30px;font-size:15px;">공개</label>
	<input type="radio" name="fpublic_private" value="1" checked style="position:absolute;top:365px;left:200px; font-size:15px;">
	<label style="position:absolute;top:360px;left:250px; height:30px;font-size:15px;">비공개</label>
	<input type="radio" name="fpublic_private" value="0" style="position:absolute;top:365px;left:320px; font-size:15px;">
	<input type="submit" name="insert" value="등록" style="position:absolute;top:360px;left:360px; font-size:15px;">
</form>
</div>