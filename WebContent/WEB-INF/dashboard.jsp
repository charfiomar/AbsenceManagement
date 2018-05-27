<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="includes/css.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css"
	type="text/css">
<title>Hello</title>
</head>
<body>
	<%@include file="includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<h1 class="text-center">Dashboard SGA</h1>
				<div class="ml-5 mb-5 mt-2" id='calendar'></div>
			</div>
		</div>
	</div>
	<%@include file="includes/js.jsp"%>
	<%@include file="includes/fullcalendar.js.jsp" %>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.1/moment.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js"></script>
</body>
</html>