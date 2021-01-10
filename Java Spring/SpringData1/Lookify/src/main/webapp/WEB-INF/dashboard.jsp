<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<main>
<a href="songs/new">Add New</a>
<a href="search/topTen">Top Songs</a>
 <form class="none" action="/search" method="post">
 	<input type="text" name="artist">
    <input type="submit" value="Search Artist">
</form>

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