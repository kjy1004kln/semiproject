<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="updatebox" style="border :1px solid #8BBDFF; position:fixed; top:10px; left:10px; width:480px; height:450px;">
	<form method="post" action="<%=request.getContextPath()%>/admin/memberupdate" style="margin-top:20px;">
		<label style="position:absolute;top:50px;left:100px; height:30px;font-size:20px;">아이디</label>
		<input type="text" value="${param.mid }" name="mid" id="mid1" style="position:absolute; top:50px;left:200px;width:300px;height:30px;font-size:20px;">
		<input type="button" name="idcheck" id="idcheck" value="아이디확인" style="position: absolute;top:50px;left:530px;height:30px;width:80px;"><br>
		<div id="idmention" style="position: absolute;top:85px;left:200px;font-size:15px;color:red;"></div><br>
		<label style="position:absolute;top:110px;left:100px; height:30px;font-size:20px;">비밀번호</label>
		<input type="password" value="${vo.mpw }" name="mpw" id="mpw" onkeyup="pwdcheck()" style="position:absolute; top:110px;left:200px;width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:175px;left:100px; height:30px;font-size:15px;">비밀번호 확인</label>
		<input type="password" name="mpwcheck" id="mpwcheck" onkeyup="pwdcheck()" style="position:absolute; top:170px;left:200px;width:300px;height:30px;font-size:20px;" ><br>
		<div id="pwdmention" style="position:absolute;top:205px;left:200px; height:30px;font-size:15px;"></div><br>
		<label style="position:absolute;top:230px;left:100px; height:30px;font-size:20px;">이름</label>
		<input type="text" value="${vo.mname }" name="mname" style="position:absolute;top:230px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:290px;left:100px; height:30px;font-size:20px;">주소</label>
		<input type="text" value="${vo.maddress }" name="maddress" style="position:absolute;top:290px;left:200px; width:300px;height:120px;font-size:20px;"><br>
		<label style="position:absolute;top:450px;left:100px; height:30px;font-size:20px;">이메일</label>
		<input type="text" value="${vo.memail }" name="memail" style="position:absolute;top:450px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:500px;left:100px; height:30px;font-size:20px;">우편번호</label>
		<input type="text" value="${vo.mpost }" name="mpost" style="position:absolute;top:500px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:560px;left:100px; height:30px;font-size:20px;">전화번호</label>
		<input type="text" name="mphone" style="position:absolute;top:560px;left:200px; width:300px;height:30px;font-size:20px;"><br>
		<label style="position:absolute;top:600px;left:100px; height:30px;font-size:20px;">마일리지</label>
		<input type="text" value="${vo.mmileage}" name="mmileage"style="position:absolute;top:600px;left:200px; width:300px;height:30px;font-size:20px;">
		<label style="position:absolute;top:640px;left:100px; height:30px;font-size:20px;">생일</label>
		<input type="text" value="${vo.mbirth }" name="mbirth"style="position:absolute;top:640px;left:200px; width:300px;height:30px;font-size:20px;">
		<select name="year" style="position:absolute;top:680px;left:200px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1990" end="2000" var="y">
	         <option>
	               ${y }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="month" style="position:absolute;top:680px;left:300px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1" end="12" var="m">
	         <option>
	               ${m }
	         </option>
	      </c:forEach>
		</select>
		
		<select name="day" style="position:absolute;top:680px;left:400px; width:100px;height:30px;font-size:20px;">
	      <c:forEach begin="1" end="31" var="d">
	         <option>
	               ${d }
	         </option>
	      </c:forEach>
		</select>
		<input class="btn btn-outline-dark" type="submit" value="수정" id="submitbtn" style="position:absolute;top:750px;left:320px; width:75px;height:30px;font-size:20px;line-height:5px;">
	</form>
</div>

<style>
	#updatebox{
	 position: absolute;
	 top:70px;
	 left:550px;
	 height:800px;
	 width:700px;
	 border :1px solid #8BBDFF; 
}
</style>