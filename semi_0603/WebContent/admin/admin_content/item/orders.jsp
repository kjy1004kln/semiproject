<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/orders.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">

<h2 class="orderstext1" style="position:absolute;top:70px;left:200px;">배송중</h2>
<div class="boardcss_list_table1">
	<table class="ordelivery_table">
		<thead>
		<tr>
			<th>ID</th>
			<th>주문일</th>
			<th>수령자</th>
			<th>수령자연락처</th>
			<th>수령자주소</th>
			<th>수령자우편번호</th>
			<th>결제수단</th>
			<th>송장번호</th>
			<th>배송비</th>
			<th>배송완료수정</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.mid }</td>
				<td>${vo.ordate }</td>
				<td>${vo.orname }</td>
				<td>${vo.orphone }</td>
				<td>${vo.oraddress }</td>
				<td>${vo.orpost }</td>
				<td>${vo.orpayment }</td>
				<td>${vo.orinvoice }</td>
				<td>${vo.ordelpay }</td>
				<td><a href="<%=request.getContextPath()%>/admin/orders/deliveryupdate?orid=${vo.orid}">배송완료</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<h2 class="orderstext2" style="position:absolute;top:370px;left:200px;">배송완료</h2>
<div class="boardcss_list_table2">
	<table class="ordelivery_com_table">
		<thead>
		<tr>
			<th>ID</th>
			<th>주문일</th>
			<th>수령자</th>
			<th>수령자연락처</th>
			<th>수령자주소</th>
			<th>수령자우편번호</th>
			<th>결제수단</th>
			<th>송장번호</th>
			<th>배송비</th>
			<th>구매확정수정</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list1 }">
			<tr>
				<td>${vo.mid }</td>
				<td>${vo.ordate }</td>
				<td>${vo.orname }</td>
				<td>${vo.orphone }</td>
				<td>${vo.oraddress }</td>
				<td>${vo.orpost }</td>
				<td>${vo.orpayment }</td>
				<td>${vo.orinvoice }</td>
				<td>${vo.ordelpay }</td>
				<td><a href="<%=request.getContextPath()%>/admin/orders/completeupdate?orid=${vo.orid}">구매확정</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<h2 class="orderstext3" style="position:absolute;top:670px;left:200px;">구매확정</h2>
<div class="boardcss_list_table3">
	<table class="orcomplete_table">
		<thead>
		<tr>
			<th>ID</th>
			<th>주문일</th>
			<th>수령자</th>
			<th>수령자연락처</th>
			<th>수령자주소</th>
			<th>수령자우편번호</th>
			<th>결제수단</th>
			<th>송장번호</th>
			<th>배송비</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list2 }">
			<tr>
				<td>${vo.mid }</td>
				<td>${vo.ordate }</td>
				<td>${vo.orname }</td>
				<td>${vo.orphone }</td>
				<td>${vo.oraddress }</td>
				<td>${vo.orpost }</td>
				<td>${vo.orpayment }</td>
				<td>${vo.orinvoice }</td>
				<td>${vo.ordelpay }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>