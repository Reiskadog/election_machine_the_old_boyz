<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<title>Election machine the old boyz</title>
	</head>
	<body>
		<div class="jumbotron text-center">
			<h1>Election Machine</h1>
		</div>
		<div class="container">
			<h2>Add an Electee</h2>
			<form action="/addToDatabase" method="post">
				<div class="form-group">
	    			<label for="id">ID</label>
	  				<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="ID" name="idValue">
  				</div>
  				<div class="form-group">
	    			<label for="fname">First Name</label>
	  				<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="First name" name="fName">
  				</div>
  				<div class="form-group">
	    			<label for="flname">Last Name</label>
	  				<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Last name" name="lName">
  				</div>
  				<button type="submit" class="btn btn-primary">Submit</button>
  			</form>
		</div>
	</body>
</html>