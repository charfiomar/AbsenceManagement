<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | List CourseSession</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
			<a href="<c:url value='/courseSession/add'/>"><button class="btn btn-success mb-2">Ajouter <i class="fa fa-plus"></i></button></a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Enseignant</th>
							<th scope="col">Groupe</th>
							<th scope="col">Salle</th>
							<th scope="col">Séance</th>
							<th scope="col">Matière</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.pid}</td>
								<td>${item.gid}</td>
								<td>${item.crid}</td>
								<td>${item.sid}</td>
								<td>${item.subid}</td>
								<td><a href="<c:url value='/courseSession/edit/${item.pid}/${item.gid}/${item.crid}/${item.sid}'/>"><i class="fa fa-edit text-secondary"></i></a></td>
								<td><a href="<c:url value='/courseSession/delete/${item.pid}/${item.gid}/${item.crid}/${item.sid}'/>"><i class="fa fa-trash text-danger"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="../includes/js.jsp"%>
	<%@include file="../includes/logout.jsp"%>
</body>
</html>