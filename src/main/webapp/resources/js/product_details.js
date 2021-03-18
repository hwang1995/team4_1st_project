/**
 * 이 JS는 상품 상세 페이지의 필요한 
 * 1) 수량 -, +를 DOM에 갱신하기
 * 2) 사용자가 선택한 옵션, 수량을 가져와 
 *    다음 웹 페이지로 넘겨주는 역할을 하게 된다. 
 */

let initQuantity = 1; // 초기의 수량은 1이 되야 한다.

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
    // item_details_quantity_status의 DOM을 가져온다.
    const quantityElem = $('.item_details_quantity_status');

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
    // item_details_quantity_status의 DOM을 가져온다.
    const quantityElem = $('.item_details_quantity_status');

    // 수량을 +1 한다.
    initQuantity += 1;

    // item_details_quantity_status의 'value' 속성에 initQuantity를 넣는다.
    quantityElem.attr('value', initQuantity);

    // jQuery에 속성이 변경되었다고 알려준다.
    quantityElem.change();
});