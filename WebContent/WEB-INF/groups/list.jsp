<%@page import="tn.api.omar.entities.Groups"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../includes/css.jsp"%>
<title>SGA | List Groups</title>
</head>
<body>
	<%@include file="../includes/sidebar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10 mt-5">
				<a href="<c:url value='/groups/add'/>"><button
						class="btn btn-success mb-2">
						Ajouter <i class="fa fa-plus"></i>
					</button></a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Année</th>
							<th scope="col">E-mail</th>
							<th scope="col">Spécialité</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item" varStatus="status">
							<tr>
								<th scope="row">${item.gnumber}</th>
								<td>${item.gyear}</td>
								<td>${item.gmail}</td>
								<% Integer gid = ((Groups)pageContext.findAttribute("item")).getGid(); %>
								<td><%= request.getAttribute("gspname"+gid) %></td>
								<td><a href="<c:url value='/groups/edit/${item.gid}'/>"><i
										class="fa fa-edit text-secondary"></i></a></td>
								<td><a href="<c:url value='/groups/delete/${item.gid}'/>"><i
										class="fa fa-trash text-danger"></i></a></td>
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