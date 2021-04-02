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

<!-- QnA 레이아웃 불러오기 CSS 바꾸기 -->
<link rel="stylesheet" href="${resources}/css/layout/qna_sended_layout.css">

<title>Team4 - QnA 전송 결과 페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

	<section>
        <article>
            <!--qna send title보여주기-->
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 qna_send_title">
                        <h2 class="eng_h2">Q&A Sended</h2>
                    </div>
                    <div class="col-1"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-1 col-lg-2"></div>
                    <div class="col-10 col-lg-8 qna_send_letter">
                        <h5>해당 답변은 2-3일 이내에 회원님의 가입하신 이메일로 발송됩니다.</h5>
                        <div class="qna_send_box">
                            <h4>${cookie.member_email.value}님의 문의가 발송되었습니다.</h4>
                        </div>
                        <div class="text-center">
                            <button class="black_button w-25">
	                          <a href="${contextPath}">
	                            <span class="h6 white_text">메인으로</span>
	                          </a>
                        	</button>
                        </div>
                    </div>
                    <div class="col-1 col-lg-2"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 qna_send_bottom_line"></div>
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