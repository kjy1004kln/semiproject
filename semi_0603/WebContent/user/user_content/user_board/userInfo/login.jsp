<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
String errMsg =(String)request.getAttribute("errMsg");
    if(errMsg==null) {
		errMsg=""; //그냥 처음 페이지를 들어가면 errMsg가 null로 뜨기 때문에 보기 안좋음.
	}
%>
    
<h4>#MEMBER JOIN</h4>
<form action="${cp }/user/login" method="post" name="loginForm">
<input type="text" name="id" placeholder="ID">
<br>
<input type="text" name="pwd" placeholder="PW"><br>
<input type="submit" id="login" name="login" value="LOGIN"><br>
	<div id="d" style="color:red; font-size:12px"><%=errMsg %></div>
</form>
<br>

<a href="${cp }/user/findidpath">>아이디찾기</a>
<a href="${cp }/user/findpwd">>비밀번호찾기</a>
