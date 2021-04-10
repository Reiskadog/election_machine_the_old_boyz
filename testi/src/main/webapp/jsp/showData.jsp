<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
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
	<div class="row">
		<div class="col-sm-6">
			<h2>Electees</h2>
			<table class="table">
	  			<thead>
	    			<tr>
				      	<th scope="col">ID</th>
				      	<th scope="col">First name</th>
						<th scope="col">Last name</th>
	    			</tr>
	  			</thead>
	  			<tbody>
					<c:forEach var="ElecteeData" items="${requestScope.dataList2}" >
						<tr>
							<th scope="row">${ElecteeData.id}</th>
							<td>${ElecteeData.fName}</td> 
							<td>${ElecteeData.lName}</td> 
							<td><a href='/delete?choice=e&id=${ElecteeData.id}'>delete</a></td> 
							<td><a href='/update?id=${ElecteeData.id}'>update</a></td>
						</tr>
					</c:forEach>
	  			</tbody>
			</table>
			<a href='/jsp/addElecteeToDatabase.jsp' class="btn btn-primary"> Add electee to database</a>
		</div>
		<div class="col-sm-6">
			<h2>Questions</h2>
			<table class="table">
	  			<thead>
	    			<tr>
				      	<th scope="col">ID</th>
				      	<th scope="col">Question</th>
	    			</tr>
	  			</thead>
	  			<tbody>
					<c:forEach var="ListedData" items="${requestScope.dataList}" >
						<tr>
							<th scope="row">${ListedData.id}</th>
							<td>${ListedData.data}</td> 
							<td><a href='/delete?choice=q&id=${ListedData.id}'>delete</a></td> 
						</tr>
					</c:forEach>
	  			</tbody>
			</table>
			<a href='/jsp/addQuestionToDatabase.jsp' class="btn btn-primary"> Add question to database</a>
		</div>
	</div>
</div>

</body>
</html>