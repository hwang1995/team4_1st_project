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

    <!-- 카테고리(All) 페이지 레이아웃 불러오기-->
    <link rel="stylesheet" href="${resources}/css/layout/categories_layout.css">

    <title>Team4 - 카테고리(All) 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
            <div class="categories_article container-fluid">
                <div class="categories_orders">
                    <select name="item" id="item_select" class="categories_orders_select" >
                        <option value>Select</option>
                        <option value="high_price">높은 가격순</option>
                        <option value="low_price">낮은 가격순</option>
                    </select>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <a href="http://localhost:5500/pages/product/1.html">
                        <div class="categories_item">
                            
                                <img src="../../assets/images/category/all/All01.PNG" width="80%">
                                <div class="categories_item_text">
                                    <h5 class="eng_h4">William Jacket by Harris Tweed</h5>
                                    <h5 class="eng_h4">KRW 580,000</h5>
                                </div>
                            
                            
                        </div>
                        </a>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All02.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Gris Jacket by Harris Tweed</h5>
                                <h5 class="eng_h4">KRW 580,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All03.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Camus Jacket by Lovat</h5>
                                <h5 class="eng_h4">KRW 598,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All04.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Flannel Skirt By Fox Brothers</h5>
                                <h5 class="eng_h4">KRW 428,000</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All05.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Vera Cashmere Crewneck Knit</h5>
                                <h5 class="eng_h4">KRW 280,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All06.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Cild Corduroy Pants by Okayama</h5>
                                <h5 class="eng_h4">KRW 278,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All07.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Chelsea V-neck Knit</h5>
                                <h5 class="eng_h4">KRW 158,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All08.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Maison Knit One-piece</h5>
                                <h5 class="eng_h4">KRW 289,000</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All09.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Etudiante Cardigan</h5>
                                <h5 class="eng_h4">KRW 189,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All10.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Jacqueline Turtleneck Knit</h5>
                                <h5 class="eng_h4">KRW 185,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All11.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Mock Turtleneck Knit</h5>
                                <h5 class="eng_h4">KRW 238,000</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6 col-lg-3">
                        <div class="categories_item">
                            <img src="../../assets/images/category/all/All12.PNG" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">Ned Turtleneck Knit</h5>
                                <h5 class="eng_h4">KRW 158,000</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>

</body>
</html>