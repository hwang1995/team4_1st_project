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


    <!-- 장바구니 레이아웃 CSS 불러오기 -->
    <link rel="stylesheet" href="${resources}/css/layout/cart_layout.css">
    
    <title>Team4 - 장바구니 페이지</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
           <!-- 장바구니 col 1 10 1 비율-->
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 cart_title">
                        <h2 class="eng_h2">cart</h2>
                    </div>
                    <div class="col-1"></div>
                </div>

                <!--카트 메뉴바-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 cart_bar">
                        <div class="container">
                            <div class="row">
                                <div class="col-3">
                                    <h6 class="eng_h4">Product</h6>
                                </div>
                                <div class="col-3">
                                    <h6 class="eng_h4">Description</h6>
                                </div>
                                <div class="col-3">
                                    <h6 class="eng_h4">Quantity</h6>
                                </div>
                                <div class="col-2">
                                    <h6 class="eng_h4">Price</h6>
                                </div>
                                <div class="col-1">
                                
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
        
                <!--카트에 담긴 물건-->
                <div class="row mt-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3">
                                    <a href="#"> <!--나중에 onclick 이벤트-->
                                    <img src="${resources}/images/products/2.jpg" width="100%"></a>
                                </div>
                                <div class="col-3 cart_description">
                                    <h6 class="eng_h4">Bleu Ciel Cardigan</h6>
                                    <h6 class="eng_h4">Color : Sky Blue</h6>
                                </div>
                                <div class="col-3 cart_quantity">
                                    <h6 class="eng_h4">1</h6>
                                </div>
                                <div class="col-2 cart_price" >
                                    <h6 class="eng_h4">KRW 290,000</h6>
                                </div>
                                <div class="col-1 cart_delete">
                                <a class="eng_h4 text_underline" href="#">delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
                <div class="row mt-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3">
                                    <a class="text_underline" href="#"> <!--나중에 onclick 이벤트-->
                                    <img src="${resources}/images/products/3.jpg" width="100%"></a>
                                </div>
                                <div class="col-3 cart_description">
                                    <h6 class="eng_h4">Creased Denim Pants</h6>
                                    <h6 class="eng_h4">Size : S</h6>
                                </div>
                                <div class="col-3 cart_quantity">
                                    <h6 class="eng_h4">1</h6>
                                </div>
                                <div class="col-2 cart_price" >
                                    <h6 class="eng_h4">KRW 245,000</h6>
                                </div>
                                <div class="col-1 cart_delete">
                                <a class="eng_h4 text_underline" href="#">delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>

                <!--delivery Charge-->
                <div class="row mt-5 mb-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3"></div>
                                <div class="col-3"></div>
                                <div class="col-3">
                                    <h5 class="eng_h4">Delivery charge :</h5>
                                </div>
                                <div class="col-3 d-flex justify-content-end">
                                    <h5 class="eng_h4">KRW 0</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
            
                 <!--Total Charge-->
                <div class="row mb-4">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3"></div>
                                <div class="col-3"></div>
                                <div class="col-3">
                                    <h3 class="eng_h3">Total :</h3>
                                </div>
                                <div class="col-3 d-flex justify-content-end">
                                    <h3 class="eng_h3">KRW 535,000</h4>
                                </div>
                        
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>

                <!--Back/Check Button-->
                <div class="row mb-5">
                    <div class="col-3"></div>
                    <div class="col-3"></div>
                    <div class="col-6 d-flex">
                        <button class="white_button m-3">
                            <a href="${contextPath}">
                                <h4 class="eng_h2 ">Back</h4>
                            </a>
                            
                        </button>
                        <button class="black_button m-3">
                            <a href="${contextPath}/order/checkout">
                                <h4 class="eng_h2 white_text">Check</h4>
                            </a>
                            
                        </button>
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