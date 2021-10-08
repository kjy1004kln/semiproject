<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#btn1{
	color: rgba(30, 22, 54, 0.6);
	box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
	}
#box{
	border-top:1px solid #8C8C8C;
	border-bottom:1px solid #8C8C8C;
}
</style>
<div id="box">
	작성자:&nbsp;&nbsp;&ensp;:${vo.mid }<br>
	제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:${vo.qtitle }<br>
	카테고리&nbsp;:${vo.qcate }<br>
	내용&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:${vo.qcontent }<br>
	답글:

	<form action="${cp }/admin/qna/reply" method="post">
	
	<input type="hidden" name="qid" value="${vo.qid }">
	<input type="hidden" name="qcate" value="${vo.qcate }">
	<input type="hidden" name="qpw" value="${vo.qpw }">
	<input type="hidden" name="qtitle" value="${vo.qtitle }">
	<input type="hidden" name="qfile" value="${vo.qfile }">
	<input type="hidden" name="qref" value="${vo.qref }">
	<input type="hidden" name="qlev" value="${vo.qlev }">
	<input type="hidden" name="mid" value="${vo.mid }">
	<input type="hidden" name="pid" value="${vo.pid }">
	<input type="hidden" name="qstep" value="${vo.qstep }">
	<br>
	<textarea rows="5" cols="50" name="qcontent"></textarea><br>
	<br>
	<input type="submit" value="등록" id="btn1">
	</form>
</div>
