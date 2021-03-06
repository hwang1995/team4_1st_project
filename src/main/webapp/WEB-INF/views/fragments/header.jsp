<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>
<header class="global_sticky_header">
	<nav class="global_nav">
		<div class="nav_logo">
			<a href="${contextPath}"> <img
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
					href="${contextPath}/shop/outer?subcategory=Jacket">Jacket</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/outer?subcategory=Coat">Coat</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/outer?subcategory=Cardigan">Cardigan</a>
				</li>
				<li class="nav_content_item">|</li>
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop/top">Top</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top?subcategory=Knit">Knit</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top?subcategory=Shirt">Shirt</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/top?subcategory=Tee">Tee</a></li>
				<li class="nav_content_item">|</li>
				<li class="nav_content_item nav_content_item_active"><a
					href="${contextPath}/shop/bottom">Bottom</a></li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/bottom?subcategory=Pants">Pants</a>
				</li>
				<li class="nav_content_item"><a
					href="${contextPath}/shop/bottom?subcategory=Skirt">Skirt</a>
				</li>
				<li class="nav_content_item">|</li>
				<sec:authorize access="isAuthenticated()">
				<li class="nav_content_item nav_content_item_active" onclick="goQnaPage('${contextPath}')">
					<img
						src="${contextPath}/resources/svg/chat-square.svg"
						class="nav_icon_item" width="20px" />
						&nbsp; Q&A
				</li>
				</sec:authorize>
				
			</ul>
		</div>

		<div class="nav_icon">
			<div class="nav_icon_container d-inline-flex">
			<sec:authorize access="isAnonymous()">
				<a href="${contextPath}/auth/login"> 
					<img
						src="${contextPath}/resources/svg/box-arrow-in-left.svg"
						class="nav_icon_item" width="24px" />
				</a> 
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<form method="POST" action="${contextPath}/logout" class="d-inline-flex nav_icon_form_logout">

					<input type="image" src="${contextPath}/resources/svg/box-arrow-in-right.svg" class="nav_icon_item" width="24px">
					<%-- <img
						src="${contextPath}/resources/svg/box-arrow-in-right.svg"
						class="nav_icon_item" width="24px" /> --%>

					
				</form>
				<a href="${contextPath}/account/mypage"> 
					<img
						src="${contextPath}/resources/svg/person.svg"
						class="nav_icon_item" width="24px" />
				</a> 
				<a href="${contextPath}/order/cart"> 
					<img
						src="${contextPath}/resources/svg/bag.svg"
						class="nav_icon_item" width="20px" />
				</a> 
			</sec:authorize>
			
				
				<img
					src="${contextPath}/resources/svg/list.svg"
					class="d-xs-block d-md-none" onclick="drawerClickEvent()"
					width="22px">
			</div>


		</div>


	</nav>

	<div class="nav_drawer_mobile d-md-none">

		<div class="p-4">
			<a href="${contextPath}/shop">
				<h4 class="eng_h2 text_underline mt-3">ALL</h4>
			</a>

			<h4 class="eng_h2 text_underline mt-3">OUTER</h4>
			<h4 class="eng_h2 text_underline mt-3">TOP</h4>
			<h4 class="eng_h2 text_underline mt-3">BOTTOM</h4>
			<a href="${contextPath}/qna">
				<h4 class="eng_h2 text_underline mt-3">Q&A</h4>
			</a>
			
		</div>

	</div>

</header>
