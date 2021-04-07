<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database application</title>
</head>
<body>
<h2>Database application jsp</h2>
<ol>
<c:forEach var="ListedData" items="${requestScope.dataList}" >
<li>${ListedData.id}: ${ListedData.data} <a href='/delete?id=${ListedData.id}'>delete</a> <a href='/readtoupdate?id=${ListedData.id}'>update</a>
</c:forEach>
</ol>
<form action="/showDatabase" method="post">
	  <label for="fname">ID</label><br>
	  <input type="text"  name="idValue" value="id"><br>
	  <label for="lname">Question</label><br>
	  <input type="text"  name="qValue" value="question"><br><br>
	  <input type="submit" value="Submit">
</form>
</body>
</html>