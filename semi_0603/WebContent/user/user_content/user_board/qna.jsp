<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id=(String)session.getAttribute("id");
%>
<h1>QnA</h1>
<table class="table">
  <tr>
    <th>DATE</th>
    <th>SUBJECT</th>
    <th>NAME</th>
  </tr>
  <c:forEach var="vo" items="${list }">
	<tr>
		<td>${vo.qrdate }</td>
		<td>
			<c:if test="${vo.qlev>0 }">		
				<c:forEach var="i" begin="1" end="${vo.qlev }">
					&nbsp;&nbsp;
				</c:forEach>
				[re]
			</c:if>
			<c:if test="${!empty vo.qpw}">
			<img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/ico_lock.gif">
			</c:if>
			<a href="<%=request.getContextPath()%>/user/qnaDetail?qid=${vo.qid}">${vo.qtitle }</a></td>
		<td>${vo.mid }</td>
	</tr>
	</c:forEach>	
</table>
<div>
	<c:if test="${pageNum>10 }">
		<a href="${cp }/user/qna?pageNum=${startPageNum-1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<a href="${cp }/user/qna?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/user/qna?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pageCount>endPageNum }">
		<a href="${cp }/user/qna?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>
<br>
검색어
<div>
	<form method="post" action="${cp }/user/qna">
		<select name = "field">
				<option value="qtitle"
					<c:if test="${field=='qtitle' }">selected="selected"</c:if>>
				제목</option>
				<option value="qcontent"
					<c:if test="${field=='qcontent' }">selected="selected"</c:if>>
				내용</option>
				<option value="mid"
					<c:if test="${field=='mid' }">selected="selected"</c:if>>
				아이디</option>
		</select>
		<input type="text" name = "keyword">
		<input type="submit" value="찾기">
	</form>
<%if(id!=null && id!="") {%>
	<a href="<%=request.getContextPath()%>/user/qnainsertpath?mid=${vo.mid}"><input type="button" value="글쓰기"></a>
	<% }else{
%>   <input type="button" value="글쓰기" onclick="show()">
<%} %>
</div>
<script type="text/javascript">
	function show(){
		alert("로그인필요!");
		
	}
</script>
