<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to Question database</title>
</head>
<body>
<h2>Add to Question database jsp</h2>
<form action="/AddToDatabase" method="post" name="question">
	  <label for="fname">ID</label><br>
	  <input type="text"  name="idValue" value="id"><br>
	  <label for="lname">Question</label><br>
	  <input type="text"  name="qValue" value="question"><br><br>
	  <input type="submit" value="Submit">
	  </form>
</body>
</html>