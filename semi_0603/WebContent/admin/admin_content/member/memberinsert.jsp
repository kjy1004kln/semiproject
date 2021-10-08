<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberinsert.jsp</title>
<style>
	#insertbox{
		position:absolute;
		top:100px;
		left:300px;
	}
</style>
</head>
<body>
<div id="insertbox" style="border :1px solid #8BBDFF; position:fixed; top:10px; left:10px; width:480px; height:450px;">
	<form method="post" action="<%=request.getContextPath()%>/admin/memberinsert" style="margin-top:20px;">
		아이디<input type="text" name="mid" id="mid1">
		<input type="button" name="idcheck" id="idcheck" value="아이디확인"><br>
		<div id="idmention"></div><br>
		비밀번호<input type="password" name="mpw" id="mpw" onkeyup="pwdcheck()"><br>
		비밀번호 확인<input type="password" name="mpwcheck" id="mpwcheck" onkeyup="pwdcheck()"><br>
		<div id="pwdmention"></div><br>
		이름<input type="text" name="mname"><br>
		주소<input type="text" name="maddress"><br>
		이메일<input type="text" name="memail"><br>
		우편번호<input type="text" name="mpost"><br>
		전화번호<input type="text" name="mphone"><br>
		
		생일	
		<select name="year">
	      <c:forEach begin="1990" end="2000" var="y">
	         <option>
	               ${y }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="month">
	      <c:forEach begin="1" end="12" var="m">
	         <option>
	               ${m }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="day">
	      <c:forEach begin="1" end="31" var="d">
	         <option>
	               ${d }
	         </option>
	      </c:forEach>
		</select>
		<input type="submit" value="등록" id="submitbtn" disabled="disabled">
	</form>
	
</div>
<script type="text/javascript">
	let idcheck=document.getElementById("idcheck");
	let submitbtn=document.getElementById("submitbtn");
	idcheck.onclick=function(e){
		var mid1=document.getElementById("mid1").value;
		const div=document.getElementById("idmention");
		console.log(mid1);
		if(mid1=="" || mid1==null){
			idmention.innerHTML="아이디 입력필요!";
			return;
		}
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let result=xhr.responseText;
				let json=JSON.parse(result);
				if(json.using==true){
					div.innerHTML="사용중인 아이디";
				}else{
					div.innerHTML="사용가능한 아이디입니다.";
					submitbtn.disabled=false;
				}
			}
		};
		xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/member/idcheck.jsp?mid1='+mid1, true);
		xhr.send();
	};
	
	var mpw=document.getElementById("mpw").value;
	var mpwcheck=document.getElementById("mpwcheck").value;
	const pwdmention=document.getElementById("pwdmention");
	if(mpw=="" || mpw==null){
		pwdmention.innerHTML="비밀번호를 입력하세요.";
	}
	function pwdcheck(){
		var mpw=document.getElementById("mpw").value;
		var mpwcheck=document.getElementById("mpwcheck").value;
		if(mpw==mpwcheck){
			pwdmention.innerHTML="비밀번호가 일치합니다.";
		}else{
			pwdmention.innerHTML="비밀번호가 일치하지 않습니다.";
		}
	}
</script>
</body>
</html>