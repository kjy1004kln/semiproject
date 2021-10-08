<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>my info</h4>
	<%
		String mid=(String)session.getAttribute("id"); //login 컨트롤러에서 session 저장된 것 꺼내오기
		String mpw1=(String)session.getAttribute("pwd"); 
		String mname=(String)session.getAttribute("mname");
		String mphone=(String)session.getAttribute("mphone"); 
		String memail=(String)session.getAttribute("memail"); 
		String glevel=(String)session.getAttribute("glevel");
		String nextSum=(String)session.getAttribute("nextSum");
		String nextDrate=(String)session.getAttribute("nextDrate");
	%>
<div id="box1" style="border: 1px solid #D5D5D5">
저희 쇼핑몰을 이용해 주셔서 감사합니다. '<%=mid%>'님은 '<%=glevel %>'회원이십니다. 
'<%=nextSum %>'원 이상 구매시 '<%=nextDrate %>'을 추가적립 받으실 수 있습니다.
</div>
<form action="${cp }/user/update" method ="post" name="updateForm" class="form-horizontal">
 	<div class="form-group">
	 <label for="inputid1" class="col-sm-2 control-label">아이디*</label>
	 <div class="col-sm-10">
	 <input type="text" name="mid" value="<%=mid%>" readonly="readonly">(영문소문자/숫자, 4~16자)<br>
	 </div>
	 </div>
	 
	 <div class="form-group">
    <label for="inputPassword1" class="col-sm-2 control-label">
	현재 비밀번호</label>
	<div class="col-sm-10">
	<input type="text" class="form-control" name="mpw">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자~16자)<br> 
	</div>
	</div>
	
	<div class="form-group">
    <label for="inputPassword2" class="col-sm-2 control-label">
	새 비밀번호</label>
	<div class="col-sm-10">
	<input type="text" name="newpw" class="form-control" onkeyup="pwdcheck()">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자~16자)<br>
	</div>
	</div>
	
	 <div class="form-group">
	 <label for="inputPassword3" class="col-sm-2 control-label">
	새 비밀번호 확인</label>
	<div class="col-sm-10">
	<input type="text" name="newpwok" class="form-control" onkeyup="pwdcheck()"></div><div id="newpwbox"></div><br>
	 </div>
	 
	 <div class="form-group">
	 <label for="inputid1" class="col-sm-2 control-label">
	이름*</label>
	<div class="col-sm-10">
	<input type="text" name="mname" class="form-control" value="<%=mname%>" readonly="readonly"><br>
	</div>
	</div>
	
	<div class="form-group">
	 <label for="inputphone" class="col-sm-2 control-label">
	휴대전화*	</label>
	<div class="col-sm-10">
	<input type="tel" name="mphone" class="form-control" value="<%=mphone%>"><br>
	</div>
	</div>
	
	<div class="form-group">
	<label for="inputemail" class="col-sm-2 control-label">
	이메일*</label>
	<div class="col-sm-10">
	<input type="email" name="memail" class="form-control" value="<%=memail%>"><br>
</div>
</div>	
	생년월일*<br>
	<input type="date"  name="mbirth"><br>
<input type="button" value="회원정보수정" onclick="updateck()">
<input type="button" value="취소" onclick="location.href='${cp}/user/home'">
</form>

<form name="delForm" action="${cp }/user/delaccount" method="post">
<input type="hidden" value="<%=mid %>">
<input type="button" value="회원 탈퇴" onclick="userDel(event)">
</form>

<script type="text/javascript">
	function updateck(){
		var mpw=document.getElementsByName("mpw")[0].value;
		var newpw=document.getElementsByName("newpw")[0].value;
		var newpwok=document.getElementsByName("newpwok")[0].value;
		var mbirth=document.getElementsByName("mbirth")[0].value;
		var updateForm=document.getElementsByName("updateForm")[0];
		var mname=document.getElementsByName("mname")[0].value;
		var mphone=document.getElementsByName("mphone")[0].value;
		var memail=document.getElementsByName("memail")[0].value;
		if(mpw!="<%=mpw1%>"){
			alert("현재 비밀번호가 틀렸습니다")
		}else if(newpw=="<%=mpw1%>"){
			alert("이전 비밀번호와 동일합니다")
		}else if(newpw==null || newpw==""){
			alert("새로운 비밀번호를 입력하세요");
		}else if(newpwok==null || newpw==""){
			alert("새로운 비밀번호확인을 입력하세요");
		}else if(newpw.length<10 || newpw.length>16){
			alert("비밀번호는 10자~ 16자 사이로 입력해 주세요");
		}else if(newpw!=newpwok){
			alert("비밀번호를 다시 확인해 주세요");
		}else if(!newpw.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/)){
			 alert("영문+숫자+특수기호(!@$%^&* 만 허용)으로 구성하여야 합니다.영문은 대소문자를 구분합니다.");
		}else{
			updateForm.submit();
		}	
	}
	function pwdcheck(){ //새 비밀번호 체크
		var mpw=document.getElementsByName("mpw")[0].value;
		var newpw=document.getElementsByName("newpw")[0].value;
		var newpwok=document.getElementsByName("newpwok")[0].value;
		let newpwbox=document.getElementById("newpwbox");
		console.log("11")
		if(newpw==newpwok){
			newpwbox.innerHTML="비밀번호가 일치합니다";
		}else{
			newpwbox.innerHTML="비밀번호가 일치하지 않습니다.";
		}
	}
	function userDel(e){ //탈퇴
		var delForm=document.getElementsByName("delForm")[0];
		var mpw=document.getElementsByName("mpw")[0].value
		var DelConfirm=confirm("정말 탈퇴하시겠습니까?")
		if(mpw=="<%=mpw1%>"){
			if(DelConfirm==true){
				alert("탈퇴완료되었습니다. 이용해주셔서 감사합니다")
				delForm.submit();
			}else{
				alert("탈퇴가 취소되었습니다")
			}
		}else{
			alert("현재 비밀번호가 정확하지 않습니다")
		}
	}
</script>