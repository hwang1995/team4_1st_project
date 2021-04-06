const quantityElem = $('.item_details_quantity_status');

let initQuantity = 1; // 초기의 수량은 1이 되야 한다.
let numRegExp = /^[0-9]*$/
/**
 * 1. 수량 -, +를 DOM에 갱신하기
 * =================================================
 * 1. 수량에 있는 마이너스 버튼을 누를시에 작동하는 jQuery 메서드
 * $('.item_details_minus').click(() => {})
 * 
 * 2. 수량에 있는 플러스 버튼을 누를시에 작동하는 jQuery 메서드
 * $('.item_details_plus').click(()=> {});
 */

 $('.item_details_minus').click(() => {

    // 수량을 -1 한다.
    initQuantity -= 1;

    // 만약 수량이 1 이하 (0) 이 된다면, 초기 수량을 1로 변경한다.
    if(initQuantity < 1){
        initQuantity = 1;
    }

    // item_details_quantity_status의 'value' 속성에 initQuantity를 넣는다.
    quantityElem.attr('value', initQuantity)

    // jQuery에 속성이 변경되었다고 알려준다.
    quantityElem.change();
});

$('.item_details_plus').click(() => {
    // 수량을 +1 한다.
    initQuantity += 1;

    // item_details_quantity_status의 'value' 속성에 initQuantity를 넣는다.
    quantityElem.attr('value', initQuantity);

    // jQuery에 속성이 변경되었다고 알려준다.
    quantityElem.change();
});

/**
 * ADD TO CART, BUY NOW 버튼을 클릭 시 
 * 장바구니 페이지와 구매 페이지로 넘어가는 DOM Event 
 */



const goCartPage = () => {
// elements 의 값을 가져온다.
	const productIdInfo = location.href.split("/");
	const colorElem = $('#color_select').val();
	const sizeElem = $('#size_select').val();
	const quantityElem = $('.item_details_quantity_status').val();
	
	// Object를 만들어준다.
	let buyInfoObj = {
		"product_id" : productIdInfo[productIdInfo.length - 1],
		"product_color" : colorElem,
		"product_size" : sizeElem,
		"product_quantity" : quantityElem,
	};
	
	// 유효성 검사 로직을 넣는다.
	if(!colorElem){
		alert("색상을 선택해주세요.");
		return;
	} else if(!sizeElem){
		alert('사이즈를 선택해주세요.');
		return;
	} else if(quantityElem < 1){
		alert("0이상의 숫자를 입력해주세요.");
		return;
	} else if(!numRegExp.test(quantityElem)){
		alert("숫자만을 입력해주세요.");
		return;
	}
	
	$.ajax({
		url : "/webapp/order/cart",
		data : buyInfoObj,
		method : "post",
	}).
	then((data) => {
		if(data.status == "success"){
			window.location.href = "/webapp/order/cart";
		} else {
			window.location.href= "/webapp/auth/login";
		}
		
	});

}

const goBuyPage = () => {
	// elements 의 값을 가져온다.
	const productIdInfo = location.href.split("/");
	const colorElem = $('#color_select').val();
	const sizeElem = $('#size_select').val();
	const quantityElem = $('.item_details_quantity_status').val();
	
	// Object를 만들어준다.
	let buyInfoObj = {
		"product_id" : productIdInfo[productIdInfo.length - 1],
		"product_color" : colorElem,
		"product_size" : sizeElem,
		"product_quantity" : quantityElem,
	};
	
	// 유효성 검사 로직을 넣는다.
	if(!colorElem){
		alert("색상을 선택해주세요.");
		return;
	} else if(!sizeElem){
		alert('사이즈를 선택해주세요.');
		return;
	} else if(quantityElem < 1){
		alert("0이상의 숫자를 입력해주세요.");
		return;
	}  else if(!numRegExp.test(quantityElem)){
		alert("숫자만을 입력해주세요.");
		return;
	}
	
	$.ajax({
		url : "/webapp/order/preorder",
		data : buyInfoObj,
		method : "post",
	}).
	then((data) => {
		if(data.status == "success"){
			window.location.href = "/webapp/order/checkout";
		} else {
			window.location.href= "/webapp/auth/login";
		}
		
	});


}

