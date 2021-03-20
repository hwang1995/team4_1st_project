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

    <link rel="stylesheet" href="${resources}/css/layout/mypage_layout.css">


    <title>Team4 - 마이 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section class="container-fluid">
        <article>
            <div class="mypage_myinfo">
                <div class="myinfo_top_content">
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-2">
                            <h1 class="eng_h1">My Info</h1>
                        </div>
                        <div class="col-5 myinfo_edit">
                            <h5 class="eng_h3"><a href="${contextPath}/account/edit-info">Edit</a></h5>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
                <div class="myinfo_content">
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Name</h5>
                        </div>
                        <div class="col-7">
                            <h5>홍자바</h6>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Email</h5>
                        </div>
                        <div class="col-7">
                            <h5>aaa123@naver.com</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Mobile</h5>
                        </div>
                        <div class="col-7">
                            <h5>01012341234</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Address</h5>
                        </div>
                        <div class="col-7">
                            <h5>서울 송파구 중대로 135 아이티벤쳐타워</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-1"></div>
                <div class="col-9 myinfo_bar"><span></span></div>
                <div class="col-2"></div>
            </div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8 mb-2">
                    <h2 class="eng_h2 order_list_title">Order list</h2>
                    <span class="ml-3 order_list_sub_title">
                        <h5>- 회원님의 최근주문 내역입니다.</h5>
                    </span>
                </div>
                <div class="col-2"></div>
            </div>

           

            <div class="mypage_table_container">
                <div class="col-2"></div>
                <div class="col-8">
                    <table class="order_list_table">
                        <thead class="order_list_thead">
                            <th scope="col">Order No.</th>
                            <th scope="col">Product</th>
                            <th scope="col">Description</th>
                            <th scope="col" width="370">Quantity</th>
                            <th scope="col" width="140">Price</th>
                        </thead>
                        <tbody>
                          <tr>
                            <td rowspan="2">
                                2021-02-23<br/>
                                <a href="${contextPath}/account/order-info" class="order_list_orderno">[0000180]</a>
                            </td>
                            <td>
                                <a href="">
                                    <img src="${resources}/images/products/mypage01.PNG" width="50%">
                                </a>
                            </td>
                            <td>
                               Mock Turtleneck Knit<br/>
                                Color : Ivory 
                            </td>
                            <td>1</td>
                            <td>KRW 238,000</td>
                          </tr>
                          <tr>
                            <td>
                                <a href="">
                                    <img src="${resources}/images/products/mypage02.PNG" width="50%">
                                </a>
                            </td>
                            <td>
                                Flannel Skirt<br/>
                                Size : S
                            </td>
                            <td>1</td>
                            <td>KRW 428,000</td>
                          </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-2"></div>
            </div>
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>

</body>
</html>