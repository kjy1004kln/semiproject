<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/inbound.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<div class="boardcss_list_table">
<h2 class="inboundtext1" style="position:absolute;top:10px;left:50px;">입고리스트</h2>	
	<table class="list_table">
		<thead>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>색상</th>
			<th>사이즈</th>
			<th>가격</th>
			<th>품목</th>
			<th>입고량</th>
			<th>입고날짜</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.inid }</td>
				<td>${vo.inname }</td>
				<td>${vo.incolor }</td>
				<td>${vo.insize }</td>
				<td>${vo.inprice }</td>
				<td>${vo.incategory }</td>
				<td>${vo.inamount }</td>
				<td>${vo.indate }</td>
				<td><a href="<%=request.getContextPath()%>/admin/inbound/delete?inid=${vo.inid}">삭제</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
<div class="page">
	<c:if test="${startPageNum>10 }">
		<a href="${cp}/admin/inbound/list?pageNum=${startPageNum -1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/admin/inbound/list?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:red">${i }</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/inbound/list?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:blue">${i }</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/admin/inbound/list?pageNum=${endPageNum+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>
</div>
<div style="position:absolute; top:110px;left:1250px; font-size: 1.2rem;">
	<form method="post" action="${cp }/admin/inbound/list">
		<select name="field">
			<option value="inname" <c:if test="${field=='inname' }">selected="selected"</c:if>>상품명</option>
			<option value="inname" <c:if test="${field=='incategory' }">selected="selected"</c:if>>품목</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>
<form name="frm" method="post">
<input class="btn btn-outline-dark" type="button" value="등록" onclick="valuesend()" style="position:absolute;top:465px;left:1540px;width:50px;height:25px;font-size: 1.2rem;">
<!-- 수정 취소 <input class="btn btn-outline-dark" type="button" value="수정" onclick="valuesend1()" style="position:absolute;top:465px;left:1420px;width:50px;height:25px;font-size: 1.2rem;"> -->
</form>
<div id="barchart_values" style="position:absolute; width: 600px; height: 400px; top:500px; left:100px;"></div>


<div class="boardcss_list_table1">
<h2 class="inboundtext1" style="position:absolute;top:10px;left:50px;">카테고리별 한달 입고상황</h2>
<table class="list_table1">
		<thead>
		<tr>
			<th>품목</th>
			<th>총입고량</th>
			<th>총금액</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list1 }">
			<tr>
				<td>${vo.incategory }</td>
				<td>${vo.inamount }</td>
				<td>${vo.inprice }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
function valuesend(){
 window.open("", "value", "width=750, height=650, left=650, top=140, scrollbars=1, menubar=1, resizable=1"); 
	 document.frm.target ="value";     
	 document.frm.action="<%=request.getContextPath()%>/admin/admin_content/item/inboundinsert.jsp";
 	 document.frm.submit();
}
function valuesend1(){
	 window.open("", "value", "width=750, height=650, left=650, top=140, scrollbars=1, menubar=1, resizable=1"); 
		 document.frm.target ="value";     
		 document.frm.action="<%=request.getContextPath()%>/admin/admin_content/item/inboundupdate.jsp";
	 	 document.frm.submit();
}

	google.charts.load("current", {packages:["corechart"]});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let comm=xml.getElementsByTagName("comm");
				var sname=new Array();
				var samount=new Array();
				for(let i=0;i<comm.length;i++){
					sname[i]=comm[i].getElementsByTagName("sname")[0].textContent;
					samount[i]=comm[i].getElementsByTagName("samount")[0].textContent;
				}
				var data = google.visualization.arrayToDataTable([
				 	   ["Element", "Density", { role: "style" } ],
				 	   [sname[0], Number(samount[0]), "#b87333"],
				 	   [sname[1], Number(samount[1]), "silver"],
				 	   [sname[2], Number(samount[2]), "gold"],
				 	   [sname[3], Number(samount[3]), "red"],
				 	   [sname[4], Number(samount[4]), "blue"],
					  ]);
				var view = new google.visualization.DataView(data);
			 	 view.setColumns([0, 1,
			                   { calc: "stringify",
			                     sourceColumn: 1,
			                     type: "string",
			                     role: "annotation" },
			                   2]);

			 	 var options = {
			 	   title: "50개 미만 제품",
			   	 bar: {groupWidth: "95%"},
			   	 legend: { position: "none" },
			 	 };
			 	var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
			 	 chart.draw(view, options);
			}		
		};
		xhr.open('get','${pageContext.request.contextPath}/admin/inbound/chart.do',true);
  		xhr.send();
	}
</script>