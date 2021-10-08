<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/login.css">
<title> CSS Login Screen Tutorial </title>
</head>
<body>
  <body>
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h3>LOGIN</h3>
            <p>관리자 로그인</p>
          </div>
        </div>
        <form class="login-form" method="post" action="<%=request.getContextPath()%>/admin/login">
          <input type="text" name="id" id="id" placeholder="username"><br>
          <input type="password" name="pwd" id="pwd" placeholder="password"><br>
          <button>login</button>
          <p class="message"> <a href="#"></a></p>
        </form>
      </div>
    </div>
<% String result = (String)request.getAttribute("result");
	if(result=="fail"){
%>
<script type="text/javascript">
		alert("아이디 또는 비밀번호가 맞지 않아요");
		history.go(-1);
</script>
<%
	}
%>
</body>
</body>
</html>