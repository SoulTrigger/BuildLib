<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="common/meta.jsp"%>
</head>

<body class="gray-bg top-navigation">
	<%@include file="common/header.jsp"%>
	<div class="wrapper wrapper-content animated fadeInRight" id="begin">
		<div class="container1">${access}</div>
	</div>
	<div class="wrapper wrapper-content animated fadeInRight" id="wait">
		<div class="spiner-example">
			<div class="sk-spinner sk-spinner-wandering-cubes">
				<div class="sk-cube1"></div>
				<div class="sk-cube2"></div>
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp"%>

	<!-- 自定义js -->
	<script src="assets/js/content.js?v=1.0.0"></script>
</body>
</html>