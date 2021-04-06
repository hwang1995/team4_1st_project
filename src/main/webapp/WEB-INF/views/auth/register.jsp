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
    <link rel="stylesheet" href="${resources}/css/layout/register_layout.css">

    <title>Team4 - 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article class="container mtb-8">
            <h1 class="eng_h2 mb-4">Register</h1>
            <div class="row">
                <div class="col-12 col-md-7 mt-2 vertical_divider">
                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">E-Mail</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="email" name="u_email" id="u_email" 
                                   class="w-100 register_input" placeholder="ex) yourname@gmail.com">
                        </div>
                        <div class="col-3">
                            <button class="white_button email_check_button w-100 h-100">
                                <h6 class="eng_h2">CHECK</h6>
                            </button>
                        </div>
                    </div>
                    
                    <div class="row">
                    	<div class="col-3"></div>
                    	<div class="col-6 ml-3">
                    		<span id="errorUemail" class=""></span>
                    	</div>
                    	<div class="col-3"></div>
                    </div>
                    

                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">Name</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="text" name="u_name" id="u_name" class="w-100 register_input">
                        </div>
                        <div class="col-3"></div>
                    </div>

                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">PW</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="password" name="u_password" id="u_password" 
                                   class="w-100 register_input"
                                   placeholder="영문, 숫자 조합 8 ~ 10자"
                            >
                            
                        </div>
                        <div class="col-3">
                        </div>
                    </div>

                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">Re-PW</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="password" name="u_re_password" id="u_re_password" class="w-100 register_input">
                        </div>
                        <div class="col-3"></div>
                    </div>

                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">Tel</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="tel" name="u_tel" id="u_tel" class="w-100 register_input" placeholder="01X-XXXX-XXXX">
                        </div>
                        <div class="col-3"></div>
                    </div>

                    <div class="row m-2">
                        <div class="col-3 register_info_text">
                            <h6 class="eng_h2">Address</h6>
                        </div>
                        <div class="col-6"> 
                            <input type="text" name="u_address" id="u_address" class="w-100 register_input">
                        </div>
                        <div class="col-3"></div>
                    </div>

                </div>
                <div class="col-12 col-md-5 mt-2 vertical_divider">
                    <h5 class="eng_h2 m-2">
                        Terms and Conditions
                    </h5>
                   
                    <div class="register_terms mt-3 w-100 h-25">
                        <p>
						인터넷 쇼핑몰 『에디토컴퍼니(주) 사이버 몰』회원 약관
						<br/>
						제1조(목적) <br/>
						이 약관은 에디토컴퍼니(주) 회사(전자상거래 사업자)가 운영하는 에디토컴퍼니(주) 사이버 몰(이하 “몰”이라 한다)에서 제공하는 인터넷 관련 서비스(이하 “서비스”라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.
						<br/>
						※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」
                        </p>
                    </div>

                    <!-- 약관 동의 컨테이너 (GDPR) -->
                    <div class="register_gdpr_container m-2 mt-4">
                        <h5 class="eng_h2 mt-5 mb-3">약관 동의 </h5>
                        <div class="d-flex">
                            <div class="align-items-center mr-2">
                                <input type="checkbox" name="all_check" id="all_check">
                            </div>
                            
                            <span class="eng_h2">모두 동의합니다.</span>
                        </div>

                        <hr class="divider">

                        <!-- 구매회원 이용 약관 동의 -->
                        <div class="d-flex">
                            <div class="align-items-center mr-2">
                                <input type="checkbox" name="agreement" id="agreement">
                            </div>
                            
                            <span class="eng_h2 popover_agreement">구매회원 이용 약관 동의</span>
                        </div>

                        <!-- 개인 정보 수집 및 이용 동의 -->
                        <div class="d-flex">
                            <div class="align-items-center mr-2">
                                <input type="checkbox" name="gdpr_agreement" id="gdpr_agreement">
                            </div>
                            
                            <span class="eng_h2 popover_gdpr_agree">개인 정보 수집 및 이용 동의</span>
                        </div>

                        <!-- 마케팅 수신 동의 -->
                        <div class="d-flex">
                            <div class="align-items-center mr-2">
                                <input type="checkbox" name="marketing_agreement" id="marketing_agreement">
                            </div>
                            
                            <span class="eng_h2 popover_marketing_agreement">마케팅 수신 동의</span>
                        </div>

                    </div>

                    <div class="d-flex flex-row-reverse mt-5 ">
                        <button class="black_button w-50 register_confirm_button" onclick="validate()">
                                <h5 class="eng_h2 white_text">CONFIRM</h5>
                            
                        </button>
                    </div>

                </div>
            </div>

        </article>
       
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />

    <!-- jQuery DOM 조작 관련된 JS -->
    <script src="${resources}/js/common.js"></script>
    <script src="${resources}/js/register.js"></script>
</body>
</html>