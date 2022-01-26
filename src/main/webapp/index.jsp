<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="com.flyaway.models.Cities" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
</head>
<body>
<form method="post" style="background-color:#FFE4E1" action="SearchFlight">
	<nav class="navbar navbar-dark" style="background-color:#C71585">
		<div class="container-fluid" >
			<div class="navbar-header">
				<h1 class="font-weight-bold font-italic" style="width: 13rem; color: #DAA520"><b>FLYAWAY</b></h1>
			</div>
			<ul class="nav navbar-nav" style="color:#000000">
				<li class="active"><a href="#"><b>Home</b></a></li>
				<li class="active"><a href="#"><b>Book</b></a></li>
				<li><a href="#"><b>Manage</b></a></li>
				<li><a href="#"><b>Experience</b></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" style="color: #000000">
      <li><a href="Registration.jsp"><span class="glyphicon glyphicon-user"></span><b>Sign Up</b></a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span><b>Login</b></a></li>
    </ul>
		</div>
	</nav>
	<br>
	<div class="container col-xl-10 col-xxl-8 px-4 py-5" style="background-color: #D2691E">
    <div class="row align-items-center g-lg-5 py-5">
      <div class="col-lg-7 text-center text-lg-start">
        <h1 class="display-4 fw-bold lh-1 mb-3 font-weight-bold" style="color:#000080"><b>Book Your Flight With Us</b></h1>
        <p class="col-lg-10 fs-4">Whether you're jetting off for pleasure or traveling for business, we offer flight to the best destinations</p>
      </div>
      <div class="col-md-10 mx-auto col-lg-5">
        <div class="p-4 p-md-5 border rounded-3 bg-light">
        <br>
          <div class="form-floating mb-3">
          <label for="floatingInput" class="font-weight-bold" style="color:#800080">From</label>
            <input type="text" class="form-control" name = "Source" id="Source" placeholder="">
            <!--   <input type="text" id="city" name="city" value="${country.getAttribute()}"/>-->
          </div>
          <div class="form-floating mb-3">
          <label for="floatingPassword" class="font-weight-bold" style="color:#800080">To</label>
           <input type="text" class="form-control" name = "Destination" id="Destination" placeholder="">
          </div>
          <div class="form-floating mb-3">
          <label for="floatingPassword" class="font-weight-bold" style="color:#800080">Travel Date</label>
            <input type="date" class="form-control" name = "Date" id="Date" placeholder="">
          </div>
          <div class="form-floating mb-3">
           <label for="floatingPassword" class="font-weight-bold" style="color:#800080">Passengers</label>
            <input type="text" class="form-control" name = "NoOfPeople" id="NoOfPeople" placeholder="">
          </div>
          <div class="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Search</button>
          
        </div>
        <br>
      </div>
    </div>
  </div>
</form>
<c:if test="${not empty errorMessage}">
   			<c:out value="${errorMessage}"/>
			</c:if>
<script>
		$("#country").autocomplete("");
	</script>
</body>
</html>
