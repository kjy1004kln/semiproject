<%@page import="user.vo.User_NoticeVo"%>
<%@page import="oracle.sql.CLOB"%>
<%@page import="java.io.Reader"%>
<%@page import="java.sql.Clob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h4>NOTICE</h4>
공지사항입니다.

<table class="table">
  <tr>
    <td>SUBJECT</td>
    <td>${vo.ftitle }</td>
  </tr>
  <tr>
    <td>NAME</td>
	<th>${vo.aid }</th>
  </tr>
  <tr>
  	<td colspan="2"> 
  	<c:if test="${vo.ffile!='/noticeimage/null' }"><img src="${cp}${vo.ffile }"></c:if>${vo.fcontent } </td>
  </tr>
</table>
<input type="button" value="목록" onclick="location.href='${cp}/user/notice'">
<table>
	<tr>
		<td>이전글</td>
		<c:choose>
			<c:when test="${back.fid!=null }">
					<td><a href="${cp }/user/noticedetail?fid=${back.fid }">${back.ftitle}</a></td>
			</c:when>
			<c:otherwise>
				<td>없음</td>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>다음글</td>
		<c:choose>
			<c:when test="${next.fid!=null }">
				<td><a href="${cp }/user/noticedetail?fid=${next.fid }">${next.ftitle}</a></td>
			</c:when>
			<c:otherwise>
				<td>없음</td>
			</c:otherwise>
		</c:choose>
	</tr>
</table>

