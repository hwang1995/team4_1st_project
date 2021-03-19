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
<link rel="stylesheet" href="${resources}/css/layout/main_layout.css">

<title>Team4 - QnA 전송 결과 페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragments/header.jsp" />



	<section>
		<h1>Qna  전송 결과 페이지를 작성하자.</h1>
	</section>

	<jsp:include page="/WEB-INF/views/fragments/footer.jsp" />
	

	<!-- jQuery DOM 조작 관련된 JS -->
	<script src="${resources}/js/common.js"></script>

</body>
</html>