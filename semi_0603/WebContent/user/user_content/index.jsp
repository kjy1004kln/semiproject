<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

   
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<div class="container">
	<div id = "top" class="row">
		<jsp:include page="${top }"/> <!-- requestScope.top인데 생략 -->
	</div>
	<div id = "content" class="row" style="margin-top:50px">
		<jsp:include page="${content }"/>
	</div>
	<div id = "bottom" class="row" style="margin-top:50px">
		<jsp:include page="${bottom }"/>
	</div>
</div>
</body>
</html>