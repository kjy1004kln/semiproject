<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/sales.css">
<div class="top" style="position:absolute;height:400px;width: 1700px; top:100px;left:50px;border: 1px solid #8BBDFF;"></div>
<h3 style="position: absolute;top:120px;left:200px;">매출현황</h3>
	<select id="year" onclick="chang_insize()"style="position: absolute;top:120px;left:280px;width:60px;height:20px;font-size:15px;align-content:center;">
		<option value="2020">2019</option>
		<option value="2020">2020</option>
		<option value="2021">2021</option>
	</select>
	<div class="border border-3" id="columnchart_material" style="position:absolute;  top:170px;left:200px; width: 1500px; height:280px;">
</div>

<div class="center" style="position:absolute;height:150px;width: 1700px; top:520px;left:50px;border: 1px solid #8BBDFF;">
	<div style="position:absolute; top:0px;left:0px;width:500px;height:150px;border-right:1px solid #8BBDFF;">
		<img src="<%=request.getContextPath()%>/admin/upload/test2.png" style="position: absolute;top:35px;left:100px;width:80px;height:80px;">
		<label style="position: absolute;top:50px;left:200px;width: 120px;height: 50px; color:blue;font-size:30px;">회원수</label>
		<div id="result1" style="position: absolute;top:50px;left:320px;width: 120px;height: 50px; color:blue;font-size:30px;"></div>
	</div>
	<div style="position:absolute; top:0px;left:500px;width:500px;height:150px;border-right:1px solid #8BBDFF;">
		<img src="<%=request.getContextPath()%>/admin/upload/test1.png" style="position: absolute;top:35px;left:100px;width:80px;height:80px;">
		<label style="position: absolute;top:50px;left:200px;width: 120px;height: 50px; color:red;font-size:30px;">총매출</label>
		<div id="result2"style="position: absolute;top:60px;left:320px;width: 130px;height: 50px; color:red;font-size:20px;"></div>
	</div>
	<div style="position:absolute; top:0px;left:1000px;width:700px;height:150px;">
		<img src="<%=request.getContextPath()%>/admin/upload/test3.png" style="position: absolute;top:35px;left:100px;width:80px;height:80px;">
		<label style="position: absolute;top:50px;left:200px;width: 150px;height: 50px; color:green;font-size:30px;">베스트상품</label>
		<div id="result3" style="position: absolute;top:60px;left:380px;width: 140px;height: 50px; color:green;font-size:20px;"></div>
	</div>
</div>

<div class="under" style="position:absolute;height:230px;width: 1700px; top:690px;left:50px;border: 1px solid #8BBDFF;">

<h3 class="stocktext" style="position: absolute; top:10px; left:200px;">최근 한달 거래내역</h3>
	<table class="list_table">
		<thead>
		<tr>
			<th>상품번호</th>
			<th>판매수량</th>
			<th>판매금액</th>
			<th>판매날짜</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.pid }</td>
				<td>${vo.psell }</td>
				<td>${vo.pprice }</td>
				<td>${vo.prdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<style type="text/css">
.list_table { 
	position: absolute;
	top:50px;
	left:200px;
	height:210px;
	width:1300px;
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
	width:1200px;
}
.list_table tbody td { 
	text-align: center;  
	border-bottom: 1px solid #ABABAB; 
	padding: 5px 0; 
	width:1200px;
}

</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
 
    google.charts.load('current', {'packages':['bar']});
	 google.charts.setOnLoadCallback(drawChart);
	 function drawChart() {
   	  let xhr=new XMLHttpRequest();
 			xhr.onreadystatechange=function(){
 			if(xhr.readyState==4 && xhr.status==200){
 				let xml=xhr.responseXML;
 				let comm1=xml.getElementsByTagName("comm1");
 				let comm=xml.getElementsByTagName("comm");
 					var sum = new Array();
 					var pprice = new Array();
 					var inprice = new Array();
 					for(let i=0;i<comm.length;i++){
 							inprice[i]=comm[i].getElementsByTagName("inprice")[0].textContent;
 							pprice[i]=comm1[i].getElementsByTagName("pprice")[0].textContent;
 							sum[i]=pprice[i]-inprice[i];
 					}
 					var data = google.visualization.arrayToDataTable([
       	             	 ['월', '매입','매출','순수익'],
       	              	 ["1",Number(inprice[0]),Number(pprice[0]),Number(sum[0])],
       	             	 ["2",inprice[1],pprice[1],sum[1]],
       	             	 ["3",inprice[2],pprice[2],sum[2]],
       	            	 ["4",inprice[3],pprice[3],sum[3]],
      	             	 ["5",inprice[4],pprice[4],sum[4]],
      	             	 ["6",inprice[5],pprice[5],sum[5]],
      	                 ["7",inprice[6],pprice[6],sum[6]],
      	             	 ["8",inprice[7],pprice[7],sum[7]],
      	             	 ["9",inprice[8],pprice[8],sum[8]],
      	             	 ["10",inprice[9],pprice[9],sum[9]],
      	             	 ["11",inprice[10],pprice[10],sum[10]],
      	             	 ["12",inprice[11],pprice[11],sum[11]],
       	        		]);
 						var options = {
			            chart: {
			              }
			    	};
 					var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
 	           		chart.draw(data, google.charts.Bar.convertOptions(options));
 			}
 		};
 		xhr.open('get','${pageContext.request.contextPath}/admin/sales/chart.do',true);
 		xhr.send();
     }
    
    
function chang_insize(){
	 google.charts.load('current', {'packages':['bar']});
	 google.charts.setOnLoadCallback(drawChart1);
	function drawChart1() {
		var select=document.getElementById("year");
		year=select.options[select.selectedIndex].text;
		console.log(year)
	    let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let xml=xhr.responseXML;
			let comm1=xml.getElementsByTagName("comm1");
			let comm=xml.getElementsByTagName("comm");
				var sum = new Array();
				var pprice = new Array();
				var inprice = new Array();
				for(let i=0;i<comm.length;i++){
						inprice[i]=comm[i].getElementsByTagName("inprice")[0].textContent;
						pprice[i]=comm1[i].getElementsByTagName("pprice")[0].textContent;
						sum[i]=pprice[i]-inprice[i];
				}
				var data = google.visualization.arrayToDataTable([
  	             	 ['월', '매입','매출','순수익'],
  	             	["1",Number(inprice[0]),Number(pprice[0]),Number(sum[0])],
   	             	 ["2",inprice[1],pprice[1],sum[1]],
   	             	 ["3",inprice[2],pprice[2],sum[2]],
   	            	 ["4",inprice[3],pprice[3],sum[3]],
  	             	 ["5",inprice[4],pprice[4],sum[4]],
  	             	 ["6",inprice[5],pprice[5],sum[5]],
  	                 ["7",inprice[6],pprice[6],sum[6]],
  	             	 ["8",inprice[7],pprice[7],sum[7]],
  	             	 ["9",inprice[8],pprice[8],sum[8]],
  	             	 ["10",inprice[9],pprice[9],sum[9]],
  	             	 ["11",inprice[10],pprice[10],sum[10]],
  	             	 ["12",inprice[11],pprice[11],sum[11]],
  	        		]);
					var options = {
		            chart: {
		              }
		    	};
				var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
           		chart.draw(data, google.charts.Bar.convertOptions(options));
		}
	};
	xhr.open('get','${pageContext.request.contextPath}/admin/sales/chart2.do?year='+year,true);
	xhr.send();
	}
}
window.onload=function(){
	  let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				const result1=document.getElementById("result1");
				const result2=document.getElementById("result2");
				const result3=document.getElementById("result3");
				let xml=xhr.responseXML;
				
				let mid=xml.getElementsByTagName("mid")[0].textContent;
				let price=xml.getElementsByTagName("price")[0].textContent;
				let sname=xml.getElementsByTagName("sname")[0].textContent;
				result1.innerHTML=mid+"명";
				result2.innerHTML=price+"원";
				result3.innerHTML=sname;
			}
		};
		xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/sales/sales_ajax1.jsp',true);
		xhr.send(); 
}
</script>
