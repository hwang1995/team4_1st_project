let telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

$('.order_info_black_button').click(
	() => {
		// 초기 설정값 가져오기
		const memberIdElem = $('#member_id').val();
		const recipientNameElem = $('#recipient_name').val();
		const recipientAddressElem = $('#recipient_address').val();
		const recipientTelElem = $('#recipient_tel').val();
		const bankSelectElem = $('#bank_select').val();
		const gdprSelectElem = $('#gdpr_agree').prop('checked');
		const infoSelectElem = $('#info_agree').prop('checked');
		const orderAgreeSelectElem = $('#order_agree').prop('checked');
		
		let orderInfo = {
			"member_id" : memberIdElem,
			"order_bank" : bankSelectElem,
			"recipient_name" : recipientNameElem,
			"recipient_address" : recipientAddressElem,
			"recipient_tel" : recipientTelElem
		};
		
		if(!(recipientNameElem && recipientAddressElem && recipientTelElem)){
			alert("배송 정보를 입력해주세요.");
			return;
		} else if(!bankSelectElem) {
			alert("입금 계좌를 선택해주세요.");
			return;
		} else if(!gdprSelectElem) {
			alert("이용 약관에 동의해주세요.");
			return;
		} else if(!infoSelectElem) {
			alert("개인정보 수집 이용 약관에 동의해주세요.");
			return;
		} else if(!orderAgreeSelectElem) {
			alert("주문 동의를 선택해주세요.");
			return;
		} else if(!telRegExp.test(recipientTelElem)){
			alert("전화번호를 올바르게 입력해주세요.");
			return;
		}
		
		$.ajax({
			url : "/webapp/order/checkout",
			method : "POST",
			data : orderInfo
		}).
		then((data) => {
			if(data.status == "success"){
				console.log("Insert Data success");
				location.href = "/webapp/order/checked";
			} else {
				console.log("Failure");
			}
		});
		
		
		
		
		
	}
);

$('#ucheckbox').click(
	() => {
		const checkStatus = $('#ucheckbox').prop('checked');
		const memberNameInfo = $('#member_name').val();
		const memberAddressInfo = $('#member_address').val();
		const memberTelInfo = $('#member_tel').val();
		// recipient setting 
		
		
		if(checkStatus){
			$('#recipient_name').val(memberNameInfo);
			$('#recipient_address').val(memberAddressInfo);
			$('#recipient_tel').val(memberTelInfo);
		} else {
			$('#recipient_name').val("");
			$('#recipient_address').val("");
			$('#recipient_tel').val("");
		}
	}
)