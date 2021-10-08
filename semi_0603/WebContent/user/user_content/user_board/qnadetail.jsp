<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<tr>
		<th>카테고리</th>
		<td>${vo.qcate }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.mid }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${vo.qtitle }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${vo.qcontent }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><c:if test="${vo.qfile!='/qnaimage/null' }"><img src="${cp}${vo.qfile }"></c:if></td>
	</tr>
	<tr>
		<th>답글</th>
		<td><c:if test="${qref }"></c:if></td>
	</tr>
</table>