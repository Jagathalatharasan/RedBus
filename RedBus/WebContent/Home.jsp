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
#map {
	height: 400px;
	width: 100%;
}

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
	<h3 style="text-align: right">
		Welcome
		<%=session.getAttribute("n")%></h3>
	<br>
	<form action="RedBusServlet" method="post">
		<div class="conatiner">
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From
			&nbsp;&nbsp;&nbsp;&nbsp; <select name="from">
				<c:forEach var="obj" items="${cList}">
					<option>${obj}</option>
				</c:forEach>


			</select>


			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			To &nbsp;&nbsp;&nbsp;&nbsp; <select name="to">
				<c:forEach var="obj" items="${cList}">
					<option>${obj}</option>
				</c:forEach>


			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				class="btn btn-primary" value="Book Ticket" name="bt">
		</div>
		<br> <br>
		<div class="container">
			Position &nbsp;&nbsp;&nbsp;&nbsp; <select name="position"
				id="position">
				<option>Select City</option>
				<c:forEach var="obj" items="${cList}">
					<option>${obj}</option>
				</c:forEach>


			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				class="btn btn-primary" value="Locate" name="bt" />
		</div>
		<br> <br>
		<div class="container">
			<div id="map"></div>

			<script type="text/javascript">
				function initMap() {

					var location = document.getElementById("city").value
							.toUpperCase();

					console.log(location);

					if (location == "CHENNAI") {
						var coordinates = {
							lat : 13.0827,
							lng : 80.2707
						};
					} else if (location == "BANGLORE") {
						var coordinates = {
							lat : 12.9716,
							lng : 77.5946
						};
					} else if (location == "HYDERABAD") {
						var coordinates = {
							lat : 17.3850,
							lng : 78.4867
						};
					} else if (location == "KOCHI") {
						var coordinates = {
							lat : 9.9312,
							lng : 76.2673
						};
					} else if (location == "MUMBAI") {
						var coordinates = {
							lat : 19.0760,
							lng : 72.8777
						};
					} else if (location == "VIZAG") {
						var coordinates = {
							lat : 17.6868,
							lng : 83.2185
						};
					} else {
						var coordinates = {
							lat : 20.5937,
							lng : 78.9629
						};
					}

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 7,
						center : coordinates
					});

					var marker = new google.maps.Marker({
						position : coordinates,
						map : map
					});
					var infowindow = new google.maps.InfoWindow({
						content : "Hello ${city}"
					});

					infowindow.open(map, marker);
				}
			</script>

			<script async defer
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCC4UktmznnXlQpaiTx6HSLkuvdq9255E&callback=initMap">
				
			</script>
			<input type="hidden" id="city" value="${city}" /> <br> <br>
			<br> <br>
		</div>

	</form>
	<br>


</body>
</html>