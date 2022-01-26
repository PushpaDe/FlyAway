<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#Source').autocomplete({
			source ''
			});
		});
	</script>
<title>User Dashboard</title>
</head>
<body>
	<form method="post" style="background-color: #FFE4E1"
		action="userDetails">
		<nav class="navbar navbar-dark" style="background-color: #C71585">
			<div class="container-fluid">
				<div class="navbar-header">
					<h1 class="font-weight-bold font-italic"
						style="width: 13rem; color: #DAA520">
						<b>FLYAWAY</b>
					</h1>
				</div>
				<ul class="nav navbar-nav" style="color: #000000">
					<li class="active"><a href="#"><b>Home</b></a></li>
					<li class="active"><a href="#"><b>Book</b></a></li>
					<li><a href="#"><b>Manage</b></a></li>
					<li><a href="#"><b>Experience</b></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right" style="color: #000000">
					<li><a href="Registration.jsp"><span
							class="glyphicon glyphicon-user"></span><b>Sign Up</b></a></li>
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in"></span><b>Login</b></a></li>
				</ul>
			</div>
		</nav>
		<div>
			<h1>
				<b>Flights Available</b>
			</h1>
			<br>
		</div>
		<table border="1" width="500" align="center">
			<tr bgcolor="00FF7F">
				<th width="50">    </th>
				<th><b>Departure Time</b></th>
				<th><b>Arrival Time</b></th>
				<th><b>Airline Name</b></th>
			</tr>
			<%ArrayList<Map<String, Object>> flightDetails=(ArrayList<Map<String, Object>>)request.getAttribute("data");
        		int id=100;	
        for (Map<String, Object> map : flightDetails){%>
        <tr>
        		<td><input type=radio id=rd name=rdname align="center">></td>
				<%for (Map.Entry<String, Object> entry : map.entrySet()){%>
				<td><%=entry.getValue()%></td>
				<%}%>
				</tr>
			<%}%>
		</table>
		<div>
			<button align="center">Book Now</button>
		</div>
	</form>
</body>
</html>