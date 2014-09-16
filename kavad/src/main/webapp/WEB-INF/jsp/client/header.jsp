<%@ include file="include.jsp"%>
<html>
<head>
<title>Kavad</title>
<link
	href="<c:url value="/resources/style/style.css" />"
	rel="stylesheet"
	type="text/css"
/>
<link
	href="<c:url value="/resources/javascript/anytime.css" />"
	rel="stylesheet"
	type="text/css"
/>
<script
	type="text/javascript"
	src="<c:url value='/resources/javascript/jquery-1.6.4.js' />"
></script>
<script
	type="text/javascript"
	src="<c:url value='/resources/javascript/anytime.js' />"
></script>
<script
	type="text/javascript"
	src="<c:url value='/resources/javascript/init.js' />"
></script>
</head>
<body>
<div id="userInfo" class="userInfo" >
<sec:authorize access="isAuthenticated()">
Tere, <sec:authentication property="principal.username"/> - <a href="<c:url value='/logout' /> " >Logi välja</a>
</sec:authorize>
</div>