<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html ng-app="gemStore">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"></script>
<script src="<c:url value="/resources/js/angularjs/angular.min.js" />"></script>
<script src="<c:url value="/resources/js/angularjs/angular-animate.min.js" />"></script>
<script src="<c:url value="/resources/js/angularjs/angular-cookies.min.js" />"></script>
<script src="<c:url value="/resources/js/angularjs/angular-resource.min.js" />"></script>
<script src="<c:url value="/resources/js/angularjs/angular-route.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/app/css/styles.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/app/js/app.js" />"></script>
<script src="<c:url value="/resources/app/js/services/app-service.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/products-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/product-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/cart-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/login-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/users-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/controllers/user-controller.js" />"></script>
<script src="<c:url value="/resources/app/js/directives/app-directives.js" />"></script>

<!-- <base href="/gemStore/"></base> -->
</head>

<body>
	<div class="container" id="wrap">
		<ng-view></ng-view>
	</div>
</body>

<%@ include file="footer.jsp" %>
</html>