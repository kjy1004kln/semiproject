<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%
	request.setCharacterEncoding("utf-8");
	String sname=request.getParameter("sname");
	String ordate=request.getParameter("ordate");
	//int orid=Integer.parseInt(request.getParameter("orid"));
		System.out.println(sname);
	String odcolor=request.getParameter("odcolor");
	String odsize=request.getParameter("odsize");
	String odcount=request.getParameter("odcount");
	String pimage2=request.getParameter("pimage2");
	String odid=request.getParameter("odid");
	String sid=request.getParameter("sid");
	String id=(String)session.getAttribute("id");
%>

<div class="header" style="position: absolute; left:0px;top:0; width:100%;height:80px; overflow:hidden; background:#CA3C38; z-index:10;">
<h3 style="position: absolute; left:250px; width:170px; line-height:35px; color:white;">review</h3>
</div>

<div class="content">
<form method="post" action="${cp }/user/review" enctype="multipart/form-data">
<div class="top" style="position: absolute; border-top: 1px solid #ABABAB; border-bottom:1px solid #ABABAB;  top:80px;left:0px;width:100%; height:300px;">
<div style="border: 1px solid #ABABAB; position:absolute; top:50px; left:100px; width:100px; height:100px; "><img src = "${cp }/img/<%=pimage2%>" style="width:100px; height:100px;"></div>
<label style="position:absolute; top:50px; left:230px; width:200px; height:25px;">상품명 :</label>
<div style="border: 1px solid #ABABAB; position:absolute; top:50px; left:300px; width:250px; height:25px; "><%=sname %></div>
<label style="position:absolute; top:75px; left:230px; width:200px; height:25px;">사이즈 :</label>
<div style="border: 1px solid #ABABAB; position:absolute; top:75px; left:300px; width:150px; height:25px; "><%=odsize %></div>
<label style="position:absolute; top:100px; left:230px; width:200px; height:25px;">색상 :</label>
<div style="border: 1px solid #ABABAB; position:absolute; top:100px; left:300px; width:150px; height:25px; "><%=odcolor %></div>
<label style="position:absolute; top:125px; left:230px; width:200px; height:25px;">구매날짜 :</label>
<div style="border: 1px solid #ABABAB; position:absolute; top:125px; left:300px; width:150px; height:25px; "><%=ordate %></div>
<div style="border: 1px solid #ABABAB; position:absolute; top:200px; left:120px; width:80px; height:25px; "><%=id %></div>
<label style="position:absolute; top:200px; left:210px; width:200px; height:25px;">고객님 상품은 어떠셨나요?</label>
<label style="position:absolute; top:240px; left:130px; width:280px; height:25px;">리뷰를 작성하고 적립금을 받으세요!</label>
<input type="hidden" name="odid" value="<%=odid %>">
<input type="hidden" name="sid" value="<%=sid %>">
</div>
<div class="center" style="position: absolute; border-bottom:1px solid #ABABAB;  top:380px;left:0px;width:100%; height:300px;">
<label style="position:absolute; top:40px; left:50px;">리뷰 제목</label>
<input type="text" name="rtitle" style="position:absolute; top:70px; left:50px; width:450px;height:30px;">
<label style="position:absolute; top:120px; left:50px;">리뷰 작성란</label>
<input type="text" name="rcontent" style="position:absolute; top:150px; left:50px; width:450px;height:100px;">
</div>
<div class="bottom" style="position: absolute; border-bottom:1px solid #ABABAB;  top:680px;left:0px;width:100%; height:500px;">
<label class="input-file-button" for="upload" style="position:absolute;left:210px; top:50px;  padding: 6px 25px;background-color:#FF6600;border-radius: 4px;color: white;cursor: pointer;">
  사진추가
</label>
<input type="file" name="fupload" id="upload" style="display:none;"/>
<div id="large_img1" class="border border-success" style=" position: absolute; border:1px solid #ABABAB;top:100px; left:120px; width:300px;height:300px;"></div>
<button type="submit" class="btn btn-danger" style="position: absolute; left:0px;bottom:0; width:100%;height:50px; overflow:hidden;z-index:10;">리뷰남기고 적립금 받기</button>
</div>
</form>
</div>

<style>

#large_img1 img{
	width:300px;
	height:300px;
}
.content{
	width: 100%;
	height: 100%;
	position: absolute;
	overflow-y:scroll;
}

html { overflow: hidden; }

</style>
<script type="text/javascript">
	var upload1=document.querySelector("upload");
	var large_img1=document.querySelector("#large_img1");
	upload.addEventListener('change',function(e){
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
</script>
</html>