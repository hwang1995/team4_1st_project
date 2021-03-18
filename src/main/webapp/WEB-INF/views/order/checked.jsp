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

    <!-- 주문 완료 페이지 레이아웃 불러오기-->
    <link rel="stylesheet" href="${resources}/css/layout/order_checked_layout.css">

    <title>Team4 - 메인 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
            <div class="container-sm order_finished_container">
                    <h2 class="eng-h3 text-center">Thank you for your purchasing from our website</h2>
                    <div class="order_table_container">
                        <table class="table table-sm text-center order_table_border_top_bottom ">
                            <thead>
                              <tr>
                                <th scope="col">Order no.</th>
                                <th scope="col">Price</th>
                                <th scope="col">Payment</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>2021.03.11</td>
                                <td>KRW 85000</td>
                                <td>무통장입금</td>
                              </tr>
                              <tr>
                                <td>2021.03.11</td>
                                <td>KRW 45000</td>
                                <td>무통장입금</td>
                              </tr>
                              <tr>
                                <td>2021.03.11</td>
                                <td>KRW 35000</td>
                                <td>무통장입금</td>
                              </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="d-flex mt-5 mb-5 justify-content-center">

                        <button class="black_button w-25">
                          <a href="http://localhost:5500">
                            <span class="h6 white_text">메인으로</span>
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