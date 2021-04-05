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
    <link rel="stylesheet" href="${resources}/css/layout/forgot-my-pw-result-layout.css">

    <title>Team4 - 비밀번호 찾기 결과 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
            <!--비밀번호 찾기 결과 title보여주기-->
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 find_pw_result_title">
                        <h2>비밀번호 찾기 결과</h2>
                    </div>
                    <div class="col-1"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-1 col-lg-2"></div>
                    <div class="col-10 col-lg-8 find_pw_result_letter">
                        <h5>회원가입시, 입력하신 회원 정보 또는 본인 인증으로 이메일과 이름으로 확인할 수 있습니다.</h5>
                        <h5>정보 보호를 위해 임시 비밀번호로 재설정 되었습니다.</h5>
                        <div class="find_pw_content-box">
                            <h4>임시비밀번호는 1q2w3e4r 입니다.</h4>
                        </div>
                        <div class="find_pw_result_login text-center">
                            <button class="black_button w-40">
                                <h5 class="eng_h2">
									<a href="${contextPath}/auth/login" class="white_text">
										LOGIN
									</a>                                
                                </h5>
                            </button>
                        </div>
                    </div>
                    <div class="col-1 col-lg-2"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 find_pw_result_bottom_line"></div>
                    <div class="col-1"></div>
                </div>
            </div>

        </article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	
	 <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>

</body>
</html>