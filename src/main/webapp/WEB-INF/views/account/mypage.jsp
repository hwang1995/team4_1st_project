<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>
<c:set var="mypageCount" value="${fn:length(mypage)}"></c:set>


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
                            <h5>${member.member_name}</h6>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Email</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_email}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Mobile</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_tel}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1">
                            <h5 class="eng_h2">Address</h5>
                        </div>
                        <div class="col-7">
                            <h5>${member.member_address}</h5>
                        </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8 myinfo_bar"><span></span></div>
                <div class="col-2"></div>
            </div>

            <div class="row mt-3 mb-3">
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
                
                    <table class="table-bordered order_list_table">
                        <thead class="order_list_thead">
                            <th scope="col" width="100">Order No.</th>
                            <th scope="col" width="300">Product</th>
                            <th scope="col" width="300">Description</th>
                            <th scope="col" width="100">Quantity</th>
                            <th scope="col" width="140">Price</th>
                        </thead>
                        <tbody>
                        	<c:if test="${mypageCount > 0 }">
	                    		<c:forEach var="order" items="${mypage}">
			                          <tr>
			                            <td rowspan="${fn:length(order.myPageList)}">
			                                <fmt:formatDate value="${order.order_date}" pattern="yyyy-MM-dd"/><br/>
			                                <a href="${contextPath}/account/order-info?order_id=${order.order_id}" class="order_list_orderno">[${order.order_id}]</a>
			                            </td>
			                            <c:forEach var="orderlist" items="${order.myPageList}">
			                            <td>
			                                <a href="/webapp/product/${orderlist.product_id}">
			                                    <img src="${orderlist.product_image}" width="50%">
			                                </a>
			                            </td>
			                            <td>
			                               ${orderlist.product_name}<br/>
			                                Color : ${orderlist.product_color}<br/>
			                                Size : ${orderlist.product_size}
			                            </td>
			                            <td>${orderlist.product_quantity}</td>
			                            <td>KRW <fmt:formatNumber value="${orderlist.product_price}" pattern="#,###,###"/></td>
			                            </tr>
			                            </c:forEach>
			                   </c:forEach>
			                </c:if>
			                <c:if test="${mypageCount == 0 }">
				               	<tr>
				               		<td colspan="5" class="eng_h2" style="height : 50vh;">
				               		최근 주문 내역이 비어있습니다.
				               		</td>
				               	</tr>
				            </c:if>
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