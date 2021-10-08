<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>new</h4>
<div class="row">
	<c:forEach var= "name" items="${nameList }" begin="1" end="1">
		<c:forEach var="vo" items="${list }">
			 <div class="col-lg-3">
			    <div class="thumbnail">
			      	<a href="${cp }/user/productDetail?pid=${vo.pid}"><img src="${cp }${vo.pimage2 }" alt="${name }img"></a>
			      	<div class="caption">
				        <h3><a href="${cp }/user/productDetail?pid=${vo.pid}">${name }</a></h3>
				        <h3>상품아이디: ${vo.pid }</h3>
				        <h3>상품가격: ${vo.pprice }</h3>
				        <h3>할인율: ${vo.pdiscount }</h3>
		      		</div>
		    	</div>
	  		</div>
		</c:forEach>
	</c:forEach>
</div>