<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>Questions Dashboard</h1>
<table>
  <tr>
    <th>Question</th>
    <th>Tags</th>
  </tr>
  <c:forEach items="${questions}" var="question">
  <tr>
  	<td><a href="/questions/${question.id}">${question.question}</a></td>
  	<td>
  	  <c:forEach items="${question.tags}" var="tag">
  		<span>${tag.subject},</span>
  	  </c:forEach>
  	</td>
  </tr>
  </c:forEach>
  
</table>
<a href='/questions/new'>New Question</a>
	
</body>
</html>