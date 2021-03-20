<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<link rel="stylesheet" href="${resources}/css/bootstrap.min.css">
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="${resources}/js/bootstrap.bundle.min.js"></script>
		
		<!-- global style css 불러오기-->
		<link rel="stylesheet" href="${resources}/css/reset.css">
		<link rel="stylesheet" href="${resources}/css/common.css">
		
		<!-- header, footer css 불러오기 -->
		<link rel="stylesheet" href="${resources}/css/header.css">
		<link rel="stylesheet" href="${resources}/css/footer.css">
	
	    <!-- 상품 상세 페이지 레이아웃 불러오기-->
	    <link rel="stylesheet" href="${resources}/css/layout/item_details_layout.css">
	
	    <title>Team4 - 상품 상세 페이지</title>
</head>
	
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />


    <section>
        <article>
            <div class="container-xl item_details_container">
                <div class="row">
                    <div class="col-12 col-md-6">
                        <img src="${resources}/images/products/1.jpeg" alt="product" width="100%"> 
                    </div>
                    <div class="col-12 col-md-6 ">
                         <div class="item_description">
                             <!-- 해상도 조건이 md(768px) 이상인 경우 나오는 레이아웃 -->
                            <div class="d-md-block d-none">
                                <h2 class="eng_h2">Tortillon Knit</h2>
                                <h6 class="mt-3"> - 캐시미어 100% </h6>
                                <h6 class="mt-1"> - All Needle 조직</h6>
                                <h6 class="mt-1"> - 7 게이지</h6>
                                <h6 class="mt-3">
                                    캐시미어 소재의 가벼운 착용감의 숏 슬리브 니트입니다. <br>
                                    촉감이 매우 부드럽고, 단품 이너 등 간절기 및 다양한 활용이 <br>
                                    가능합니다.
                                </h6>
                            </div>
    
                            <!-- 해상도 조건이 md(768 px) 이하인 경우 나오는 레이아웃 -->
                            <div class="d-md-none d-block mt-4 d-flex flex-column justify-content-center">
                                <h3 class="eng_h2">Tortillon Knit</h3>
                                <h6 class="mt-3"> - 캐시미어 100% </h6>
                                <h6 class="mt-1"> - All Needle 조직</h6>
                                <h6 class="mt-1"> - 7 게이지</h6>
                                <h6 class="mt-3">
                                    캐시미어 소재의 가벼운 착용감의 숏 슬리브 니트입니다. <br>
                                    촉감이 매우 부드럽고, 단품 이너 등 간절기 및 다양한 활용이 <br>
                                    가능합니다.
                                </h6>
                            </div>
                         </div>
                      
                        
                        <div class="item_details">
                            <h5 class="eng_h3 mt-2 text-right">
                                KRW 239,000
                            </h5>
                            <br>
                            <div class="row">

                                <div class="col mt-3">
                                    <h6 class="eng_h3">Color</h6>
                                    <select name="color" class="select_item mt-2 p-1">
                                        <option value="ivory">아이보리</option>
                                        <option value="old_rose">올드로즈</option>
                                    </select>
                                    <button class="mt-3 white_button" onclick="goCartPage('${contextPath}')">
                                        <span class="eng_h5">ADD TO CART</span>
                                    </button>
                                </div>
                                <div class="col mt-3">
                                    <h6 class="eng_h3">Quantity</h6>
                                    <div class="item_details_quantity d-flex mt-2">
                                        <div class="item_details_minus ml-2 mr-3 d-flex align-items-center">
                                            <img src="${resources}/svg/dash.svg" alt="minus" width="24px">
                                        </div>
                                        <input type="tel" class="item_details_quantity_status eng_h3" value=1 >
                                        <div class="item_details_plus ml-3 mr-2 d-flex align-items-center">
                                            <img src="${resources}/svg/plus.svg" alt="plus" width="24px">
                                        </div>
                                    </div>
                                    <button class="mt-3 black_button" onclick="goBuyPage('${contextPath}')">
                                            <span class="eng_h5 white_text">BUY NOW</span>
                                        
                                    </button>
                                </div>
                               
                            </div>
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </article>
        
        <article class="container mt-3 mb-5 p-1 ">
            <hr class="divider">
            <div class="">
                <img src="${resources}/images/products/1_details.jpeg" alt="" width="100%">
                <img src="${resources}/images/products/1_datails_2.jpg" alt="" width="100%">
                <img src="${resources}/images/products/1_details_3.jpg" alt="" width="100%">
                <img src="${resources}/images/products/1_details_4.jpg" alt="" width="100%">
                <img src="${resources}/images/products/1_details_5.jpg" alt="" width="100%">
            </div>
        </article>
    </section>

    <jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>
    <script src="${resources}/js/product_details.js"></script>
    

</body>
</html>