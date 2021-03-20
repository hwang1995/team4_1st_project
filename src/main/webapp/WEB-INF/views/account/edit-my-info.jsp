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
    <link rel="stylesheet" href="${resources}/css/layout/edit-my-info_layout.css">

    <title>Team4 - 정보 수정 페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

    <section>
        <article>
            <div class="container edit_my_info_margin">
                <div class="row">
                    <div class="col">
                        <h5 class="eng_h1">Edit My Info</h5>
                        <form class="mt-3">
                            <div class="form-group row">
                              <label class="col-sm-3 col-form-label">Email</label>
                              <div class="col-sm-7">
                                  <h5 class="eng_h3">abcde12345@naver.com</h5>
                              </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-7">
                                    <h5 class="h5">홍자바</h5>
                                </div>
                            </div>
                            <div class="form-group row">
                              <label for="upassword" class="col-sm-3 col-form-label">Password</label>
                              <div class="col-sm-7">
                                <input type="password" class="form-control" id="upassword">
                              </div>
                            </div>
                            <small class="form-text text-muted text-center mt-n3">영문 대소문자/숫자/특수문자를 혼용하여 10~16자</small>
                            <div class="form-group row">
                                <label for="urepassword" class="col-sm-3 col-form-label">Re-Password</label>
                                <div class="col-sm-7">
                                  <input type="password" class="form-control" id="urepassword">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="uphonenumber" class="col-sm-3 col-form-label">Phone Number</label>
                                <div class="col-sm-7">
                                  <input type="text" class="form-control" id="uphonenumber" pattern="010-\d{3,4}-\d{4}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="uaddress" class="col-sm-3 col-form-label">Address</label>
                                <div class="col-sm-7">
                                  <input type="text" class="form-control" id="uaddress">
                                </div>
                            </div>
                        </form>
                        <div class="row mt-5">
                            <div class="col d-flex justify-content-end">
                                <button class="white_button w-70">
                                    <span class="eng_h1">Back</span>
                                </button>
                            </div>
                            <div class="col">
                                <button class="black_button w-70">
                                    <span class="eng_h1">Confirm</span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col d-md-block d-none text-center">
                        <img src="${resources}/images/account/edit-my-info/edit-my-info.png" alt="product" width="75%"> 
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