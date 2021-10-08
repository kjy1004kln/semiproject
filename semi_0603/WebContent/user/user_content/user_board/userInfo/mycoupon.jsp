<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>my coupon</h4>

<h4>마이 쿠폰 목록</h4>
<table class="table">
	<tr class="active">
		<th>번호</th>
		<th>쿠폰명</th>
		<th>쿠폰적용 상품</th>
		<th>구매금액</th>
		<th>결제수단</th>
		<th>쿠폰 혜택</th>
		<th>사용가능 기간</th>
	</tr>
	<tr class="active">
		<td colspan="7" align="center">보유하고 계신 쿠폰 내역이 없습니다</td>
	</tr>
</table>

<h4>쿠폰인증번호 등록하기</h4>
<div style="background-color:#F6F6F6">
<input type="text" id="couponnum" style="text-align=center; padding-top:5px;">
<input type="button" value="쿠폰번호인증" onclick="insertCoupon"><br>
반드시 쇼핑몰에서 발행한 쿠폰번호만 입력해주세요. (10~35자 일련번호 "-" 제외)
</div>

<script type="text/javascript">
	function insertCoupon(){
		
	}
</script>
<h4>쿠폰 이용 안내</h4>
<ol>
	<li>쿠폰인증번호 등록하기에서 쇼핑몰에서 발행한 종이쿠폰/시리얼쿠폰/모바일쿠폰 등의 인증번호를 등록하시면 온라인쿠폰으로 발급되어 사용이 가능합니다.</li>
	<li>쿠폰은 주문 시 1회에 한해 적용되며, 1회 사용 시 재 사용이 불가능합니다.</li>
	<li>쿠폰은 적용 가능한 상품이 따로 적용되어 있는 경우 해당 상품 구매 시에만 사용이 가능합니다.</li>
	<li>특정한 종이쿠폰/시리얼쿠폰/모바일쿠폰의 경우 단 1회만 사용이 가능할 수 있습니다.</li>
</ol>