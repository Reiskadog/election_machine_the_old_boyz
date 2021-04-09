<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to electee database</title>
</head>
<body>
<h2>Add to electee database jsp</h2>
<form action="/AddElecteeToDatabase" method="post">
	  <label for="fname">ID</label><br>
	  <input type="text"  name="idValue" value="id"><br>
	  <label for="lname">First name</label><br>
	  <input type="text"  name="fName" value="fName"><br><br>
	  <label for="lname">Last name</label><br>
	  <input type="text"  name="lName" value="lName"><br><br>
	  <input type="submit" value="Submit">
	  </form>
</body>
</html>