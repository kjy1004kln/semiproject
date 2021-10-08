<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>NOTICE</h4>
공지사항입니다.

<table class="table">
  <tr>
    <th>SUBJECT</th>
    <th>NAME</th>
  </tr>
  <c:forEach var="vo" items="${list }">
	<tr>
		<th><a href="${cp }/user/noticedetail?fid=${vo.fid}">${vo.ftitle }</a></th>
		<th>${vo.aid }</th>
	</tr>
	</c:forEach>
</table>
<div>
	<c:if test="${pageNum>10 }">
		<a href="${cp }/user/notice?pageNum=${startPageNum-1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<a href="${cp }/user/notice?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/user/notice?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pageCount>endPageNum }">
		<a href="${cp }/user/notice?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>
검색어
<div>
	<form method="post" action="<%=request.getContextPath()%>/user/notice">
		<select name = "field">
				<option value="ftitle"
					<c:if test="${field=='ftitle' }">selected="selected"</c:if>>
				제목</option>
				<option value="fcontent"
					<c:if test="${field=='fcontent' }">selected="selected"</c:if>>
				내용</option>
		</select>
		<input type="text" name = "keyword">
		<input type="submit" value="찾기">
	</form>
</div>
