<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<div style="background:#086701; width:100%;height:100%;">
<div style="position:absolute; background:white; top:10px;left:10px;width:725px;height:625px;">
<img src="<%=request.getContextPath()%>/admin/img/j4.png" style="position:absolute; top:50px; left:300px;">
 <form class="well form-horizontal">
	<fieldset>
	<div class="control-group">
     	<label style="position:absolute;top:275px;left:50px;">번호입력</label>
     	<div class="controls">
     		<input id="input_inid" type="text" style="position:absolute;top:270px;left:150px; width:100px;">
     	</div>
     </div>
     <button id="joinbtn" class="btn btn-outline-dark" type="button" style="position:absolute;top:270px;left:250px;height:30px;line-height:15px;">조회</button>
     <div class="control-group">
     	<label style="position:absolute;top:335px;left:50px;">NAME</label>
     	<div class="controls">
     		<input id="input_inname" type="text" style="position:absolute;top:330px;left:150px; width:460px;">
     	</div>
     </div>
      <div class="control-group">
     	<label style="position:absolute;top:395px;left:50px;">COLOR</label>
     	<div class="controls">
     		<input id="input_incolor" type="text" style="position:absolute;top:390px;left:150px; width:100px;">
     		<select id="selectcolor" onchange="chang_incolor()" style="position:absolute;top:390px;left:250px;height:30px;">
            	<option>RED</option>
                <option>BLUE</option>
                <option>GREEN</option>
                <option>BLOACK</option>
                <option>TEST</option>
            </select>
     	</div>
     </div>
      <div class="control-group">
     	<label style="position:absolute;top:395px;left:380px;">SIZE</label>
     	<div class="controls">
     		<input id="input_insize" type="text" style="position:absolute;top:390px;left:450px; width:100px;">
     		<select id="selectsize" onchange="chang_insize()" style="position:absolute;top:390px;left:550px;height:30px;">
            	<option>S</option>
                <option>M</option>
                <option>L</option>
                <option>XL</option>
                <option>FREE</option>
            </select>
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:455px;left:50px;">CATEGORY</label>
     	<div class="controls">
     		<input id="input_incategory" type="text" style="position:absolute;top:450px;left:150px; width:100px;">
     		<select id="selectcategory" onchange="chang_incategory()" style="position:absolute;top:450px;left:250px;height:30px;">
            	<option>OUTER</option>
                <option>TOP</option>
                <option>OPS</option>
                <option>SKIRTL</option>
                <option>PANTS</option>
            </select>
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:455px;left:380px;">입고일</label>
     	<div class="controls">
     		<input id="input_indate" type="date" style="position:absolute;top:450px;left:450px; width:160px;">
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:515px;left:50px;">PRICE</label>
     	<div class="controls">
     		<input id="input_inprice" type="text" style="position:absolute;top:510px;left:150px; width:170px;">
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:515px;left:380px;">입고량</label>
     	<div class="controls">
     		<input id="input_inamount" type="text" style="position:absolute;top:510px;left:450px; width:160px;">
     	</div>
     </div>
     <div class="form-actions">
     	<button id="updatebtn" class="btn btn-outline-dark" type="submit" style="position:absolute;top:580px;left:290px;">수정</button>
     	<button  onclick="self.close();" class="btn btn-outline-dark" type="button" style="position:absolute;top:580px;left:380px;">취소</button>
     </div>
	 </fieldset>
   </form>
 </div>
</div>
<script type="text/javascript">
	function chang_incategory(){
		var select=document.getElementById("selectcategory");
		document.getElementById("input_incategory").value=select.options[select.selectedIndex].text;
	}
	function chang_incolor(){
		var select=document.getElementById("selectcolor");
		document.getElementById("input_incolor").value=select.options[select.selectedIndex].text;
	}
	function chang_insize(){
		var select=document.getElementById("selectsize");
		document.getElementById("input_insize").value=select.options[select.selectedIndex].text;
	}	
	

	function moveClose() {
	  opener.location.href="<%=request.getContextPath()%>/admin/inbound/list";
	  self.close();
	}
	updatebtn=document.getElementById("updatebtn");
	updatebtn.addEventListener('click',function(e){
		const inid=document.getElementById("input_inid").value;
		const inname=document.getElementById("input_inname").value;
		const incolor=document.getElementById("input_incolor").value;
		const insize=document.getElementById("input_insize").value;
		const incategory=document.getElementById("input_incategory").value;
		const indate=document.getElementById("input_indate").value;
		const inprice=document.getElementById("input_inprice").value;
		const inamount=document.getElementById("input_inamount").value;
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
			}
		};
		xhr.open('post','${pageContext.request.contextPath}/admin/inbound/upload',true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		let params="inname="+inname+"&incolor="+incolor+"&insize="+insize+"&incategory="+incategory+"&indate="+indate+"&inprice="+inprice+"&inamount="+inamount+"&inid="+inid;
		xhr.send(params);
		opener.parent.location="<%=request.getContextPath()%>/admin/inbound/list";
		window.close();
	});
	
	joinbtn=document.getElementById("joinbtn");
	joinbtn.addEventListener('click',function(e){
		const inid=document.getElementById("input_inid").value;
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				let xml=xhr.responseXML;
				let comm=xml.getElementsByTagName("comm");
				document.getElementById("input_inname").value=comm[0].getElementsByTagName("inname")[0].textContent;
				document.getElementById("input_incolor").value=comm[0].getElementsByTagName("incolor")[0].textContent;
				document.getElementById("input_insize").value=comm[0].getElementsByTagName("insize")[0].textContent;
				document.getElementById("input_incategory").value=comm[0].getElementsByTagName("incategory")[0].textContent;
				document.getElementById("input_indate").value=comm[0].getElementsByTagName("indate")[0].textContent;
				document.getElementById("input_inprice").value=comm[0].getElementsByTagName("inprice")[0].textContent;
				document.getElementById("input_inamount").value=comm[0].getElementsByTagName("inamount")[0].textContent;
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/admin/inbound/select?inid='+inid,true);
		xhr.send();
	});
</script>