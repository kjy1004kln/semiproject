<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
order list
<!-- 주문내역 갯수 count -->
주문내역조회(x개)
<div role="tabpanel">
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">주문내역조회</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">취소/반품/교환내역</a></li>
  </ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
    	<select name = "select">
				<option value="전체 주문리스트">전체 주문리스트</option>
				<option value="배송 준비중">배송 준비중</option>
				<option value="배송중">배송중</option>
				<option value="배송완료">배송완료</option>
				<option value="취소">취소</option>
				<option value="교환">교환</option>
				<option value="반품">반품</option>
		</select>
		<div class="btn-group" data-toggle="buttons">
		  <label class="btn btn-primary active">
		    <input type="radio" name="options" id="option1" autocomplete="off" checked> 오늘
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option2" autocomplete="off"> 1주일
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option3" autocomplete="off"> 1개월
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option4" autocomplete="off"> 3개월
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option5" autocomplete="off"> 6개월
		  </label>
		</div>
		<div>
			<input type="date" >~<input type="date" ><input type="button" value="조회">
		</div>
		<ul>
			<li>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
			<li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
		</ul>
		<h4>상품정보</h4>
		<table class="table">
			<tr class="active">
				<th>주문일자<br>[주문번호]</th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>수량</th>
				<th>상품구매금액</th>
				<th>주문처리상태</th>
				<th>취소/교환/반품<th>
			</tr>
			<tr>
				<td>주문내역이 없습니다.</td>
			</tr>
		</table>
	</div>
	<!-- 페이징처리!!!!!!!!!!!!!!!!!! -->
    <div role="tabpanel" class="tab-pane" id="profile">
	    취소환불교환내역
		<div class="btn-group" data-toggle="buttons">
		  <label class="btn btn-primary active">
		    <input type="radio" name="options" id="option1" autocomplete="off" checked> 오늘
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option2" autocomplete="off"> 1주일
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option3" autocomplete="off"> 1개월
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option4" autocomplete="off"> 3개월
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="options" id="option5" autocomplete="off"> 6개월
		  </label>
		</div>
		<div>
			<input type="date" >~<input type="date" ><input type="button" value="조회">
		</div>
		<ul>
			<li>기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</li>
			<li>주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
		</ul>
		<h4>상품정보</h4>
		<table class="table">
			<tr class="active">
				<th>주문일자<br>[주문번호]</th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>수량</th>
				<th>상품구매금액</th>
				<th>주문처리상태</th>
				<th>취소/교환/반품<th>
			</tr>
			<tr>
				<td>주문내역이 없습니다.</td>
			</tr>
		</table>
	</div>
	<!-- 페이징처리!!!!!!!!!!!!!!!!!! -->
	</div>
</div>
<script>
	$('#myTab a').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show')
	})
</script>