<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#qnabox{
		position:absolute;
		top:100px;
		left:300px;
	}
</style>
</head>
<body>
<div id="qnabox">
	<table class="table">
		<tr>
			<th colspan="8">QnA</th>
		</tr>
		<tr>
			<th>카테고리</th>
			<th>회원아이디</th>
			<th>제품번호</th>
			<th>제목</th>
			<th>작성날짜</th>				
		</tr>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.qcate }</td>
			<td>${vo.mid }</td>
			<td>${vo.pid }</td>
			<td>
			<c:if test="${vo.qlev>0 }">		
				<c:forEach var="i" begin="1" end="${vo.qlev }">
					&nbsp;&nbsp;
				</c:forEach>
				[re]
			</c:if>
			<a href="${cp }/admin/qnadetail?qid=${vo.qid }" 
			onclick="window.open(this.href,'','width=500, height=500, toolbars=no, scrollbars=yes'); return false;">${vo.qtitle }</a></td>
			<td>${vo.qrdate }</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${startPageNum>10 }">
		<a href="${cp }/admin/qna?pageNum=${startPageNum-1 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }"><%--현재페이지인경우 --%>
				<a href="${cp }/admin/qna?pageNum=${i }"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/qna?pageNum=${i }"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/admin/qna?pageNum=${endPageNum+1 }">[다음]</a>
	</c:if>
	<form method="post" action="${cp }/admin/qna">
		<select name="field">
			<option value="qtitle">제목</option>
			<option value="qcontent">내용</option>
		</select>
		<input type="text" name="keyword">
	<input type="button" value="검색">
	</form>	<br>
</div>
</body>
</html>