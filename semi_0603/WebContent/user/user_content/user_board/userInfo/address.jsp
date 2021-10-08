<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>address</h4> 자주 쓰는 배송지를 등록 관리하실 수 있습니다.
<form method="post" action="${cp }/user/addDelete" name="delForm">
<table class="table">
	<tr class="active">
		<th><input type="checkbox" id="ckall" name="addselect" onclick="selectAll(this)"></th>
		<th>배송지명</th>
		<th>수령인</th>
		<th>휴대전화</th>
		<th>우편번호</th>
		<th>주소</th>
		<th>수정</th>
	</tr>
		<c:choose>
				<c:when test="${empty addlist}">
					<tr>
						<td>주소가 없습니다.</td>
					</tr>
				</c:when>
		<c:otherwise>
		<c:forEach var="vo" items="${addlist }">
			<c:choose>
				<c:when test="${vo.maddress eq null }">
					<tr>
						<td>주소가 없습니다.</td>
					</tr>
				</c:when>
			<c:otherwise>
				<tr class="active">
					<td><input type="checkbox" id="ck1" name="addselect" ></td>
					<td>${vo.addtitle }</td>
					<td>${vo.addname }</td>
					<td>${vo.addphone }</td>
					<td>${vo.mpost }</td>
					<td>${vo.maddress }</td>
					<td><input type="button" value="수정 " onclick="location.href='${cp}/user/user_content/user_board/userInfo/addUpdate.jsp'"></td>
				</tr>
			</c:otherwise>
			</c:choose>
	</c:forEach>
	</c:otherwise>
	</c:choose>
</table>



<input type="button" value="선택 주소삭제" onclick="delAdd()">
<input type="button" value="배송지 등록" onclick="location.href='${cp}/user/user_content/user_board/userInfo/addressInsert.jsp'">
</form>
<script type="text/javascript">
	function selectAll(selectAll)  {
		  const checkboxes 
		       = document.getElementsByName('addselect');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked;
		  })
		}
	
		function delAdd(){
			let ck1=document.getElementById("ck1");
			var delForm=document.getElementsByName("delForm")[0];
			var DelConfirm=confirm("정말 삭제하시겠습니까?")
			if(ck1.checked){
				if(DelConfirm==true){
					alert("삭제 완료")
					delForm.submit();
				}else{
					alert("삭제 취소")
				}
			}else{
				alert("체크박스를 선택해 주세요")
			}
		}
</script>
<h4>배송주소록 유의사항</h4>
<ol>
	<li>배송 주소록은 최대 10개까지 등록할 수 있으며, 별도로 등록하지 않을 경우 최근 배송 주소록 기준으로 자동 업데이트 됩니다.</li>
	<li>자동 업데이트를 원하지 않을 경우 주소록 고정 선택을 선택하시면 선택된 주소록은 업데이트 대상에서 제외됩니다.</li>
	<li>기본 배송지는 1개만 저장됩니다. 다른 배송지를 기본 배송지로 설정하시면 기본 배송지가 변경됩니다.</li>
</ol>