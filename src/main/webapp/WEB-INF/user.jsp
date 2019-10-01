<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searched User List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.row{
  margin-top:10%;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}
</style>
</head>
<body>
<div class="row">
<c:choose>
  <c:when test="${github.id != null}">    
	<div class="col-md-6">
		<div class="card">
		  <img src="${github.avatar_url}" alt="John" style="width:100%">
		  <h1>${github.name}</h1>
		  <p class="title">${github.username}</p>
		  <p class="title">${github.id}</p>
		  <div style="margin: 24px 0;">
		    <a href="${github.web_url}"><i class="fa fa-github fa5x"></i></a>   </div>
		  <p><a href="${contextRoot}/${github.username}/repo">View Repository</a></p>
		</div>
	</div>
  </c:when>
  <c:otherwise>     
	<div class="col-md-6">
		<div class="card">
		  <h1>No GitHub User Found</h1>
		</div>
	</div>
  </c:otherwise>
</c:choose>

<c:choose>
  <c:when test="${gitlab.id != null}">    
	<div class="col-md-6">
		<div class="card">
		  <img src="${gitlab.avatar_url}" alt="John" style="width:100%">
		  <h1>${gitlab.name}</h1>
		  <p class="title">${gitlab.username}</p>
		  <p class="title">${gitlab.id}</p>
		  <div style="margin: 24px 0;">
		    <a href="${gitlab.web_url}"><i class="fa fa-github fa5x"></i></a>   </div>
		  <p>
		  <a href="${contextRoot}/${gitlab.username}/repo">View Project</a></p>
		</div>
	</div>
  </c:when>
  <c:otherwise>     
	<div class="col-md-6">
		<div class="card">
		  <h1>No GitLab User Found</h1>
		</div>
	</div>
  </c:otherwise>
</c:choose>
</div>





</body>
</html>