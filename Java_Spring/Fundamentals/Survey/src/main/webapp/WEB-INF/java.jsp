<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Results</title>
	</head>
	<body>
		<h1>Java is the best Language Ever!!!</h1>
		<h3>Submitted Info</h3>
		<table>
			<tr>
				<td>Name:</td>
				<td><c:out value="${name}"/></td>
			</tr>
			<tr>
				<td>Dojo Location:</td>
				<td><c:out value="${dojo}"/></td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td><c:out value="${lang}"/></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><c:out value="${comment}"/></td>
			</tr>
		</table>
		<a href="/">Go Back</a>
	</body>
</html>