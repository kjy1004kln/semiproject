<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<label style="position:relative; top:40px;left:0px;font-size:15px; font-family: Geogia;">new</label>
<div class="category" style="position:relative; top:50px;left:0px;height:4500px;width:1200px; border-top:1px solid black; border-bottom:1px solid black;">
	<div style="position: absolute;top:200px;left:0px;height:600px;width:1200px;">
		<c:forEach var="vo" items="${list1 }">
			 <div class="col-lg-3">
			    <div class="thumbnail">
			      	<a href="${cp }/user/productDetail?pid=${vo.pid}"><img src="${pageContext.request.contextPath }/img/${vo.pimage2 }" alt="${name }img"></a>
			      	<div class="caption">
				        <h3 style="font-size:15px;text-align:left;font-family: Geogia;"><a href="${cp }/user/productDetail?pid=${vo.pid}">상품이름: ${vo.sname }</a></h3>
				        <h3 style="font-size:15px;text-align:left;font-family: Geogia;">상품아이디: ${vo.pid }</h3>
				        <h3 style="font-size:15px;text-align:left;font-family: Geogia;">상품가격: ${vo.pprice }</h3>
		      		</div>
		    	</div>
	  		</div>
		</c:forEach>
	</div>
</div>



<script>
</script>