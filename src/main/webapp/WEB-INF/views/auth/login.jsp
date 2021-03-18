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


    <!-- 회원가입 페이지 레이아웃 불러오기-->
    <link rel="stylesheet" href="${resources}/css/layout/login_layout.css">

    <title>Team4 - 로그인 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />
    <section>
        <article>
            <div class="login_content container-sm">
                <div class="login_top_content">
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-4">
                            <h2 class="eng_h1">Login</h2>
                        </div>
                        <div class="col-2 find_password pt-3">
                            <h6 class="eng_h3"><a href="${contextPath}/auth/forgot-my-pw">find my password</a></h6>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
                <div class="login_main_conent">
                    <div class="row mb-3">
                        <div class="col-3"></div>
                        <div class="col-4">
                            <input type="text" name="email" id="email" placeholder="E-mail">
                        </div>
                        <div class="col-2">
                            <button class="black_button ml-1" onclick="goHomePage('${contextPath}')">
                                <span class="h4 eng_h2 login_button">
                                
                                LOGIN</span>
                            </button>
                        </div>
                        <div class="col-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-4">
                            <input type="password" name="password" id="password" placeholder="PW">
                        </div>
                        <div class="col-2">
                            <button class="white_button ml-1" onClick="goRegisterPage('${contextPath}')">
                                <span class="h4 eng_h2">
                                        REGISTER
                                    </span>
                            </button>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
            </div>
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />


    <!-- jQuery DOM 조작 관련된 JS -->
   	<script src="${resources}/js/common.js"></script>
   	<script src="${resources}/js/login.js"></script>
</body>
</html>