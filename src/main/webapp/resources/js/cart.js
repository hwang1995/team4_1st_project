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
			console.log("SUCCEEESSS");
			location.href = "/webapp/order/checkout?isCart=true";
		} else {
			console.log("Failure");
		}
	})
}

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
			console.log("Delete data success");
			location.href = "/webapp/order/cart";
		} else {
			console.log("Failure");
		}
		
	});
}