<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                                <td>${order.order_id}</td>
                                <th>주문일자</th>
                                <td><fmt:formatDate value="${order.order_date}" pattern="yyyy.MM.dd"/></td>		
                            </tr>
                            <tr>
                                <th>주문자</th>
                                <td>${member.member_name}</td>
                                <th>결제현황</th>
                                <td>${order.order_payment_status}</td>		
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
                                <td>${order.recipient_name}</td>
                                <th>연락처</th>
                                <td>${order.recipient_tel}</td>		
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>${order.recipient_address}</td>
                                <th>배송현황</th>
                                <td>${order.order_delivery_status}</td>		
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
                                <div class="col-5 ">
                                    <h6 class="eng_h4">Description</h6>
                                </div>
                                <div class="col-1 ">
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
                <c:forEach var="list" items="${orderList}">
	                <div class="row mb-3">
	                    <div class="col-1"></div>
	                    <div class="col-10">
	                        <div class="container">
	                            <div class="row">
	                                <div class="col-3">
	                                    <a href="/webapp/product/${list.product_id}">
	                                    <img src="${list.product_image}" width="100%"></a>
	                                </div>
	                                <div class="col-5 order_item_description">
	                                    <h6 class="eng_h4">${list.product_name}</h6>
	                                    <h6 class="eng_h4">Color : ${list.product_color}</h6>
	                                    <h6 class="eng_h4">Size : ${list.product_size}</h6>
	                                </div>
	                                <div class="col-1 order_item_quantity">
	                                    <h6 class="eng_h4">${list.product_quantity}</h6>
	                                </div>
	                                <div class="col-3 order_item_price" >
	                                    <h6 class="eng_h4">KRW <fmt:formatNumber value="${list.product_price}" pattern="#,###,###"/></h6>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-1"></div>
	                </div>
				</c:forEach>
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
                                    <h5 class="eng_h4">KRW ${order.order_delivery_charge}</h5>
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
                                    <h3 class="eng_h3">KRW <fmt:formatNumber value="${totalPrice}" pattern="#,###,###"/></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
                <!--close button-->
                <div class="row text-center mb-5" >
                    <div class="col">
                        <button class="black_button w-25" onclick="goCheckedPage('${contextPath}')"><h4 class="eng_h2">Back</h4></button>
                    </div>
                </div>
            </div>

        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>
    <script src="${resources}/js/order-info.js"></script>

</body>
</html>