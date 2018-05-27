<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | Edit CourseSession</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<!-- VAR -->
				<a href="<c:url value='/courseSession/list'/>"><button class="btn btn-success mb-2"><i class="fa fa-arrow-left"></i> Retour</button></a>
				<c:url value='/courseSession/editItem' var="editURL" />
				<form:form method="post" action="${editURL}"
					modelAttribute="courseSession">
					<div class="form-group">
						<label for="prof">Enseignant</label> <select class="form-control"
							id="prof" name="pid">
							<c:forEach items="${profs}" var="prof">
								<c:set var="selected" value="${prof.pid eq item.csid.pid}"></c:set>
								<c:if test="${selected}">
									<option value="${prof.pid}" selected>${prof.pfname} ${prof.plname}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${prof.pid}">${prof.pfname} ${prof.plname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="grps">Groupe</label> <select class="form-control"
							id="grps" name="gid">
							<c:forEach items="${grps}" var="grp">
								<c:set var="selected" value="${grp.gid eq item.csid.gid}"></c:set>
								<c:if test="${selected}">
									<option value="${grp.gid}" selected>${grp.gmail}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${grp.gid}">${grp.gmail}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="crms">Salle de cours</label> <select class="form-control"
							id="crms" name="crid">
							<c:forEach items="${crms}" var="crm">
								<c:set var="selected" value="${crm.crid eq item.csid.crid}"></c:set>
								<c:if test="${selected}">
									<option value="${crm.crid}" selected>${crm.crname}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${crm.crid}">${crm.crname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="spec">Session</label> <select class="form-control"
							id="spec" name="sid">
							<c:forEach items="${sess}" var="v">
								<c:set var="selected" value="${v.sid eq item.csid.sid}"></c:set>
								<c:if test="${selected}">
									<option value="${v.sid}" selected>${v.day}: ${v.startTime} -> ${v.endTime}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${v.sid}">${v.day}: ${v.startTime} -> ${v.endTime}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="subs">Matiére</label> <select class="form-control"
							id="subs" name="subid">
							<c:forEach items="${subs}" var="sub">
								<c:set var="selected" value="${sub.subid eq item.subid}"></c:set>
								<c:if test="${selected}">
									<option value="${sub.subid}" selected>${sub.subname}</option>
								</c:if>
								<c:if test="${not selected}">
									<option value="${sub.subid}">${sub.subname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-secondary">Modifier</button>
					<input type="hidden" name="pid" value="${item.csid.pid}">
					
				</form:form>
				<!-- /VAR -->
			</div>
		</div>
	</div>
	<%@include file="../includes/js.jsp"%>
	<%@include file="../includes/logout.jsp"%>
</body>
</html>

