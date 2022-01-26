<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">

<link rel="icon" href="Favicon.png">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Registration Page</title>
</head>
<body>
	<main class="my-form">
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


	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Register</div>
					<div class="card-body">
						<form name="my-form" onsubmit="return validform()"
							action="index.jsp" method="">
							<div class="form-group row">
								<label for="user_name"
									class="col-md-4 col-form-label text-md-right">User Name</label>
								<div class="col-md-6">
									<input type="text" id="user_name" class="form-control"
										name="username">
								</div>
							</div>

							<div class="form-group row">
								<label for="email" class="col-md-4 col-form-label text-md-right">Email</label>
								<div class="col-md-6">
									<input type="text" id="email" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="password"
									class="col-md-4 col-form-label text-md-right">Password</label>
								<div class="col-md-6">
									<input type="text" id="password" class="form-control"
										name="password">
								</div>
							</div>
							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">Register
								</button>
							</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Registration.js"></script>
</body>
</html>