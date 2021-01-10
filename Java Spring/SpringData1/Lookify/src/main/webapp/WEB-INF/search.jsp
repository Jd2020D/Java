<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<main>
 <form class="none" action="/search" method="post">
 	<p>Songs by artist: ${artist}</p>
 	<input type="text" value="${artist}" name="artist">
    <input type="submit" value="New Search">
</form>
<a href="/dashboard">Dashboard</a>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>rating</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><form class="none" action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="delete">
</form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	
</main>

</body>
</html>