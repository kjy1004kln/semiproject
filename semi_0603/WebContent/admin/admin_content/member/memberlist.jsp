<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<div class="boardcss_list_table">
<table class="list_table">
	<thead>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>우편번호</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입일</th>
		<th>생일</th>
		<th>탈퇴여부</th>
		<th>마일리지</th>
		<th>수정</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="vo" items="${list }">
	<tr>
		<td>${vo.mid }</td>
		<td>${vo.mpw }</td>
		<td>${vo.mname }</td>
		<td>${vo.maddress }</td>
		<td>${vo.mpost }</td>
		<td>${vo.mphone }</td>
		<td>${vo.memail }</td>
		<td>${vo.mrdate }</td>
		<td>${vo.mbirth }</td>
		<td>${vo.mdrop }</td>
		<td>${vo.mmileage }</td>
		<td><a href="${cp }/admin/memberupdate?mid=${vo.mid }">수정</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<div class="page">
	<c:if test="${startPageNum>10 }">
		<a href="${cp}/admin/memberlist?pageNum=${startPageNum -1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/admin/memberlist?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:red">${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/memberlist?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:blue">${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/admin/memberlist?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>

<div class="page2">
<form method="post" action="${cp }/admin/memberlist">
		<select name="field">
			<option value="mid">아이디</option>
		</select>
		검색할아이디:<input type="text" name="keyword">
	<input type="button" value="검색">
</form>
</div>


<div id="insertbox">
	<form method="post" action="<%=request.getContextPath()%>/admin/memberinsert" style="margin-top:20px;">
		<label style="position:absolute;top:50px;left:100px; height:30px;font-size:20px;">아이디</label>
		<input type="text" name="mid" id="mid1" style="position:absolute; top:50px;left:200px;width:300px;height:30px;font-size:20px;">
		<input type="button" name="idcheck" id="idcheck" value="아이디확인" style="position: absolute;top:50px;left:530px;height:30px;width:80px;"><br>
		<div id="idmention" style="position: absolute;top:85px;left:200px;font-size:15px;color:red;"></div><br>
		<label style="position:absolute;top:110px;left:100px; height:30px;font-size:20px;">비밀번호</label>
		<input type="password" name="mpw" id="mpw" onkeyup="pwdcheck()" style="position:absolute; top:110px;left:200px;width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:175px;left:100px; height:30px;font-size:15px;">비밀번호 확인</label>
		<input type="password" name="mpwcheck" id="mpwcheck" onkeyup="pwdcheck()" style="position:absolute; top:170px;left:200px;width:300px;height:30px;font-size:20px;" ><br>
		<div id="pwdmention" style="position:absolute;top:205px;left:200px; height:30px;font-size:15px;"></div><br>
		<label style="position:absolute;top:230px;left:100px; height:30px;font-size:20px;">이름</label>
		<input type="text" name="mname" style="position:absolute;top:230px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:290px;left:100px; height:30px;font-size:20px;">주소</label>
		<input type="text" name="maddress" style="position:absolute;top:290px;left:200px; width:300px;height:120px;font-size:20px;"><br>
		<label style="position:absolute;top:450px;left:100px; height:30px;font-size:20px;">이메일</label>
		<input type="text" name="memail" style="position:absolute;top:450px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:500px;left:100px; height:30px;font-size:20px;">우편번호</label>
		<input type="text" name="mpost" style="position:absolute;top:500px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:560px;left:100px; height:30px;font-size:20px;">전화번호</label>
		<input type="text" name="mphone" style="position:absolute;top:560px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:620px;left:100px; height:30px;font-size:20px;">생일</label>
		<select name="year" style="position:absolute;top:620px;left:200px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1990" end="2000" var="y">
	         <option>
	               ${y }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="month" style="position:absolute;top:620px;left:300px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1" end="12" var="m">
	         <option>
	               ${m }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="day" style="position:absolute;top:620px;left:400px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1" end="31" var="d">
	         <option>
	               ${d }
	         </option>
	      </c:forEach>
		</select>
		<input class="btn btn-outline-dark" type="submit" value="등록" id="submitbtn" style="position:absolute;top:750px;left:320px; width:75px;height:30px;font-size:20px;line-height:5px;">
	</form>
</div>

</div>
<style>
	.boardcss_list_table { 
	position:absolute;
	top:100px;
	height:800px;
	width: 800px; 
	left:100px;
	border :1px solid #8BBDFF; 
}
/* 화면에 보여지는 글 목록 테이블 */
.list_table { 
	position: absolute;
	top:100px;
	left:50px;
	height:600px;
	width:700px;
	font-size: 0.7rem;
	display: block;
  	overflow: auto;
}
/* list_table 에서 사용되는 thead */
.list_table thead th { 
	text-align: center; 
	border-top: 1px solid #ABABAB;
	border-bottom: 1px solid #ABABAB; 
	padding: 8px 0; 
	background: #faf9fa; 
	width:600px;
}
.list_table tbody td { 
	text-align: center;  
	border-bottom: 1px solid #ABABAB; 
	padding: 5px 0; 
	width:600px;
}
.page{
	position: absolute;
	top:750px;
	left:300px;
	font-size: 1.5em;
}

.page2{
	position: absolute;
	top:50px;
	left: 400px;
	font-size: 1.2em;
}

#insertbox{
	 position: absolute;
	 top:0px;
	 left:950px;
	 height:800px;
	 width:700px;
	 border :1px solid #8BBDFF; 
}
</style>

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
