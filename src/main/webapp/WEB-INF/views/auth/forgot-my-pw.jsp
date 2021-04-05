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

    <!-- 비밀번호 찾기 레이아웃 불러오기-->
	<link rel="stylesheet" href="${resources}/css/layout/forgot_my-pw.css">
    <title>Team4 - 비밀번호 찾기</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article class="container mtb-8">
            <caption>
                <h2 class="eng_h1">Forgot your password?</h2>
            </caption>
            <hr class="bold_divider">
            <!-- md 해상도 이상부터 보이는 레이아웃 -->
            <div class="p-6 d-none d-md-block">
                <caption>
                    <p class="eng_h2">
                        회원가입시, 입력하신 회원 정보 또는 본인 인증으로 이메일과 이름으로 확인할 수 있습니다. <br>
                        임시비밀번호로 재설정 되어 알려드립니다.
                    </p>
                </caption>
                <div class="row mt-5">
                    <div class="col-2"></div>
                    <div class="col-3 d-flex align-items-center">
                        <h6 class="eng_h2">E-Mail</h6>
                    </div>
                    <div class="col-5 d-flex align-items-center">
                        <input 
                            type="email" name="u_email" id="u_email_desktop"
                            class="forgot_my_pw_input w-100 h-100"
                        >

                    </div>
                    <div class="col-2"></div>
                </div>

                <div class="row mt-2">
                    <div class="col-2"></div>
                    <div class="col-3 d-flex align-items-center">
                        <h6 class="eng_h2">Name</h6>
                    </div>
                    <div class="col-5 d-flex align-items-center">
                        <input 
                            type="text" name="u_name" id="u_name_desktop"
                            class="forgot_my_pw_input w-100 h-100"
                        >

                    </div>
                    <div class="col-2"></div>
                </div>

                <div class="d-flex mt-5 justify-content-center">
                    <button class="black_button w-25 forgot_my_pw_button_desktop">
                        <h5 class="eng_h2 ">
                        	<span class="white_text">CHECK</span>
                       	</h5>
                    </button>
                </div>
                

            </div>


            <div class="p-2 d-md-none">
                <caption>
                    <p class="eng_h2">
                        회원가입시, 입력하신 회원 정보 또는 본인 인증으로 이메일과 이름으로 확인할 수 있습니다. <br>
                        임시비밀번호로 재설정 되어 알려드립니다.
                    </p>
                </caption>
                <div class="row mt-5">
                    <div class="col-3 d-flex align-items-center">
                        <h6 class="eng_h2">E-mail</h6>
                    </div>
                    <div class="col-9 d-flex align-items-center">
                        <input 
                            type="email" name="u_email" id="u_email_mobile"
                            class="forgot_my_pw_input w-100 h-100"
                        >
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-3 d-flex align-items-center">
                        <h6 class="eng_h2">Name</h6>
                    </div>
                    <div class="col-9 d-flex align-items-center">
                        <input 
                            type="text" name="u_name" id="u_name_mobile"
                            class="forgot_my_pw_input w-100 h-100"
                        >
                    </div>
                </div>
                <div class="d-flex mt-5 justify-content-center">
                    <button class="black_button w-50 forgot_my_pw_button_mobile">
                        <h5 class="eng_h2">
                        <span class="white_text">CHECK</span>
                        </h5>
                    </button>
                </div>


            </div>
            
        </article>
       
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />	

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>
    <script src="${resources}/js/forgot-my-pw.js"></script>

</body>
</html>