<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<h1>New Question</h1>
<form:form action="/questions/new" method="post" modelAttribute="newQuestion">
    <p>
        <form:label path="question">Question :</form:label>
        <form:errors path="question"/>
        <form:input path="question"/>
    </p>
    <p>
        <form:label path="tags">Tags :</form:label>
        <form:errors path="tags"/>
        <form:input path="tags"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>