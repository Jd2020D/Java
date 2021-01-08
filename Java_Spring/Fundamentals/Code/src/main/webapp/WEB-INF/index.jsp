<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<link rel="stylesheet" type="text/css" href="css/code.css">
		<title>Secret Code</title>
	</head>
	<body>
		<p id="error"><c:out value="${error}"/></p>
		<form action="/try" method="POST">
			<input type="text" name="code" id="code" />
			<input type="submit" value="Try Code"></input>
		</form>
	</body>
</html>