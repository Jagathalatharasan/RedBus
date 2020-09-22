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
	<center>
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#Addpassenger">Add Passenger</button>
	</center>
	<br>
	<br>
	<center>
		<h1>Passenger Details</h1>
	</center>
	<div class="modal" id="Addpassenger">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter Details</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="RedBusServlet" method="post">


						<div class="form-group">
							Enter Name : <input type="text" name="t1" class="form-control">

						</div>
						<div class="form-group">
							Enter Age: <input type="number" name="t2" class="form-control">
						</div>

						<div class="form-group">
							Enter Gender: &nbsp;&nbsp;&nbsp;<input type="radio" name="t4"
								value="Male"> <label for="male">Male</label>
							&nbsp;&nbsp;<input type="radio" name="t4" value="Female">
							<label for="female">Female</label>
						</div>
						<div class="form-group">
							Enter Category: &nbsp;&nbsp;&nbsp<input type="radio" name="t5"
								value="Express"> <label for="Express">Express</label>

							&nbsp;&nbsp;<input type="radio" name="t5" value="Superluxury">
							<label for="Superluxury">Super-Luxury</label>
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">

					<input type="submit" value="Add" name="bt" />
				</div>

				</form>

			</div>
		</div>
	</div>

	<table class="table">
		<tr>
			<th>ID</th>

			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Category</th>



		</tr>
		<c:forEach var="obj" items="${plist}">

			<tr>
				<td>${obj.id}</td>

				<td class="name">${obj.getName()}</td>
				<td>${obj.getGender()}</td>
				<td>${obj.getAge()}</td>
				<td>${obj.getCategory()}</td>



			</tr>





		</c:forEach>
	</table>
	<br>
	<br>
	<center>
		<form action="RedBusServlet" method="post">
			<input type="submit" value="Proceed to Payment" name="bt"
				class="btn btn-primary">
		</form>
	</center>





</body>
</html>