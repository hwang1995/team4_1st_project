<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<c:set var="resources" value="${contextPath}/resources"></c:set>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="${pageContext.request.contextPath}/resources/images/main/mainlogo.png">
	Go
</a>
<P>  The time on the server is ${serverTime}. </P>
${contextPath} &nbsp; 
${resources}
<p>
	
</p>
</body>
</html>
