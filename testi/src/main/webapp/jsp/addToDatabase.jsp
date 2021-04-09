<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to database</title>
</head>
<body>
<h2>Add to database jsp</h2>
<form action="/AddToDatabase" method="post">
	  <label for="fname">ID</label><br>
	  <input type="text"  name="idValue" value="id"><br>
	  <label for="lname">Question</label><br>
	  <input type="text"  name="qValue" value="question"><br><br>
	  <input type="submit" value="Submit">
	  </form>
</body>
</html>