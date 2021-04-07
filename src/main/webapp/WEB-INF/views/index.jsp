<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${resources}/css/bootstrap.min.css"/>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script src="${resources}/js/bootstrap.bundle.min.js"></script>

<!-- global style css 불러오기-->
<link rel="stylesheet" href="${resources}/css/reset.css">
<link rel="stylesheet" href="${resources}/css/common.css">

<!-- header, footer css 불러오기 -->
<link rel="stylesheet" href="${resources}/css/header.css">
<link rel="stylesheet" href="${resources}/css/footer.css">

<!-- 메인 페이지 레이아웃 불러오기-->
<link rel="stylesheet" href="${resources}/css/layout/main_layout.css">

<title>Team4 - 메인 페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

	<section>
		<article>
			<div id="carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
				<div class="carousel-item">
						<img
							src="${resources}/images/main/210407_carousel.jpeg"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item active">
						<img
							src="${resources}/images/main/210407_carousel_2.jpeg"
							class="d-block w-100" alt="...">
					</div>
					
				</div>
				<a class="carousel-control-prev" href="#carousel" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">이전</span>
				</a> <a class="carousel-control-next" href="#carousel" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">다음</span>
				</a>
			</div>
		</article>
		<article>
			<div class="container-fluid">
				<div class="row">
					<div class="col">
						<h2 class="eng_h3 main_text_header">MD's Pick</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6 col-lg-3">
						<div class="main_item" onclick="goProductPage(302)">
							<hr>
							<img
								src="${contextPath}/image?path=/Outer/Cardigan/302.jpg"
								class="cursor_pointer"
								width="100%">
							<hr>
							<div class="main_item_textarea"></div>
							<span class="eng_span main_item_text"> Bouffant Cardigan </span> <span
								class="eng_span main_item_text"> KRW 198,000 </span>
						</div>

					</div>
					<div class="col-xs-12 col-md-6 col-lg-3">
						<div class="main_item" onclick="goProductPage(504)">
							<hr>
							<img
								src="${contextPath}/image?path=/Top/Shirt/504.jpg"
								class="cursor_pointer"
								width="100%">
							<hr>
							<span class="eng_span main_item_text">
								Greek Shirt
							</span>
							 <span class="eng_span main_item_text">
							  KRW 109,000 
							  </span>
						</div>
					</div>
					<div class="col-xs-12 col-md-6 col-lg-3">
						<div class="main_item" onclick="goProductPage(303)" >
							<hr>
							<img
								src="${contextPath}/image?path=/Outer/Cardigan/303.jpg"
								class="cursor_pointer"
								width="100%">
							<hr>
							<span class="eng_span main_item_text">
								Bleu Ciel Cardigan
							 </span> 
							 <span class="eng_span main_item_text">
							 	KRW 290,000
							 </span>
						</div>
					</div>
					<div class="col-xs-12 col-md-6 col-lg-3">
						<div class="main_item" onclick="goProductPage(204)">
							<hr>
							<img
								src="${contextPath}/image?path=/Outer/Coat/204.jpg"
								class="cursor_pointer"
								width="100%">
							<hr>
							<span class="eng_span main_item_text"> 
								Mac Coat with Detachable Lining
							 </span> 
							 <span class="eng_span main_item_text"> 
							 KRW 960,000
							</span>
						</div>
					</div>
				</div>
			</div>
			<br>
			<br>
			<br>
			<!-- 임시로 있는 엘리먼트, 아래로 margin 줄 예정-->
		</article>
	</section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	

	<!-- jQuery DOM 조작 관련된 JS -->
	<script src="${resources}/js/common.js"></script>

</body>
</html>