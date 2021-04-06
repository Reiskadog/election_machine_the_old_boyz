<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
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

<%
ArrayList<ListedData> dataList=(ArrayList<ListedData>)request.getAttribute("dataList");

for (int i=0;dataList!=null && i<dataList.size();i++){
	ListedData f=dataList.get(i);
	out.println(f.getId()+": "+f.getData()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>

<%@ include file="../html/something.html" %>



</body>
</html>