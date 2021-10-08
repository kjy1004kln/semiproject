<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
body{
	margin-top: 100px;
	font-family: 'Trebuchet MS', serif;
	line-height: 1.6
}
.container{
	width: 500px;
	margin: 0 auto;
}



ul.tabs{
	margin: 0px;
	padding: 0px;
	list-style: none;
}
ul.tabs li{
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

ul.tabs li.current{
	background: #ededed;
	color: #222;
}

.tab-content{
	display: none;
	background: #ededed;
	padding: 15px;
}

.tab-content.current{
	display: inherit;
}
</style>

<table class="table">
	<tr class="active">
		<td><h4>point</h4></td>
		<td>고객님의 사용가능 적립금 금액 입니다.</td>
	</tr>
</table>

<table class="table">
	<tr class="active">
		<td>>총 적립금</td>
		<td>원</td>
		<td>>사용가능 적립금</td>
		<td>원</td>
	</tr>
	<tr class="active">
		<td>>사용된 적립금</td>
		<td>원 </td>
		<td>>미가용 적립금</td>
		<td>원</td>
	</tr>
	<tr class="active">
		<td>>환불예정 적립금</td>
		<td> 원 </td>
	</tr>
</table>

<div class="box1">
	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">적립내역보기</li>
		<li class="tab-link" data-tab="tab-2">미가용적립내역보기</li>
		<li class="tab-link" data-tab="tab-3">미가용쿠폰/회원등급적립내역</li>
	</ul>
	<div id="tab-1" class="tab-content current"></div>
	<div id="tab-2" class="tab-content"></div>
	<div id="tab-3" class="tab-content"></div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
		var tab_id=$(this).attr('data-tab');
		
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		
		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})
})
</script>

<h4>적립금 안내</h4>
<ol>
	<li>주문으로 발생한 적립금은 배송완료 후 14일 부터 실제 사용 가능한 적립금으로 전환됩니다. 배송완료 시점으로부터 14일 동안은 미가용 적립금으로 분류됩니다.</li>
	<li>미가용 적립금은 반품, 구매취소 등을 대비한 임시 적립금으로 사용가능 적립금으로 전환되기까지 상품구매에 사용하실 수 없습니다.</li>
	<li>사용가능 적립금(총적립금 - 사용된적립금 - 미가용적립금)은 상품구매 시 바로 사용가능합니다.</li>
</ol>