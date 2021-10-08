<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>fnq.jsp</title>
<style>
		#list{
		position:absolute;
		top:150px;
		left:150px;
		width:1500px;
	}
	#insert{
		position: absolute;
		top:100px;
		left:1500px;
	}
	#ftitle:hover{
		border: none;
    	outline:none;
    	background-color:white;
    	color: #4374D9;
	}
	#ftitle1:hover{
		border: none;
    	outline:none;
    	background-color:white;
    	color: #4374D9;
	}
</style>
</head>
<body>
<%
	String id=(String)session.getAttribute("id");
%>
<div id="insert">
<a href="<%=request.getContextPath()%>/admin/admin_content/board/noticeinsert.jsp" 
			onclick="window.open(this.href,'','width=500, height=500, toolbars=no, scrollbars=yes'); return false;">
			<input type="button" value="�۾���"></a>
</div>	
<div id="list">
	
	<table class="table">
		<colgroup>
			<col width="5%"/>
			<col width="10%"/>
			<col width="5%"/>
			<col width="5%"/>
			<col width="5%"/>
			<col width="5%"/>
			<col width="5%"/>
		</colgroup>
		<tr>
			<th colspan="8">�������̺�</th>
		</tr>
		<tr>
			<th>�ۼ���</th>
			<th>����</th>
			<th>��������</th>
			<th>�ۼ���¥</th>			
			<th>��ȣ</th>			
			<th>����</th>			
			<th>����</th>			
		</tr>
	<c:forEach var="vo" items="${list }">
	<input type="hidden" id="fid" value="${vo.fid }">
	<c:choose>
		<c:when test="${vo.fpublic_private==1 }">
		<tr>
			<td>${vo.aid }</td>
			<td><input type="button" value="${vo.ftitle }" id="ftitle" onclick="showMsg(${vo.fid })" 
			style="border: none;outline:none;background-color:white;"></td>
			<td>����</td>
			<td>${vo.frdate }</td>
			<td>${vo.fid }</td>
			<td><a href="<%=request.getContextPath()%>/admin/noticepopup?fid=${vo.fid }"
			 onclick="window.open(this.href,'����','width=500, height=500, toolbars=no, scrollbars=yes'); return false;">����</a></td>	
			<td><a href="<%=request.getContextPath()%>/admin/notice/delete?fid=${vo.fid }">����</a></td>
		</tr>
		</c:when>
		</c:choose>
	</c:forEach>
	</table>
	<div id="fcontentdiv"></div>
	
	<c:if test="${startPageNum>10 }">
		<a href="${cp }/admin/notice/list?pageNum=${startPageNum-1 }">[����]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }"><%--�����������ΰ�� --%>
				<a href="${cp }/admin/notice/list?pageNum=${i }"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/notice/list?pageNum=${i }"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/admin/notice/list?pageNum=${endPageNum+1 }">[����]</a>
	</c:if>
	<form method="post" action="${cp }/admin/notice/list">
		<select name="field">
			<option value="ftitle">����</option>
			<option value="fcontent">����</option>
		</select>
		<input type="text" name="keyword">
	<input type="button" value="�˻�">
	</form>	<br>

	<table class="table">
		<tr>
			<th colspan="8">��������̺�</th>
		</tr>
		<tr>
			<th>�ۼ���</th>
			<th>����</th>
			<th>��������</th>
			<th>�ۼ���¥</th>			
			<th>��ȣ</th>			
			<th>����</th>			
			<th>����</th>			
		</tr>
	<c:forEach var="vo" items="${list1 }">
	<input type="hidden" id="fid1" value="${vo.fid }">
	<c:choose>
		<c:when test="${vo.fpublic_private==0 }">
		<tr>
			<td>${vo.aid }</td>
			<td><input type="button" value="${vo.ftitle }" id="ftitle1" onclick="showMsg1(${vo.fid })"style="border: none;outline:none;background-color:white;"></td>
			<td>�����</td>
			<td>${vo.frdate }</td>
			<td>${vo.fid }</td>
			<td><a href="<%=request.getContextPath()%>/admin/noticepopup?fid=${vo.fid }"
			 onclick="window.open(this.href,'����','width=500, height=500, toolbars=no, scrollbars=yes'); return false;">����</a></td>	
			<td><a href="<%=request.getContextPath()%>/admin/notice/delete?fid=${vo.fid }">����</a></td>
		</tr>
		</c:when>
		</c:choose>
	</c:forEach>
	</table>
	<div id="fcontentdiv1"></div>
	
	<c:if test="${startPageNum1>10 }">
		<a href="${cp }/admin/notice/list1?pageNum1=${startPageNum1-1 }">[����]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum1 }" end="${endPageNum1 }">
		<c:choose>
			<c:when test="${pageNum1==i }"><%--�����������ΰ�� --%>
				<a href="${cp }/admin/notice/list?pageNum1=${i }"><span style="color:blue">[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/notice/list?pageNum1=${i }"><span style="color:gray">[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum1<pageCount1 }">
		<a href="${cp }/admin/notice/list?pageNum1=${endPageNum1+1 }">[����]</a>
	</c:if>	
	<form method="post" action="${cp }/admin/notice/list">
		<select name="field1">
			<option value="ftitle1">����</option>
			<option value="fcontent1">����</option>
		</select>
		<input type="text" name="keyword1">
	<input type="button" value="�˻�">
	</form>
</div>
<script type="text/javascript">
let ftitle=document.getElementById("ftitle");
function showMsg(fid){
	console.log(fid)
	const fcontentdiv=document.getElementById("fcontentdiv");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let result=xhr.responseText;
			let json=JSON.parse(result);
			if(json.ffile!="/noticeimage/null"){
				let test=json.ffile;
				console.log(test);
				let ffile='<%=request.getContextPath()%>'+json.ffile;
				fcontentdiv.innerHTML='<img src="' + ffile + '" />';
			}else if(json.fcontent!=null){
				fcontentdiv.innerHTML=json.fcontent;
			}else{
				fcontentdiv.innerHTML="��������!";
			}
			
		}
	};
	xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/board/noticecontent.jsp?fid='+fid, true);
	xhr.send();
};
<%-- ftitle.onclick=function(e){
	const fid=document.getElementById("fid").value;
	console.log(fid)
	const fcontentdiv=document.getElementById("fcontentdiv");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let result=xhr.responseText;
			let json=JSON.parse(result);
			if(json.ffile!=null){
				let ffile='<%=request.getContextPath()%>'+json.ffile;
				console.log(ffile);
				fcontentdiv.innerHTML='<img src="' + ffile + '" />';
			}else if(json.fcontent!=null){
				fcontentdiv.innerHTML=json.fcontent;
			}else{
				fcontentdiv.innerHTML="��������!";
			}
			
		}
	};
	xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/board/noticecontent.jsp?fid='+fid, true);
	xhr.send();
 };
 --%>
 function showMsg1(fid){
 	console.log(fid)
 	const fcontentdiv=document.getElementById("fcontentdiv1");
 	let xhr=new XMLHttpRequest();
 	xhr.onreadystatechange=function(){
 		if(xhr.readyState==4 && xhr.status==200){
 			let result=xhr.responseText;
 			let json=JSON.parse(result);
 			if(json.ffile!="/noticeimage/null"){
 				let test=json.ffile;
 				console.log(test);
 				let ffile='<%=request.getContextPath()%>'+json.ffile;
 				fcontentdiv.innerHTML='<img src="' + ffile + '" />';
 			}else if(json.fcontent!=null){
 				fcontentdiv.innerHTML=json.fcontent;
 			}else{
 				fcontentdiv.innerHTML="��������!";
 			}
 			
 		}
 	};
 	xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/board/noticecontent.jsp?fid='+fid, true);
 	xhr.send();
 };
 
<%--let ftitle1=document.getElementById("ftitle1");
ftitle1.onclick=function(e){
	const fid1=document.getElementById("fid1").value;
	console.log(fid1)
	const fcontentdiv=document.getElementById("fcontentdiv1");
	let xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			let result=xhr.responseText;
			let json=JSON.parse(result);
			if(json.ffile!=null){
				let ffile='<%=request.getContextPath()%>'+json.ffile;
				console.log(ffile);
				fcontentdiv.innerHTML='<img src="' + ffile + '" />';
			}else if(json.fcontent!=null){
				fcontentdiv.innerHTML=json.fcontent;
			}else{
				fcontentdiv.innerHTML="��������!";
			}
			
		}
	};
	xhr.open('get','<%=request.getContextPath()%>/admin/admin_content/board/noticecontent.jsp?fid='+fid1, true);
	xhr.send();
};--%>
</script>
</body>
</html>