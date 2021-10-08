<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/product.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<div class="boardcss_list_table">
<h2 class="stocktext">상품별 재고리스트</h2>
	<table class="list_table">
		<thead>
		<tr>
			<th>상품명</th>
			<th>색상</th>
			<th>사이즈</th>
			<th>수량</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.sname }</td>
				<td>${vo.scolor }</td>
				<td>${vo.ssize }</td>
				<td>${vo.samount }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div class="boardcss_list_table1">
<img src="${pageContext.request.contextPath }/img/${vo2.pimage2 }" style="position: absolute;top:10px;left:10px;width:340px;height:380px;" >
<div id="name" style="position: absolute;top:10px;left:400px;width:300px;height:20px;font-weight:bold;font-size:1.2em; ">${vo2.sname }</div>
<div id="price" style="position: absolute;top:40px;left:500px;width:200px;height:20px;">${vo2.pprice }</div>
<label style="position: absolute;top:40px;left:400px;width:200px;height:20px;">가격</label>
<div id="size" style="position: absolute;top:70px;left:500px;width:200px;height:20px; ">${vo2.ssize }</div>
<label style="position: absolute;top:70px;left:400px;width:200px;height:20px;">사이즈</label>
<div id="color" style="position: absolute;top:100px;left:500px;width:200px;height:20px; ">${vo2.scolor }</div>
<label style="position: absolute;top:100px;left:400px;width:200px;height:20px;">색상</label>
<img src="${pageContext.request.contextPath }/admin/upload/button.jpg" style="position: absolute;top:130px;left:380px;width:300px;height:70px;">
</div>		
<div class="boardcss_list_table2">
<h2 class="producttext">판매리스트</h2>	
	<table class="list_table2">
		<thead>
		<tr>
			<th>이미지</th>
			<th>번호</th>
			<th>가격</th>
			<th>할인율</th>
			<th>대표이미지</th>
			<th>추가이미지</th>
			<th>등록일</th>
			<th>판매량</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo1" items="${list1 }">
			<tr>
				<!-- C:\web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\semiProject\admin\upload/ -->
				<td>
					<img src="${pageContext.request.contextPath }/img/${vo1.pimage2 }" width="100" height="100">
				</td>
				<td>${vo1.pid }</td>
				<td>${vo1.pprice }</td>
				<td>${vo1.pdiscount }</td>
				<td>${vo1.pimage1 }</td>
				<td>${vo1.pimage2 }</td>
				<td>${vo1.prdate }</td>
				<td>${vo1.psell }</td>
				<td><a href="<%=request.getContextPath()%>/admin/product/delete?pid=${vo1.pid}&sid=${vo1.sid}&pimage1=${vo1.pimage1}&pimage2=${vo1.pimage2}" style="color:red;">삭제</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<div class="page">
	<c:if test="${startPageNum>10 }">
		<a href="${cp}/admin/product/list?pageNum=${startPageNum -1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/admin/product/list?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:red">${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/product/list?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:blue">${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/admin/product/list?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>
</div>
<div style="position:fixed;top:120px;left:1500px; font-size: 1.2rem;">
	<form method="post" action="${cp }/admin/product/list">
		<select name="field">
			<option value="pid" <c:if test="${field=='pid' }">selected="selected"</c:if>>번호</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>
<form name="frm" method="post">
<label style="position:fixed; top:920px;left:1400px;font-size: 1.2rem;">재고이름선택</label>
<select name="sname" style="position:fixed; top:915px;left:1490px;width:230px;height:25px;font-size: 1.2rem;">
	<c:forEach var="vo" items="${list }">
		<option>${vo.sname }</option>
	</c:forEach>
</select>
<input class="btn btn-outline-dark" type="button" value="등록" onclick="valuesend()" style="position:fixed; top:915px;left:1740px;width:50px;height:25px;font-size: 1.2rem;">
</form>
<script type="text/javascript">
function valuesend(){
	 window.open("", "value", "width=1000, height=1200, left=400, top=40, scrollbars=1, menubar=1, resizable=1"); 
		 document.frm.target ="value";     
		 document.frm.action="<%=request.getContextPath()%>/admin/admin_content/item/productinsert.jsp";
	 	 document.frm.submit();
	}
function valuesend1(pid){
		 window.open("", "value", "width=1000, height=1200, left=400, top=40, scrollbars=1, menubar=1, resizable=1"); 
			 document.frm.target ="value";     
			 document.frm.action="<%=request.getContextPath()%>/admin/admin_content/item/productupdate.jsp?pid="+pid;
		 	 document.frm.submit();
}
</script>

