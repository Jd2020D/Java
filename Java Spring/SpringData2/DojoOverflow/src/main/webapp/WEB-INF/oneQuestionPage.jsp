<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<h1>${question.question } </h1>
<h2>Tags:</h2>
<ul>
<c:forEach items="${question.tags }" var="tag">
<li>${tag.subject }</li>
</c:forEach>
</ul>
<table>
<thead>
<tr>
<th>Answers</th>
</tr>
</thead>
<tbody>
<c:forEach items="${question.answers }" var="answer">
<tr>
<td>${answer.answer }</td>
</tr>
</c:forEach>
</tbody>
</table>
<form:form action="/questions/${question.id }" method="post" modelAttribute="addAnswer">
    <p>
        <form:label path="answer">Answer :</form:label>
        <form:errors path="answer"/>
        <form:input path="answer"/>
    </p>

    <input type="submit" value="Answer it!"/>
</form:form>    

</body>
</html>