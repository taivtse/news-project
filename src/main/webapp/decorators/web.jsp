<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><dec:title default="Trang chủ" /></title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@include file="/common/web/header.jsp"%>

	<!-- Page Content -->
	<div class="container">
		<dec:body />
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</body>

</html>
