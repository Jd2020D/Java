<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="css/dateStyle.css">
	<script type="text/javascript" src="js/dateJs.js"></script>
</head>
<body>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<center>
<h1><c:out value="${date}"/></h1>
</center>
</body>
</html>