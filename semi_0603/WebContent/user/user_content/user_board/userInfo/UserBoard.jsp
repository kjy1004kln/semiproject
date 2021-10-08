<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>my board</h4>
<h5>나의 문의내역</h5>
<table class="table">
	<tr class="active">
		<th>번호</th>
		<th>카테고리</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>

	</tr>
	<c:choose>
		<c:when test="${empty Qlist}">
			<tr>
				<td>문의내역이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${Qlist }">
			<tr>
			<td>${vo.qid }</td>
			<td>${vo.qcate }</td>
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
			<td>${vo.qrdate }</td>

			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

	<form method="post" action="${cp }/user/userBoard">
		<select name = "field">
				<option value="qcate"
					<c:if test="${field=='qcate' }">selected="selected"</c:if>
				>카테고리</option>
				<option value="qtitle"
					<c:if test="${field=='qtitle' }">selected="selected"</c:if>
				>제목</option>
				<option value="qcontent"
					<c:if test="${field=='qcontent' }">selected="selected"</c:if>
				>내용</option>
				<option value="mid"
					<c:if test="${field=='mid' }">selected="selected"</c:if>
				>아이디</option>
		</select>
		<input type="text" name = "keyword">
		<input type="submit" value="찾기">
	</form>
	
	<!-- 페이징 처리 -->
	<c:if test="${startPageNum>10 }">
		<a href="${cp}/user/userBoard?pageNum=${startPageNum-1 }&field=${field}&keyword=${keyword}">[이전]</a> <!-- 현재페이지 보이기 -->
		</c:if>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<a href="${cp}/user/userBoard?pageNum=${i }&field=${field}&keyword=${keyword}">
					<span style="color:blue">[${i }]</span></a>
					<!-- <a href="${cp}/board/list?pageNum=${i}" 로 줘도 됨 -->
				</c:when>
				<c:otherwise>
					<a href="${cp}/user/userBoard?pageNum=${i }&field=${field}&keyword=${keyword}">
					<span style="color:gray">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${endPageNum<pageCount }">
			<a href="${cp}/user/userBoard?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
		</c:if>
		
		
<h5>내가 작성한 리뷰</h5>

<table class="table">
	<tr class="active">
		<th>제품사진</th>
		<th>상품명</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>첨부사진</th>
	</tr>
		<c:choose>
		<c:when test="${empty Rlist}">
			<tr>
				<td>작성한 리뷰가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${Rlist }">
	<tr>
		<td><img src="${cp }/img/${vo.pimage2 }" style="width:100px; height=150px;"></td>
		<td>${vo.sname }</td>
		<td>${vo.rtitle }</td>
		<td>${vo.mid }</td>
		<td>${vo.rrdate }</td>
		<td><img src="${cp }/img/${vo.rphoto1 }" style="width:100px; height=150px;"></td>
	</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>


	<!-- 페이징 처리 -->
	<c:if test="${startPageNum0>10 }">
		<a href="${cp}/user/userBoard?pageNum0=${startPageNum0-1 }">[이전]</a> <!-- 현재페이지 보이기 -->
		</c:if>
		
		<c:forEach var="i" begin="${startPageNum0 }" end="${endPageNum0 }">
			<c:choose>
				<c:when test="${pageNum0==i }">
					<a href="${cp}/user/userBoard?pageNum0=${i }">
					<span style="color:blue">[${i }]</span></a>
					<!-- <a href="${cp}/board/list?pageNum=${i}" 로 줘도 됨 -->
				</c:when>
				<c:otherwise>
					<a href="${cp}/user/userBoard?pageNum0=${i }">
					<span style="color:gray">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${endPageNum0<pageCount0 }">
			<a href="${cp}/user/userBoard?pageNum0=${endPageNum0+1 }">[다음]</a>
		</c:if>
		