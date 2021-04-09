<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.QuestionData" %>  
 <%@ page import="data.ElecteeData" %>   
  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<<<<<<< Updated upstream
<meta charset="UTF-8">
<title>Database application jsp</title>
</head>
<body>
<h2>Database application jsp</h2>
<ol>
<c:forEach var="ListedData" items="${requestScope.dataList}" >
<li>${ListedData.id}: ${ListedData.data} <a href='/delete?id=${ListedData.id}'>delete</a> <a href='/readtoupdate?id=${ListedData.id}'>update</a>
</c:forEach>
</ol>
<a href='/jsp/addToDatabase.jsp'> Add to database</a>
=======
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Database application</title>
</head>
<body>
<div class="jumbotron text-center">
	<h2>Database application jsp</h2>
</div>

<div class="container">
	<div class="col-sm4">
		<table class="table">
  			<thead>
    			<tr>
			      	<th scope="col">ID</th>
			      	<th scope="col">Electee</th>
    			</tr>
  			</thead>
  			<tbody>
				<c:forEach var="ElecteeData" items="${requestScope.dataList2}" >
					<tr>
						<th scope="row">${ElecteeData.id}</th>
						<td>${ElecteeData.data}</td> 
						<td><a href='/delete?id=${ElecteeData.id}'>delete</a></td> 
						<td><a href='/readtoupdate?id=${ElecteeData.id}'>update</a></td>
					</tr>
				</c:forEach>
  			</tbody>
		</table>
		<a href='/jsp/addToDatabase.jsp'> Add to database</a>
	</div>
	
	<div class="col-sm4">
		<table class="table">
  			<thead>
    			<tr>
			      	<th scope="col">ID</th>
			      	<th scope="col">Question</th>
    			</tr>
  			</thead>
  			<tbody>
				<c:forEach var="QuestionData" items="${requestScope.dataList}" >
					<tr>
						<th scope="row">${QuestionData.id}</th>
						<td>${QuestionData.data}</td> 
						<td><a href='/delete?id=${QuestionData.id}'>delete</a></td> 
						<td><a href='/readtoupdate?id=${QuestionData.id}'>update</a></td>
					</tr>
				</c:forEach>
  			</tbody>
		</table>
		<a href='/jsp/addToDatabase.jsp'> Add to database</a>
	</div>
</div>

>>>>>>> Stashed changes
</body>
</html>