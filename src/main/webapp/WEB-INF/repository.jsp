<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Projects/Repositories</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
table{
	margin-top:5%;
	border:2px;
	width:50%;
	margin-left:25%;
}
</style>
<body style="text-align:center">


<c:choose>
  <c:when test="${repo.id != null}">    
	<h1><i class="fa fa-github fa5x"> Git Hub Repositories</h1>
	<c:forEach var="repo" items="${repository}">
		<table border=2>
			<tr>
				<td colspan=2><b>${repo.name}</b></td>
			</tr>
			<tr>
				<td>ID</td>
				<td>${repo.id}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${repo.description}</td>
			</tr>
			<tr>
				<td>Created On</td>
				<td>${repo.created_at}</td>
			</tr>
			<tr>
				<td>Updated On</td>
				<td>${repo.updated_at}</td>
			</tr>
			<tr>
				<td><i class="fa fa-github fa2x"></i></td>
				<td><a href="${repo.html_url}">${repo.html_url}</a></td>
			</tr>
		</table>
	</c:forEach>
  </c:when>
  <c:otherwise>     
	<div class="col-md-6">
		<div class="card">
		  <h1>No Github Repository Found</h1>
		</div>
	</div>
  </c:otherwise>
</c:choose>

<c:choose>
  <c:when test="${pro.id != null}">    
	<h1><i class="fa fa-gitlab fa5x"></i> Git Lab Repositories</h1>
	
	<c:forEach var="pro" items="${project}">
		<table border=2>
			<tr>
				<td colspan=2><strong>${pro.name}</strong></td>
			</tr>
			<tr>
				<td>ID</td>
				<td>${pro.id}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${pro.description}</td>
			</tr>
			<tr>
				<td>Created On</td>
				<td>${pro.created_at}</td>
			</tr>
			<tr>
				<td>Updated On</td>
				<td>${pro.updated_at}</td>
			</tr>
			<tr>
				<td><i class="fa fa-gitlab fa2x"></i></td>
				<td><a href="${pro.html_url}">${pro.html_url}</td>
			</tr>
		</table>
	</c:forEach>
  </c:when>
  <c:otherwise>     
	<div class="col-md-6">
		<div class="card">
		  <h1>No GitLab Project Found</h1>
		</div>
	</div>
  </c:otherwise>
</c:choose>









	

</body>
</html>