// 체크아웃 페이지로 가기 위해 회원의 ID를 넘기고 체크아웃 페이지로 넘어감
const goCheckoutPage = () => {
	const memberIDElem = $('#memberID').val();
	const memberInfo = {
		"member_id" : memberIDElem
	};
	
	$.ajax({
		url : "/webapp/order/preorder/cart",
		method : "post",
		data : memberInfo
	})
	.then((data) => {
		if(data.status == "success"){
			location.href = "/webapp/order/checkout?isCart=true";
		} else {
			console.log("Failure");
		}
	})
}


// 장바구니의 각 상품을 제거하기 위해 필요한 함수
const removeCart = (cart_id) => {
	const cartInfo ={
		"cart_id" : cart_id
	}
	
	$.ajax({
		url : "/webapp/order/cart/delete",
		method : "post",
		data : cartInfo
		
	})
	.then((data) => {
		if(data.status == "success"){
			location.href = "/webapp/order/cart";
		} else {
			console.log("Failure");
		}
		
	});
}