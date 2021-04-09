<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="data.ListedData" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
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
</body>
</html>