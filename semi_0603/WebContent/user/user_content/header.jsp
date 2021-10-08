<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header.jsp -->

<%
	String id=(String)session.getAttribute("id");
%>
<style>
	#category{float:left; margin-right: 80px;}
	#community{float:left;margin-right: 80px;}
	#member{float:left; margin-right: 80px;}
	#callbank{float:left;}
	a{text-decoration: none; color:black; }
</style>
<div id ="wrap">
	<h1><a href="${cp }/user/home">J4</a></h1>
	<div id ="category">
		<h3>category</h3>
		<a href="${cp }/user/new/list">new</a><br>
		<a href="${cp }/user/best/list">best 30</a><br>
		<a href="${cp }/user/outer/list">outer</a><br>
		<a href="${cp }/user/top/list">top</a><br>
		<a href="${cp }/user/ops/list">ops</a><br>
		<a href="${cp }/user/skirt/list">skirt</a><br>
		<a href="${cp }/user/pants/list">pants</a><br>
		<a href="${cp }/user/shoes/list">shoes&bag</a><br>
		<a href="${cp }/user/acc/list">acc</a>
	</div>
	<div id ="community">
		<h3>community</h3>
		<a href="${cp }/user/notice">notice</a><br>
		배송 전 변경/취소<br>
		<a href="${cp }/user/review">review</a><br>
		<a href="${cp }/user/qna">q&a</a><br>
		<a href="${cp }/user/faq">faq</a>
		
	</div>
	<div id ="member">
		<h3>member</h3>
		<c:choose>
			<c:when test="${empty sessionScope.id}">
				<a href="${cp }/user/login">login</a><br> 
			</c:when>
			<c:otherwise>
				<a href="${cp }/user/user_content/user_board/userInfo/logout.jsp">logout</a><br>
			</c:otherwise>
		</c:choose>
		<a href="${cp }/user/join">join+1000</a><br>
		<a href="${cp }/user/cartList">shopping cart</a><br>
		<a href="${cp }/user/purchase">order list</a><br>
		<a href="${cp }/user/mypage">my shopping</a>
	</div>
	<div id = "callbank" style="float: right;">
		<div id ="call">
			<h3>T. 070-8889-3598</h3>
			mon-fri pm1:00~pm5:00<br>
			lunch pm12:00~pm1:00<br>
			sat.sun hooiday off
		</div>
		<div id ="bankInfo">
			<h3>bank info</h3>
			국민 679801-01-335797<br>
			예금주 : 주식회사 J4<br>
			sat.sun hooiday off
		</div>
	</div>
</div>
