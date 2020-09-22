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
</style>
</head>
<body>
	<nav class="navbar navbar-custom">

	<div class="container">

		<img src="ProjectImages/redbuslogo.png"
			style="height: 60px; width: 60px;">


		<ul class="nav">
			<li class="nav-item"><form action="RedBusServlet" method="post">
					<input type="submit" class="btn btn-primary" name="bt" value="My Profile">
				</form></li>&nbsp;
			<li class="nav-item"><a href="Logout.jsp" class="btn btn-danger">Logout</a></li>

		</ul>
	</div>


	</nav>
	<br>
	<div class="container">
		<center>
			<h4>
				From :&nbsp;&nbsp;<%=session.getAttribute("from")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				To :&nbsp;&nbsp;<%=session.getAttribute("to")%></h4>
		</center>
	</div>
	<br>
	<br>
	<form action="RedBusServlet" method="post">
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Gender</th>

				<th>Age</th>
				<th>Category</th>
			</tr>
			<c:forEach var="obj" items="${plist}" varStatus="st">

				<tr>
					<td>${obj.getName()}</td>
					<td>${obj.getGender()}</td>
					<td>${obj.getAge()}</td>
					<td>${obj.getCategory()}</td>



				</tr>
			</c:forEach>
		</table>
		<br><br>
		<center>
			<h2 name="tp">Total Price: ${totalprice}</h2>
			<br> <br> <input type="submit" class="btn btn-primary"
				value="Make Payment" name="bt"> <br> <br>
		</center>

	</form>

</body>
</html>