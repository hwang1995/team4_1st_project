<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
                <form method="post" action="${contextPath}/login">
                  <div class="login_main_conent">
                    <div class="row mb-3">
                        <div class="col-3"></div>
                        <div class="col-4">
                            <input type="text" name="user_email" id="user_email" placeholder="E-mail" autofocus tabindex="1">
                        </div>
                        <div class="col-2">
                          <button type="submit" class="black_button ml-1" onclick="loginValidate()">
								<span class="h4 eng_h2 login_button white_text">LOGIN</span>
                          </button>
                        </div>
                        <div class="col-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-4">
                            <input type="password" name="user_password" id="user_password" placeholder="PW" tabindex="2">
                        </div>
                        <div class="col-2">
	                        <a href="${contextPath}/auth/register" class="btn white_button ml-1">
	                        	<span class="h4 eng_h2">
	                        		REGISTER
	                        	</span>
	                        </a>
                        </div>
                        <div class="col-3"></div>
                    </div>
                </div>
                
                <!--
                Bad Credentials 에러 -> '아이디 또는 비밀번호가 틀립니다' 보여주기 위함
                세션에 저장되어 온 에러메시지를 출력 후, 세션 제거
                -->
                <div class="row mt-3">
                	<div class="col-3"></div>
                	<div class="col-4">
                		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	                		<p class="text-danger">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
	                		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	               		</c:if>
                	</div>
	                
                </div>
                
                
                </form>
                
            </div>
        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />


    <!-- jQuery DOM 조작 관련된 JS -->
   	<script src="${resources}/js/common.js"></script>
   	<script src="${resources}/js/login.js"></script>
</body>
</html>