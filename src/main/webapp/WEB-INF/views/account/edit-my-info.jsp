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
	<input type="hidden" id="u_email" value="${member.member_email}"/>
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
                                  <h5 class="eng_h3">${member.member_email}</h5>
                              </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-7">
                                    <h5 class="h5">${member.member_name}</h5>
                                </div>
                            </div>
                            <div class="form-group row">
                              <label for="upassword" class="col-sm-3 col-form-label">Password</label>
                              <div class="col-sm-7">
                                <input type="password" class="form-control" id="u_password" name="u_password">
                                <small class="form-text text-muted mb-n2">영문, 숫자 조합 8 ~ 10자</small>
                              </div>
                            </div>
                            <div class="form-group row">
                                <label for="urepassword" class="col-sm-3 col-form-label">Re-Password</label>
                                <div class="col-sm-7">
                                  <input type="password" class="form-control" id="u_re_password" name="u_re_password">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="uphonenumber" class="col-sm-3 col-form-label">Phone Number</label>
                                <div class="col-sm-7">
                                  <input type="text" class="form-control" id="u_tel" name="u_tel" value="${member.member_tel}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="uaddress" class="col-sm-3 col-form-label">Address</label>
                                <div class="col-sm-7">
                                  <input type="text" class="form-control" id="u_address" name="u_address" value="${member.member_address}">
                                </div>
                            </div>
                        </form>
                        <div class="row mt-5">
                            <div class="col d-flex justify-content-end">
                                <button class="white_button w-70" onclick="goMyPage('${contextPath}')">
                                    <span class="eng_h1">Back</span>
                                </button>
                            </div>
                            <div class="col">
                                <button class="black_button w-70" onclick="goMyPageWithSendData()">
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
    <script src="${resources}/js/edit-my-info.js"></script>

</body>
</html>