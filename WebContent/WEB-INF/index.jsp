<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="includes/css.jsp"%>
</head>
<body>
	<%@include file="includes/header.jsp"%>

	<div class="container sga-login">
		<div class="row align-items-center">
			<div class="col col-lg-12">
				<form class="form-signin" action="<c:url value='/login' />">
					<h2 class="form-signin-heading">Connectez-vous SVP</h2>
					<label for="inputEmail" class="sr-only">Adresse E-mail</label><input
						type="email" id="inputEmail" class="form-control"
						placeholder="Adresse E-mail" required autofocus name='username'>
					<label for="inputPassword" class="sr-only">Mot de passe</label><input
						type="password" id="inputPassword" class="form-control"
						placeholder="Mot de passe" required name='password'> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button class="btn btn-lg btn-dark btn-outline-secondary btn-block"
						type="submit">Se connecter</button>
				</form>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
	<%@include file="includes/js.jsp"%>
</body>
</html>