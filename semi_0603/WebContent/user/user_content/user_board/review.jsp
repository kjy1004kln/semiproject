<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath }/review">
상품은 만족하셨나요?<br>
별<br>
상품 리뷰<br>
<textarea rows="10" cols="100" placeholder="10자이상 입력해주세요"></textarea>
<br>사진 첨부하기<br>
<input type="file" name="file1" ><br>
<input type="button" value="취소">
<input type="submit" value="등록">
</form>