<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>${cat.name } </h1>
<h2>Products:</h2>
<ul>
<c:forEach items="${cat.products}" var="pro">
<li>${pro.name }</li>
</c:forEach>
</ul>
<form:form action="/categories/${cat.id }" method="post" modelAttribute="categoryProduct">
    <p>
        <form:label path="product">Add Product :</form:label>
        <form:errors path="product"/>
        <form:select path="product">
       		<c:forEach items="${othersProducts}" var="p">
       			<form:option  value="${p.id}">${p.name}</form:option>
        	</c:forEach>
        </form:select>
    </p>
    <p>
        <form:errors path="category"/>
        <form:input type="hidden" value="${cat.id}" path="category"/>
    </p>

    <input type="submit" value="Add"/>
</form:form>    

</body>
</html>