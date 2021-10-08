<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" action="<%=request.getContextPath()%>/user/qnapwdcheck">
	<input type="hidden" value="${vo.qid }" name="qid">
	비밀번호 확인:<input type="text" name="pwdcheck">
	<input type="submit" value="확인">
</form>
<% String result = (String)request.getAttribute("result");
	if(result=="fail"){
%>
<script type="text/javascript">
		alert("비밀번호가 맞지 않아요");
		history.go(-1);
</script>
<%
	}
%>