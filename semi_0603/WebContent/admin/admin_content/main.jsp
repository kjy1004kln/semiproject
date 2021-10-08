<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<h3 style="position:fixed; top:70px;left:550px">가입자 현황</h3>

<div class="border border-3" id="curve_chart" style="position: absolute; top:100px; left:50px; width: 1100px; height: 500px; border: 1px solid #8BBDFF;"></div>

<div class="border border-3" style="position:absolute;  top:100px;left:1200px; width: 680px; height: 500px;">
<h3 class="members" style="position: fixed; top:70px; left:1460px;">최근 한달 가입자 명단</h3>
	<table class="list_table">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>생일</th>
			<th>이메일</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.mid }</td>
				<td>${vo.mname }</td>
				<td>${vo.maddress }</td>
				<td>${vo.mbirth }</td>
				<td>${vo.memail }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<!-- 하단 바로가기 매뉴 -->
<div class="border border-3" id="member" style=" position:absolute; width: 340px; height: 300px; top:630px; left:52px;">
<img src="<%=request.getContextPath()%>/admin/img/member.jpg" style="position: absolute; top:10px;left:50px;width:200px;height:150px;">
<a href="${cp }/admin/memberlist" style="position: absolute; top:160px;left:130px;font-size:20px; color:black;">회원리스트</a>
</div>
<div class="border border-3" id="product" style=" position:absolute; width: 340px; height: 300px; top:630px; left:422px;">
<img src="<%=request.getContextPath()%>/admin/img/product.jpg" style="position: absolute; top:10px;left:50px;width:200px;height:150px;">
<a href="${cp }/admin/inbound/list" style="position: absolute; top:160px;left:130px;font-size:20px; color:black;">입고</a>
<a href="${cp }/admin/product/list" style="position: absolute; top:200px;left:130px;font-size:20px; color:black;">등록/수정</a>
<a href="${cp }/admin/orders/list" style="position: absolute; top:240px;left:130px;font-size:20px; color:black;">출고</a>
</div>
<div class="border border-3" id="stock" style=" position:absolute; width: 340px; height: 300px; top:630px; left:792px;">
<img src="<%=request.getContextPath()%>/admin/img/stock.jpg" style="position: absolute; top:10px;left:50px;width:200px;height:150px;">
<a href="${cp }/admin/sales/list" style="position: absolute; top:160px;left:130px;font-size:20px; color:black;">통계</a>
</div>
<div class="border border-3" id="test" style=" position:absolute; width: 340px; height: 300px; top:630px; left:1162px;">
<img src="<%=request.getContextPath()%>/admin/img/border.jpg" style="position: absolute; top:10px;left:50px;width:200px;height:150px;">
<a href="${cp }/admin/qna" style="position: absolute; top:160px;left:130px;font-size:20px; color:black;">QNA</a>
<a href="${cp }/admin/faq/list" style="position: absolute; top:200px;left:130px;font-size:20px; color:black;">FAQ</a>
<a href="${cp }/admin/notice/list" style="position: absolute; top:240px;left:130px;font-size:20px; color:black;">공지사항</a>
</div>
<div class="border border-3" id="test1" style=" position:absolute; width: 340px; height: 300px; top:630px; left:1540px;">
<img src="<%=request.getContextPath()%>/admin/img/qna.jpg" style="position: absolute; top:10px;left:50px;width:200px;height:150px;">
<a style="position: absolute; top:160px;;left:100px;font-size:20px; color:black;">미처리현황</a>
<a style="position: absolute; top:200px;left:50px;font-size:20px; color:black;">QNA : </a>
<div id="result" style="position: absolute; top:200px;left:140px; width:50px;height:30px; font-size:20px;"></div>
<a style="position: absolute; top:240px;left:50px;font-size:20px; color:black;">배송중 :</a>
<div id="result1" style="position: absolute; top:240px;left:140px;width:50px;height:30px; font-size:20px;"></div>
</div>

<style type="text/css">
.list_table { 
	position: absolute;
	top:50px;
	left:50px;
	height:400px;
	width:580px;
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
	width:480px;
}
.list_table tbody td { 
	text-align: center;  
	border-bottom: 1px solid #ABABAB; 
	padding: 5px 0; 
	width:480px;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
          
          google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart1);
          function drawChart1() {
        	  let xhr=new XMLHttpRequest();
      			xhr.onreadystatechange=function(){
      			if(xhr.readyState==4 && xhr.status==200){
      				let xml=xhr.responseXML;
      				let comm3=xml.getElementsByTagName("comm3");
      				let comm4=xml.getElementsByTagName("comm4");
      				let comm5=xml.getElementsByTagName("comm5");
      					var mmileage = new Array();
      					var mmileage1 = new Array();
      					var mmileage2 = new Array();
      					for(let i=0;i<comm3.length;i++){
      						mmileage[i]=comm3[i].getElementsByTagName("mmileage")[0].textContent;
      						mmileage1[i]=comm4[i].getElementsByTagName("mmileage1")[0].textContent;
      						mmileage2[i]=comm5[i].getElementsByTagName("mmileage2")[0].textContent;
      						}
      						var data = google.visualization.arrayToDataTable([
 	       	             	['월', '총인원','성인','미성년'],
 	       	         		["1",Number(mmileage[0]),Number(mmileage1[0]),Number(mmileage2[0])],
 	       	         		["2",mmileage[1],mmileage1[1],mmileage2[1]],
 	       	         		["3",mmileage[2],mmileage1[2],mmileage2[2]],
 	       	         		["4",mmileage[3],mmileage1[3],mmileage2[3]],
 	       	         		["5",mmileage[4],mmileage1[4],mmileage2[4]],
 	       	        	 	["6",mmileage[5],mmileage1[5],mmileage2[5]],	
 	       			        ["7",mmileage[6],mmileage1[6],mmileage2[6]],
			 	       	    ["8",mmileage[7],mmileage1[7],mmileage2[7]],
 	       					["9",mmileage[8],mmileage1[8],mmileage2[8]],
 	       					["10",mmileage[9],mmileage1[9],mmileage2[9]],
 	       					["11",mmileage[10],mmileage1[10],mmileage2[10]],
 	       					["12",mmileage[11],mmileage1[11],mmileage2[11]]
 	       	      		    ]);
      						var options = {
      					        curveType: 'function',
      					        legend: { position: 'bottom' }
      					      };
      					      var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
      					      chart.draw(data, options);
      					    }
      					};
      				  xhr.open('get','${pageContext.request.contextPath}/admin/main/chart.do',true);
		      		  xhr.send();
         	}
          window.onload=function(){
        	  let xhr=new XMLHttpRequest();
        		xhr.onreadystatechange=function(){
        			if(xhr.readyState==4 && xhr.status==200){
        				const result=document.getElementById("result");
        				let xml=xhr.responseXML;
        				let qid=xml.getElementsByTagName("qid")[0].textContent;
        				result.innerHTML=+qid+"건";
        			}
        		};
        		xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/item/main_ajax.jsp',true);
        		xhr.send(); 
        	  }
        	  let xhr=new XMLHttpRequest();
        		xhr.onreadystatechange=function(){
        			if(xhr.readyState==4 && xhr.status==200){
        				const result1=document.getElementById("result1");
        				let xml=xhr.responseXML;
        				let ordelivery=xml.getElementsByTagName("ordelivery")[0].textContent;
        				result1.innerHTML=+ordelivery+"건";
        			}
        		};
        		xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/item/main_ajax2.jsp',true);
        		xhr.send(); 
</script>
