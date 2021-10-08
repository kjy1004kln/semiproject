<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>find id</h4>
<ul>
	<li>가입하신 방법에 따라 아이디 찾기가 가능합니다. </li>
	<li>법인사업자 회원 또는 외국인 회원의 경우 법인명과 법인번호 또는 이름과 등록번호를 입력해 주세요.</li>
</ul>
<br>
<br>
<br>
이름:<input type="text" id="mname"><br>
이메일:<input type="text" id="memail"><br>
<input type="submit" value="찾기" id="search">

<div id="box">
</div>
<script type="text/javascript">
let search=document.getElementById("search");
search.onclick=function(e){
	const mname=document.getElementById("mname").value;
	const memail=document.getElementById("memail").value;
	console.log(mname)
	console.log(memail)
	const div=document.getElementById("box");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let result=xhr.responseText;
			let json=JSON.parse(result);
			
				div.innerHTML="["+mname+"]님의 아이디는 "+json.mid+"입니다.";
			
		}
	};
	xhr.open('get','<%=request.getContextPath()%>/user/user_content/user_board/userInfo/idck.jsp?mname='+mname+'&memail='+memail, true);
	xhr.send();
};
</script>