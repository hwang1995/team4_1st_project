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
<link rel="stylesheet" href="${resources}/css/layout/write-qna_layout.css">

<title>Team4 - QnA 페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />



	<section>
        <article>
            <div class="container-sm write_qna_container">
	            <div class="row">
	            	<div class="col-2"></div>
	            	<h3 class="eng-h1 mb-2">Q&A</h3>
	            </div>
	            <div class="write_qna_top_bottom mt-2 p-3">
	            	<div class="row">
	            		<div class="col-2"></div>
	            		<p>고객센터는 전화/Q&A E-mail로 운영되고 있습니다.</p>
	            	</div>
	            	<div class="row">
	            		<div class="col-2"></div>
	                	<p>Q&A 작성 시 해당 답변은 가입하신 이메일로 발송됩니다.</p>
	            	</div>
	            </div>
	            <div class="row mt-5">
	            	<div class="col-2"></div>
	            	<div class="col-4">
	            		<label class="col-sm-2 col-form-label">Title</label>
	            		<div>
	            		<select class="write_qna_box" name="title" id="title_select" style="width : 12rem;">
                            <option selected disabled hidden>제목을 선택하세요.</option>
                            <option value="kukmin">상품문의</option>
                            <option value="sinhan">배송문의</option>
                            <option value="nonghyeop">교환문의</option>
                            <option value="uri">기타문의</option>
                        </select>
                        </div>
	            	</div>
	            	<div class="col-4">
		            	<label for="uname" class="col-sm-2 col-form-label">Name</label>
	                    <div class="col-sm-5">
	                        <input type="text" class="form-control" id="uname" name="uname" style="width : 12rem;">
	                    </div>
	            	</div>
	            	<div class="col-2"></div>
	            </div>
	            <div class="row mt-5">
	            	<div class="col-2"></div>
	            	<div class="col-10">
		            	<label for="ucontent" class="col-sm-2 col-form-label">Content</label>
	                    <div>
	                        <input type="text" class="form-control write_qna_contentbox" id="ucontent" name="ucontent">
	                    </div>
	            	</div>
	            </div>
	            <div class="row mt-5 mb-5">
	                <div class="col-11 d-flex justify-content-end">
		                <button class="black_button w-25">
		                  <a href="${contextPath}/qna/qna-sended">
		                    <span class="h6 white_text">Send</span>
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