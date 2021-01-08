<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dojo Survey</title>
	</head>
	<body>
		<form action="/submit" method="post">
			<table>
				<tr>
					<td><label for="name">Your Name:</label></td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td><label for="dojo">Dojo Location:</label></td>
					<td>
						<select name="dojo" id="dojo">
							<option value="San Jose">San Jose</option>
							<option value="Bellevue">Bellevue</option>
							<option value="San Francisco">San Francisco</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="lang">Favorite Language:</label></td>
					<td>
						<select name="lang" id="lang">
							<option value="Python">Python</option>
							<option value="Java">Java</option>
							<option value="JavaScript">JavaScript</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="comment">Comment (optional):</label></td>
				</tr>
				<tr>
					<td><textarea name="comment" id="comment" cols="30" rows="10"></textarea></td>
				</tr>
			</table>
			<button>Submit</button>
		</form>
	</body>
</html>