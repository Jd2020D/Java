<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>${pro.name } </h1>
<h2>Categories:</h2>
<ul>
<c:forEach items="${pro.categories }" var="cat">
<li>${cat.name }</li>
</c:forEach>
</ul>
<form:form action="/products/${pro.id }" method="post" modelAttribute="categoryProduct">
    <p>
        <form:label path="category">Add Category :</form:label>
        <form:errors path="category"/>
        <form:select path="category">
       		<c:forEach items="${othersCats}" var="c">
       			<form:option  value="${c.id}">${c.name}</form:option>
        	</c:forEach>
        </form:select>
    </p>
    <p>
        <form:errors path="product"/>
        <form:input type="hidden" value="${pro.id}" path="product"/>
    </p>

    <input type="submit" value="Add"/>
</form:form>    

</body>
</html>