<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | Add Session</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<!-- VAR -->
				<a href="<c:url value='/session/list'/>"><button
						class="btn btn-success mb-2">
						<i class="fa fa-arrow-left"></i> Retour
					</button></a>
				<c:url value='/session/addItem' var="addURL" />
				<form:form method="post" action="${addURL}" modelAttribute="session">
					<div class="form-group">
						<label for="stime">Début</label> <input type="time"
							class="form-control" id="stime" placeholder="Libelle"
							name="startTime" required>
					</div>
					<div class="form-group">
						<label for="etime">Fin</label> <input type="time"
							class="form-control" id="etime" placeholder="Libelle"
							name="endTime" required>
					</div>
					<div class="form-group">
						<label for="wday">Jour</label> <select class="form-control"
							id="wday" name="day">
							<c:forEach items="${days}" var="v">
								<option value="${v}">${v}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-secondary">Ajouter</button>
				</form:form>
				<!-- /VAR -->
			</div>
		</div>
	</div>
	<%@include file="../includes/js.jsp"%>
	<%@include file="../includes/logout.jsp"%>
</body>
</html>
