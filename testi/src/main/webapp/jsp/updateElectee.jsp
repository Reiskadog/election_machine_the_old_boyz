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
		<h2>Edit electee</h2>
		<form action="/update" method="post">
			<div class="form-group">
	   			<label for="id">ID</label>
	 			<input type="text" class="form-control" id="exampleFormControlInput1" value='${requestScope.dataList.id}' readonly name="idValue">
  			</div>
  			<div class="form-group">
	   			<label for="fname">First name</label>
	 			<input type="text" class="form-control" id="exampleFormControlInput1" value='${requestScope.dataList.fName}' name="fName">
  			</div>
  			<div class="form-group">
	   			<label for="lname">Last name</label>
	 			<input type="text" class="form-control" id="exampleFormControlInput1" value='${requestScope.dataList.lName}' name="lName">
  			</div>
  			<button type="submit" class="btn btn-primary">Submit</button>
  		</form>
	</div>
</body>
</html>