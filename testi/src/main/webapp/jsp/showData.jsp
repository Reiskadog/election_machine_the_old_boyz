<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			      	<th scope="col">Question</th>
    			</tr>
  			</thead>
  			<tbody>
				<c:forEach var="ListedData" items="${requestScope.dataList}" >
					<tr>
						<th scope="row">${ListedData.id}</th>
						<td>${ListedData.data}</td> 
						<td><a href='/delete?id=${ListedData.id}'>delete</a></td> 
						<td><a href='/readtoupdate?id=${ListedData.id}'>update</a></td>
					</tr>
				</c:forEach>
  			</tbody>
		</table>
		<a href='/jsp/addToDatabase.jsp'> Add to database</a>
	</div>
</div>

</body>
</html>