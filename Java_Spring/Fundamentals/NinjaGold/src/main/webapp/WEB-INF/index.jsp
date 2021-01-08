<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ninja Money</title>
        <link rel="stylesheet" href="css/my_style.css">      
    </head>
    <body>
        <main>
            <p>Your Gold: <span><c:out value="${goldBalance}"/></span></p>
            <section>
                <c:forEach items="${forms}" var="item">
                <form method="POST" action="/process_money">
                    <h2>${item.getName()}</h2>
                    <p>${item.getAmount()}</p>
                    <input type="hidden" name='find_gold_in' value="${item.getValue()}"> 
                    <input type="submit" id ="b" value="Find Gold!"> 
                </form>    
                </c:forEach>
            </section>
            <p>Activities:</p>
               <section>
          
                <c:forEach items="${messages}" var="message">
             	    <p style="color:${message.getColor()}">${message.getText()}</p>
                </c:forEach>
               <section>
            
        </main>
    </body>
</html>