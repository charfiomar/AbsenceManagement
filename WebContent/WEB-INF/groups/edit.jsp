<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | Edit Group</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<!-- VAR -->
				<a href="<c:url value='/groups/list'/>"><button class="btn btn-success mb-2"><i class="fa fa-arrow-left"></i> Retour</button></a>
				<c:url value='/groups/editItem' var="editURL" />
				<form:form method="post" action="${editURL}"
					modelAttribute="groups">
					<div class="form-group">
						<label for="num">Numéro</label> <input type="number"
							class="form-control" id="num" placeholder="Number"
							name="gnumber" value="${item.gnumber}" required>
					</div>
					<div class="form-group">
						<label for="year">Année</label> <input type="number"
							class="form-control" id="year" placeholder="Year"
							name="gyear" value="${item.gyear}"  required>
					</div>
					<div class="form-group">
						<label for="mail">E-Mail</label> <input type="email"
							class="form-control" id="mail" placeholder="E-Mail"
							name="gmail" value="${item.gmail}"  required>
					</div>
					<div class="form-group">
						<label for="spec">Spécialité</label> <select class="form-control"
							id="spec" name="spid">
							<c:forEach items="${specs}" var="v">
								<c:set var="selected" value="${v.spid eq item.spid}"></c:set>
								<c:if test="${selected}">
									<option value="${v.spid}" selected>${v.spname}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${v.spid}">${v.spname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-secondary">Modifier</button>
					<input type="hidden" name="gid" value="${item.gid}" required>
				</form:form>
				<!-- /VAR -->
			</div>
		</div>
	</div>
	<%@include file="../includes/js.jsp"%>
	<%@include file="../includes/logout.jsp"%>
</body>
</html>

