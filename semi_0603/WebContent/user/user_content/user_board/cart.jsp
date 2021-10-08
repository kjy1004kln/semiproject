<%@page import="user.dao.User_CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
cart
<form action="../../../payment" method="post">
	<br>
	<!-- 회원정보뜨게!!! -->
	${sessionScope.id } 님은, [${gradevo.glevel }] 회원이십니다.
	<br>
	1,000 이상 구매시 ${per }%을 추가적립 받으실 수 있습니다.
	<br>
	보유적립금: ${membervo.mmileage }원 &nbsp; 쿠폰:0개
	<br>
	카트내역
	<br>
	<table class="table">
		<tr>
			<th><input type="checkbox" id="topcheck" onclick="checkAll()"></th>
			<th>이미지</th>
			<th>상품정보</th>
			<th>판매가</th>
			<th>수량</th>
			<th>적립금</th>
			<th>배송비</th>
			<th>합계</th>
			<th>선택</th>
		</tr>
		<c:choose>
			<c:when test="${leng==0 }">
			<tr>
				<td colspan="9">
				카트에 물품이 존재하지 않습니다.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<c:forEach begin="0" end="${leng-1 }" var="i" >
				<tr id = "tr${i }" name = "product">
					<input type="hidden" id ="wid" value ="${list.get(i).wid }">
					<input type="hidden" name ="leng" value ="${leng }">
					<input type="hidden" name ="pid" value ="${productlist.get(i).pid }">
					<input type="hidden" name ="orSize" value ="${stocklist.get(i).ssize }">
					<input type="hidden" name ="orColor" value ="${stocklist.get(i).scolor }">
					<input type="hidden" name ="amount" value ="${list.get(i).camount }">
					<input type="hidden" name ="orMileage" value ="${productlist.get(i).pprice*(100-productlist.get(i).pdiscount)/10000 }">
					<input type="hidden" name ="dbprice" value ="${productlist.get(i).pprice }">
					<input type="hidden" name ="dbsale" value ="${productlist.get(i).pprice*productlist.get(i).pdiscount/100 }">
					<td><input type="checkbox" name="check" id="ck,${list.get(i).wid }"></td>
					<td>
					<img src="${cp }/img/${productlist.get(i).pimage2 }"style = "width:100px; height:outo;">
					</td>
					<th>${stocklist.get(i).sname }<br><br>
						[옵션: ${list.get(i).csize }, ${list.get(i).ccolor }]
					</th>
					<!-- 할인상품이면 할인된거 표시되게 하기 -->
					<td name = "sellPrice">${productlist.get(i).pprice*(100-productlist.get(i).pdiscount)/100 }</td>
					<td>
						<a id="min,${i }"href="javascript:minBtn(${i })" >
							<span class="glyphicon glyphicon-minus" ></span>
						</a>
						<input type="text" name="camount" value="${list.get(i).camount }" size="1" >
						<a href="javascript:plusBtn(${i })" id="plus,${i }" >
							<span class="glyphicon glyphicon-plus" id="plus,${i }"></span>
						</a>
					</td>
					<td><img src="//img.echosting.cafe24.com/design/skin/admin/ko_KR/ico_product_point.gif" alt="적립금">
					<span name = "cmil">${productlist.get(i).pprice*(100-productlist.get(i).pdiscount)/10000 }원</span>
					</td>
					<td>무료배송</td>
					<td name = "productPay">${productlist.get(i).pprice*(100-productlist.get(i).pdiscount)/100*list.get(i).camount }원</td>
					<td>
						<input type="button" id="btn,${i }" value="삭제" onclick="deleteOne(this.id)">	
					</td>
				</from>
				</tr>
			</c:forEach>
			<tr>
				<td  colspan="2">
				선택상품 
				<input type="button" id="selectDel" value="삭제" onclick="selDelete()">
				</td>
				<td colspan="7"><input type="button" id="delAll" value="장바구니 비우기" style="float: right;" onclick="deleteAll()"></td>
			</tr>			
			</c:otherwise>
		</c:choose>
	</table>
	
	<table class="table">
		<tr>
			<td>총 상품 금액</td>
			<td>배송비</td>
			<td>총 할인금액</td>
			<td>결제예정 금액</td>
		</tr>
		<tr>
			<th id="allPay">${allPay }</th>
			<th>+0</th>
			<th id="allSale">${allSale }</th>
			<th id="resultPay">${resultPay }</th>
		</tr>	
	</table>
	<input type="submit" value="전체상품주문" formaction="${cp }/user/order">
	<a href="${cp }/user/home">
	<input type="button" value="쇼핑계속하기">
	</a>
</form>
	<script>
		function minBtn(id){
			let camount = document.getElementsByName("camount")[id];
			if(camount.value>1){
			let result =  parseInt(camount.value)-1;
			let cmil= document.getElementsByName("cmil")[id];
			let productPay=document.getElementsByName("productPay")[id];
			cmil.innerHTML=parseInt(cmil.innerHTML)-parseInt(cmil.innerHTML)/camount.value+"원";
			productPay.innerHTML= parseInt(productPay.innerHTML)-parseInt(productPay.innerHTML)/camount.value+"원";
			camount.value = result;
			let pprice = document.getElementsByName("dbprice")[id];
			let psale = document.getElementsByName("dbsale")[id];
			let allPay = document.getElementById("allPay");
			let allSale = document.getElementById("allSale");
			let resultPay = document.getElementById("resultPay");
			
			let sellPrice = document.getElementsByName("sellPrice")[id];
			allPay.innerHTML = parseInt(allPay.innerHTML)-parseInt(sellPrice.innerHTML);
			allSale.innerHTML = parseInt(allSale.innerHTML)-parseInt(psale.value);
			resultPay.innerHTML = parseInt(resultPay.innerHTML)-parseInt(pprice.value)+parseInt(psale.value);
			}else{
				alert('최소주문수량은 1개입니다.')
			}
		}
		function plusBtn(id){
			let camount = document.getElementsByName("camount")[id];
			let result =  parseInt(camount.value)+1;
			let cmil= document.getElementsByName("cmil")[id];
			let productPay=document.getElementsByName("productPay")[id];
			cmil.innerHTML= parseInt(cmil.innerHTML)+parseInt(cmil.innerHTML)/camount.value+"원";
			productPay.innerHTML= parseInt(productPay.innerHTML)+parseInt(productPay.innerHTML)/camount.value+"원";
			camount.value = result;
			let pprice = document.getElementsByName("dbprice")[id];
			let psale = document.getElementsByName("dbsale")[id];
			let allPay = document.getElementById("allPay");
			let allSale = document.getElementById("allSale");
			let resultPay = document.getElementById("resultPay");
			
			console.log(psale.value)
			let sellPrice = document.getElementsByName("sellPrice")[id];
			allPay.innerHTML = parseInt(allPay.innerHTML)+parseInt(sellPrice.innerHTML);
			allSale.innerHTML = parseInt(allSale.innerHTML)+parseInt(psale.value);
			resultPay.innerHTML = parseInt(resultPay.innerHTML)+parseInt(pprice.value)-parseInt(psale.value);
		}
		function selDelete(){
			let check = document.getElementsByName("check");
			for (var i = 0; i < check.length; i++) {
				if(check[i].checked){
					let num = check[i].id.split(',')[1]
					let xhr = new XMLHttpRequest();
					xhr.open("get","<%=request.getContextPath() %>/user/user_content/user_board/cartselDeleteServer.jsp?num="+num,true);
					xhr.send();
				}
			window.location.reload();
			}
		}
		function deleteAll(){
			let xhr = new XMLHttpRequest();
			xhr.open("get","<%=request.getContextPath() %>/user/user_content/user_board/cartDeleteServer.jsp",true);
			xhr.send();
			window.location.reload();
		}
		function checkAll(){
			let check = document.getElementsByName("check");
			let topcheck = document.getElementById("topcheck");
			if(topcheck.checked){
				for(i=0; i < check.length; i++) {
					check[i].checked = true;
				}
			}else{
				for(i=0; i < check.length; i++) {
					check[i].checked = false;
					}
				}
		}
		function deleteOne(id){
			let num = id.split(',')[1];
			let trid = document.getElementById("tr"+num);
			let wid = document.getElementById("wid").value;
			let xhr = new XMLHttpRequest();
			xhr.open("get","<%=request.getContextPath() %>/user/user_content/user_board/cartServer.jsp?wid="+wid,true);
			xhr.send();
			window.location.reload();
		}
	</script>
<h4>이용안내</h4>
장바구니 이용안내
<ul>
	<li>
		해외배송 상품과 국내배송 상품은 함께 결제하실 수 없으니 장바구니 별로 따로 결제해 주시기 바랍니다.
	</li>
	<li>
		해외배송 가능 상품의 경우 국내배송 장바구니에 담았다가 해외배송 장바구니로 이동하여 결제하실 수 있습니다.
	</li>
	<li>
		선택하신 상품의 수량을 변경하시려면 수량변경 후 [변경] 버튼을 누르시면 됩니다.
	</li>
	<li>
		[쇼핑계속하기] 버튼을 누르시면 쇼핑을 계속 하실 수 있습니다.
	</li>
	<li>
		장바구니와 관심상품을 이용하여 원하시는 상품만 주문하거나 관심상품으로 등록하실 수 있습니다.
	</li>
	<li>
		파일첨부 옵션은 동일상품을 장바구니에 추가할 경우 마지막에 업로드 한 파일로 교체됩니다.
	</li>
</ul>
무이자할부 이용안내
<ul>
	<li>
		상품별 무이자할부 혜택을 받으시려면 무이자할부 상품만 선택하여 [주문하기] 버튼을 눌러 주문/결제 하시면 됩니다.
	</li>
	<li>
		[전체 상품 주문] 버튼을 누르시면 장바구니의 구분없이 선택된 모든 상품에 대한 주문/결제가 이루어집니다.
	</li>
	<li>
		단, 전체 상품을 주문/결제하실 경우, 상품별 무이자할부 혜택을 받으실 수 없습니다.
	</li>
</ul>
