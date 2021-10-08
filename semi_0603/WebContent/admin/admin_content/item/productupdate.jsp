<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/admin/css/productinsert.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<%
	String pid=request.getParameter("pid");
%>

<div style="background:#086701; width:100%;height:100%;">
<div style="position:absolute; background:white; top:10px;left:10px;width:980px;height:950px;">
<img src="<%=request.getContextPath()%>/admin/img/j4.png" style="position:absolute; top:50px; left:400px;">
 <form class="well form-horizontal" enctype="multipart/form-data" action="<%=request.getContextPath()%>/admin/product/update" method="post" id="test_form" >
	<fieldset>
	 <div class="border border-success" style="position: absolute; top:250px; left:50px; width:875px;height:40px;">
	 <div class="control-group">
     	<label style="position:absolute;top:8px;left:10px;">등록번호</label>
     	<div class="controls">
     		<input id="input_sid" name="pid" type="text" value="<%=pid %>" style="position:absolute;top:5px;left:80px; width:50px; text-align:center; readonly">
     	</div>
      </div>
      <div class="control-group">
     	<label style="position:absolute;top:8px;left:300px;">할인율</label>
     	<div class="controls">
     		<input id="input_discount" name="pdiscount" type="text" style="position:absolute;top:5px;left:350px; width:50px; text-align:center;">
     		<select id="selectdiscount" onchange="chang_discount()" style="position:absolute;top:5px;left:400px;height:30px;">
            	<option>5</option>
                <option>10</option>
                <option>15</option>
                <option>20</option>
            </select>
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:8px;left:600px;">가격</label>
     	<div class="controls">
     		<input id="input_inprice" name="pprice" type="text" style="position:absolute;top:5px;;left:650px; width:170px;">
     	</div>
     </div>
     </div>
      <div class="control-group">
     	<label style="position:absolute;top:300px;left:50px;">대표이미지</label>
     	<input type="file"  name="pimage1" id="upload1" style="display: none;">
     	<label for="upload1" style="padding: 6px 25px;background-color:#FF6600;border-radius: 4px;color: white;cursor: pointer; position:absolute;top:295px;left:150px;width:100px;height:30px;line-height:20px;">업로드</label>
     	<div class="controls">
     		<div id="large_img1" class="border border-success" style="position: absolute; top:330px; left:50px; width:400px;height:500px;">
     		</div>
     	</div>
     </div>
     <div class="control-group">
     	<label style="position:absolute;top:300px;left:530px;">추가이미지</label>
     	<input type="file"  name="pimage2" id="upload2" style="display: none;">
     	<label for="upload2" style="padding: 6px 25px;background-color:#FF6600;border-radius: 4px;color: white;cursor: pointer; position:absolute;top:295px;left:630px;width:100px;height:30px;line-height:20px;">업로드</label>
     	<div class="controls">
     		<div id="large_img2" class="border border-success" style="position: absolute; top:330px; left:530px; width:400px;height:500px;"></div>
     	</div>
     </div>
     
     <div class="form-actions">
     	<button id="insertbtn" class="btn btn-outline-dark" type="submit" style="position:absolute;top:880px;left:360px;">등록</button>
     	<button  onclick="self.close();" class="btn btn-outline-dark" type="button" style="position:absolute;top:880px;left:540px;">취소</button>
     </div>
	 </fieldset>
   </form>
 </div>
</div>
<style>
#large_img1 img{
	width:398px;
	height:498px;
	position: absolute;
	top:0px; 
	left:0px;
}

#large_img2 img{
	width:398px;
	height:498px;
	position:absolute;
	top:0px; 
	left:0px;
}
</style>
<script type="text/javascript">
	var upload1=document.querySelector("#upload1");
	var upload2=document.querySelector("#upload2");
	var large_img1=document.querySelector("#large_img1");
	var large_img2=document.querySelector("#large_img2");
	upload1.addEventListener('change',function (e) {
        var get_file = e.target.files;
        var image = document.createElement('img');
        var reader = new FileReader();
        reader.onload = (function (aImg) {
            return function (e) {
                aImg.src = e.target.result
            }
        })(image)
        if(get_file){
            reader.readAsDataURL(get_file[0]);
        }
        large_img1.appendChild(image);
    })
    upload2.addEventListener('change',function (e) {
        var get_file = e.target.files;
        var image = document.createElement('img');
        var reader = new FileReader();
        reader.onload = (function (aImg) {
            return function (e) {
                aImg.src = e.target.result
            }
        })(image)
        if(get_file){
            reader.readAsDataURL(get_file[0]);
        }
        large_img2.appendChild(image);
    })
	
	
	
	function chang_discount(){
		var select=document.getElementById("selectdiscount");
		document.getElementById("input_discount").value=select.options[select.selectedIndex].text;
	}

	function moveClose() {
	  opener.location.href="<%=request.getContextPath()%>/admin/inbound/list";
	  self.close();
	}
	
	var upload1=document.getElementById("upload1");
	var upload2=document.getElementById("upload2");
	var form = document.getElementById("test_form");
	var xhr=new XMLHttpRequest();
	form.onsubmit = function(e)
	{
		e.preventDefault();
	   var formData = new FormData(form);
	   formData.append('upload_file' , upload1);
	    xhr.open("POST" , form.getAttribute("action") , true);
	    xhr.send(formData);
	    setTimeout(function() {
	    	opener.location.reload();
	    	 window.close();
	    }, 1000);
	}
</script>