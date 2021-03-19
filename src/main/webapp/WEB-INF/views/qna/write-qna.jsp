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
			<div class="container mt-3 mb-3 pt-3">
				<!-- Q&A 헤더 구현  -->
				<div class="qna_header">
					<h2 class="eng_h2 mb-2">Q&A</h2>
					<hr class="bold_divider" />
					<h6 class="eng_h3 mb-1">고객센터는 전화/Q&A E-mail로 운영되고 있습니다.</h6>
					<h6 class="eng_h3 mb-1">Q&A 작성 시 해당 답변은 가입하신 이메일로 발송됩니다.</h6>
					<hr class="bold_divider" />
				</div>
				
				<!-- Q&A 컨텐츠 구현 -->
				<div class="qna_content_area mt-5">
					<div class="row">
						<div class="col d-flex flex-column ">
							<h5 class="eng_h2">Category</h5>
							<select name="category_select" id="category_select" class="mt-4 qna_select_area_container pl-2">
								<option value="products">상품 문의</option>
								<option value="delivery">배송 문의</option>
								<option value="exchange">교환 문의</option>
								<option value="etc">기타 문의</option>
							</select>
							
						</div>
						<div class="col d-flex flex-column">
							<h5 class="eng_h2">Title</h5>
							<input type="text" id="title" name="title" class="mt-4 qna_input_area_container pl-2" />
						</div>
					</div>
					
					<div class="row mt-5">
						<div class="col d-flex flex-column">
							<h5 class="eng_h2 mb-1">Content</h5>
							<textarea name="content_area" id="content_area" class="mt-2 qna_textarea_container"></textarea>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col d-flex flex-row-reverse">
							<button class="black_button w-30" onclick="getQnaData('${contextPath}')">
								<h5 class="eng_h2">SEND</h5>
							</button>
						</div>
					</div>
				</div>
			</div>
		</article>
    </section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	

	<!-- jQuery DOM 조작 관련된 JS -->
	<script src="${resources}/js/common.js"></script>
	<script src="${resources}/js/write_qna.js"></script>

</body>
</html>