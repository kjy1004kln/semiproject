<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>자주묻는질문</h4>
<c:forEach var="vo" items="${list }">
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
<div class="panel panel-default">
    <div class="panel-heading" role="tab">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" 
        href="#${vo.fid }" aria-expanded="false" id = "id\${vo.fid }" aria-controls="${vo.fid }">
         	${vo.ftitle }
        </a>
      </h4>
    </div>
    <div id="${vo.fid }" class="panel-collapse collapse in" role="tabpanel">
      <div class="panel-body">
			${vo.fcontent }
      </div>
    </div>
  </div>
</div>
</c:forEach>
