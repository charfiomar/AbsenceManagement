<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | Add CourseSession</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<!-- VAR -->
				<a href="<c:url value='/courseSession/list'/>"><button class="btn btn-success mb-2"><i class="fa fa-arrow-left"></i> Retour</button></a>
				<c:url value='/courseSession/addItem' var="addURL" />
				<form:form method="post" action="${addURL}"
					modelAttribute="courseSession">
					<div class="form-group">
						<label for="prof">Enseignant</label> <select class="form-control"
							id="prof" name="pid">
							<c:forEach items="${profs}" var="prof">
								<option value="${prof.pid}">${prof.pfname} ${prof.plname}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="grps">Groupe</label> <select class="form-control"
							id="grps" name="gid">
							<c:forEach items="${grps}" var="grp">
								<option value="${grp.gid}">${grp.gmail}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="crms">Salle de cours</label> <select class="form-control"
							id="crms" name="crid">
							<c:forEach items="${crms}" var="crm">
								<option value="${crm.crid}">${crm.crname}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="spec">Session</label> <select class="form-control"
							id="spec" name="sid">
							<c:forEach items="${sess}" var="v">
								<option value="${v.sid}">${v.day}: ${v.startTime} -> ${v.endTime}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="subs">Matiére</label> <select class="form-control"
							id="subs" name="subid">
							<c:forEach items="${subs}" var="sub">
								<option value="${sub.subid}">${sub.subname}</option>
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

