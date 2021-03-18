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

    <!-- 주문 상세 페이지 레이아웃 CSS 불러오기 -->
    <link rel="stylesheet" href="${resources}/css/layout/order-info_layout.css">
    
    <title>Team4 - 주문 상세 페이지</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
    <section>
        <article>
           <!--주문상세페이지-->
           <div class="container">
               <!--orderInformation-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 order_info_title">
                        <h2 class="eng_h2">Order Information</h2>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--Buyer Info-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <h3 class="eng_h3">Buyer Info</h3>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--Buyer Info table-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <table class="bordered_table">
                            <tr>
                                <th>주문번호</th>
                                <td>20210223-0000180</td>
                                <th>주문일자</th>
                                <td>2021.02.23</td>		
                            </tr>
                            <tr>
                                <th>주문자</th>
                                <td>홍자바</td>
                                <th>결제현황</th>
                                <td>결제 완료</td>		
                            </tr>
                        </table>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--Shipping Info-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 pt-5">
                        <h3 class="eng_h3">Shipping Info</h3>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--Shipping Info table-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <table class>
                            <tr>
                                <th>수취인</th>
                                <td>홍자바</td>
                                <th>연락처</th>
                                <td>010-1234-1234</td>		
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>서울 송파구 중대로 135 아이티벤처타워</td>
                                <th>배송현황</th>
                                <td>배송 대기</td>		
                            </tr>
                        </table>
                    </div>
                    <div class="col-1"></div>
                </div>

                <!--Order Item Info-->
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 pt-5">
                        <h3 class="eng_h3">Order Item Info</h3>
                    </div>
                    <div class="col-1"></div>
                </div>
            
                <!--order item info 메뉴바--> 
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 order_item_info_bar">
                        <div class="container">
                            <div class="row">
                                <div class="col-3 ">
                                    <h6 class="eng_h4">Product</h6>
                                </div>
                                <div class="col-3 ">
                                    <h6 class="eng_h4">Description</h6>
                                </div>
                                <div class="col-3 ">
                                    <h6 class="eng_h4">Quantity</h6>
                                </div>
                                <div class="col-3 ">
                                    <h6 class="eng_h4">Price</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--order item content-->
                <div class="row mb-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3">
                                    <a href="#">
                                    <img src="${resources}/images/products/2.jpg" width="100%"></a>
                                </div>
                                <div class="col-3 order_item_description">
                                    <h6 class="eng_h4">Bleu Ciel Cardigan</h6>
                                    <h6 class="eng_h4">Color : Sky Blue</h6>
                                </div>
                                <div class="col-3 order_item_quantity">
                                    <h6 class="eng_h4">1</h6>
                                </div>
                                <div class="col-3 order_item_price" >
                                    <h6 class="eng_h4">KRW 290,000</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
                <div class="row mb-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div class="container">
                            <div class="row">
                                <div class="col-3">
                                    <a href="#">
                                        <img src="${resources}/images/products/3.jpg" width="100%"></a>
                                </div>
                                <div class="col-3 order_item_description">
                                    <h6 class="eng_h4">Creased Denim Pants</h6>
                                    <h6 class="eng_h4">Size : S</h6>
                                </div>
                                <div class="col-3 order_item_quantity">
                                    <h6 class="eng_h4">1</h6>
                                </div>
                                <div class="col-3 order_item_price" >
                                    <h6 class="eng_h4">KRW 245,000</h6>
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
                <div class="row order_total_charge_row">
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
                <!--close button-->
                <div class="row text-center mb-5" >
                    <div class="col">
                        <button class="black_button w-25"><h4 class="eng_h2">Check</h4></button>
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