<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<tr>
		<th>DATE</th>
		<th>PRODUCT</th>
		<th>SUBJECT</th>
		<th>NAME</th>
	</tr>
	<c:forEach var="vo" items="${vo }">
		<tr>
			<td>${vo.qrdate }</td>
			<td>${vo.pid }</td>
			<td>${vo.qtitle }</td>
			<td>${vo.mid }</td>
	</c:forEach>
</table>