<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
body {
	height: 100%;
	background-color: #fad4c0;
}

.navbar-custom {
	background-color: #FE5F55;
}
.center {
  margin: auto;
  width: 60%;
  padding: 105px;
  margin-left:440px
}
h5{
 font-family: "Lucida Console", Courier, monospace;
}
</style>
</head>
<body>
	<nav class="navbar navbar-custom">

	<div class="container">

		<img src="ProjectImages/redbuslogo.png"
			style="height: 60px; width: 60px;">


		<ul class="nav">
			<li class="nav-item"><a href="Logout.jsp" class="btn btn-danger">Logout</a></li>

		</ul>
	</div>
	</nav>
	<div class="center">
	<img src="ProjectImages/MyProfile.jpg" alt="myProfile" height=250px class="rounded-circle"><br><br>
		<c:forEach var="obj" items="${userDetails}">
		<h5>Name : <c:out value="${obj.name}"></c:out><br>
		Email : <c:out value="${obj.email}"></c:out><br>
		Age : <c:out value="${obj.age}"></c:out><br>
		Phone Number : <c:out value="${obj.phonenumber}"></c:out></h5>
		</c:forEach>
		
	</div>
</body>
</html>