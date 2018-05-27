<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | Edit Speciality ${item.spname}</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<!-- VAR -->
				<a href="<c:url value='/speciality/list'/>"><button class="btn btn-success mb-2"><i class="fa fa-arrow-left"></i> Retour</button></a>
				<c:url value='/speciality/editItem' var="editURL" />
				<form:form method="post" action="${editURL}"
					modelAttribute="speciality">
					<div class="form-group">
						<label for="spname">Libelle</label> <input type="text"
							class="form-control" id="spname" placeholder="Libelle"
							name="spname" value="${item.spname}" required>
					</div>
					<button type="submit" class="btn btn-secondary">Modifier</button>
					<input type="hidden" name="spid" value="${item.spid}" required>
				</form:form>
				<!-- /VAR -->
			</div>
		</div>
	</div>
	<%@include file="../includes/js.jsp"%>
	<%@include file="../includes/logout.jsp"%>
</body>
</html>

