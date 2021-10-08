<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
<div id="top">
	<img src="<%=request.getContextPath()%>/admin/img/test.png" style="position:absolute;width:50px;height:50px;">
	<h1 style="position:absolute; color:white;left:60px; line-height:50px;">관리자 페이지</h1>
	<input class="btn btn-dark" type="button" value="홈페이지" id="homebtn" onclick="location='<%=request.getContextPath()%>/user/home'">
	<input class="btn btn-dark" type="button" value="로그아웃" id="logoutbtn" onclick="location='<%=request.getContextPath()%>/admin/admin_content/admin_login.jsp'">
</div>

<!-- 콘탠트 영역 -->
<div id="content">
	<jsp:include page="${content }"/>
</div>

<!-- 메뉴구성 -->
<input type="checkbox" id="menuicon">
<ul>
	<li>
		<label for="menuicon">
			<span></span><span></span><span></span>
		</label>
</ul>
<div class="sidebar">
	<img class="profile" src="<%=request.getContextPath()%>/admin/img/profile.jpg">
	<ul id="ac">
		<li class="main"><a href="${cp }/admin/main" style="color: white;">메인</a>
		</li>
	</ul>
	<ul id="ac">
		<li class="main"><a href="${cp }/admin/memberlist" style="color: white;">회원관리</a>
		</li>
	</ul>
	<ul id="ac">
		<li class="main">
		상품관리
			<ul class="sub">
				<li><a href="${cp }/admin/inbound/list">입고</a></li>
				<li><a href="${cp }/admin/product/list">등록/수정</a></li>
				<li><a href="${cp }/admin/orders/list">출고</a></li>
			</ul>
		</li>
	</ul>
	<ul id="ac">
		<li class="main"><a href="${cp }/admin/sales/list" style="color: white;">통계</a>
		</li>
	</ul>
	<ul id="ac">
		<li class="main">
		게시판관리
			<ul class="sub">
				<li><a href="${cp }/admin/qna">QnA</a></li>
				<li><a href="${cp }/admin/faq/list">FAQ</a></li>
				<li><a href="${cp }/admin/notice/list">공지사항</a></li>
			</ul>
		</li>
	</ul>
</div>
<script type="text/javascript">
	$('.main').click(function(){
		$('.sub').slideUp();
		if($(this).children('.sub').is(':visible')){
			$(this).children('.sub').slideUp();
		}else{
			$(this).children('.sub').slideDown();
		}
	});
</script>
</body>
</html>