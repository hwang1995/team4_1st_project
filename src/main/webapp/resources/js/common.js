/**
 * 이 JS는 공통적으로 사용하는 메서드와 
 * DOM 조작을 작성하는 JS다.
 */

/**
 * 1. 모바일 헤더의 클릭 이벤트를 정의한다.
 */

let isOpened = false;


/**
 모바일 Drawer가 열리는 이벤트를 정의하기 위한 함수
 */
const drawerClickEvent = () => {
    const drawer = $('.nav_drawer_mobile');
    isOpened = !isOpened;
    (isOpened) ? (drawer.show("slow")) : (drawer.hide("slow"));
}

const goQnaPage = (path) => {
	window.location.href = path + "/qna";
}
/**
 모바일 헤더에서 로그아웃을 누를 시에 동작하는 함수
 */
const mobileLogoutButton = () => {
	$('#nav_mobile_logout_form').submit();
}


const goProductPage = (product_id) => {
	window.location.href = "/webapp/product/" + product_id;
}