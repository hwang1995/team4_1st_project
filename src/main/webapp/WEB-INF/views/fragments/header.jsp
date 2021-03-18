<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>
<header class="global_sticky_header">
	<nav class="global_nav">
		<div class="nav_logo">
			<a href="http://localhost:5500/"> <img
				src="${contextPath}/resources/images/main/mainlogo.png"
				alt="mainLogo" width="100%">
			</a>
		</div>

		<div class="nav_content">
			<ul class="nav_content_list">
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop">All</a></li>
				<li class="nav_content_item">|</li>
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop/outer">Outer</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/outer/jacket">Jacket</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/outer/coat">Coat</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/outer/jumper">Jumper</a>
				</li>
				<li class="nav_content_item">|</li>
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop/top">Top</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top/knit">Knit</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top/shirt">Shirt</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top/tee">Tee</a></li>
				<li class="nav_content_item">|</li>
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop/bottom">Bottom</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/bottom/pants">Pants</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/bottom/skirt">Skirt</a>
				</li>
			</ul>
		</div>

		<div class="nav_icon">
			<div class="nav_icon_container">
				<a href="${contextPath}/auth/login"> <img
					src="${contextPath}/resources/svg/box-arrow-in-left.svg"
					class="nav_icon_item" width="24px" />
				</a> <a href="${contextPath}/account/mypage"> <img
					src="${contextPath}/resources/svg/person.svg"
					class="nav_icon_item" width="24px" />
				</a> <a href="${contextPath}/order/cart"> <img
					src="${contextPath}/resources/svg/bag.svg"
					class="nav_icon_item" width="20px" />
				</a> <img
					src="${contextPath}/resources/svg/list.svg"
					class="d-xs-block d-md-none" onclick="drawerClickEvent()"
					width="22px">
			</div>


		</div>


	</nav>

	<div class="nav_drawer_mobile d-md-none">

		<div class="p-4">
			<a href="http://localhost:5500/pages/shop/all.html">
				<h4 class="eng_h2 text_underline mt-3">ALL</h4>
			</a>

			<h4 class="eng_h2 text_underline mt-3">OUTER</h4>
			<h4 class="eng_h2 text_underline mt-3">TOP</h4>
			<h4 class="eng_h2 text_underline mt-3">BOTTOM</h4>
		</div>

	</div>

</header>
