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

    <!-- 회원가입 완료 페이지 레이아웃 불러오기-->
    <link rel="stylesheet" href="${resources}/css/layout/welcome_layout.css">

    <title>Team4 - 회원가입 완료 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
            <div class="container-sm">
                <div class="welcome_area">
                    <div class="welcome_text text-center">
                        <h1>환영합니다!</h1>
                        <br>
                        <p>${cookie.member_email.value}님, 회원가입을 축하합니다!</p>
                    </div>
                    <div class="welcome_text_small text-center">
                        <p>항상 회원님들의 입장에서</p>
                        <p>보다 좋은 서비스를 받을 수 있도록 노력하겠습니다.</p>
                        <p>감사합니다 :D</p>
                    </div>
                    <div class="d-flex justify-content-center">
                        <button class="black_button w-25">
                            <a href="${contextPath}">
                                <span class="h6 white_text">
                                    메인으로</span>
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