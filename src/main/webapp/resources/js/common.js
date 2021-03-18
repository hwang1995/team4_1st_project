/**
 * 이 JS는 공통적으로 사용하는 메서드와 
 * DOM 조작을 작성하는 JS다.
 */

/**
 * 1. 모바일 헤더의 클릭 이벤트를 정의한다.
 */

let isOpened = false;


const drawerClickEvent = () => {
    const drawer = $('.nav_drawer_mobile');
    isOpened = !isOpened;
    (isOpened) ? (drawer.show("slow")) : (drawer.hide("slow"));
}