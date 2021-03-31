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
                
               <c:forEach var="product_list" items="${lists}">
               	<div class="row">
               		<c:forEach var="product" items="${product_list}">
               			<div class="col-xs-12 col-md-6 col-lg-3">
                        	<div class="categories_item">
                            	<img src="${product.product_image}" width="80%">
                            <div class="categories_item_text">
                                <h5 class="eng_h4">${product.product_name}</h5>
                                <h5 class="eng_h4">${product.product_price}</h5>
                            </div>
                        </div>
                    </div>
               		</c:forEach>
               		</div>
               </c:forEach>
           </div>
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>

</body>
</html>