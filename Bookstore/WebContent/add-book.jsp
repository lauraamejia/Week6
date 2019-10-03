<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
</head>
<body>
<form action = "AddBookServlet" method="post">
	Author: <input type = "text" name = "author">
	Publisher: <input type = "text" name = "publisher">
	Name: <input type = "text" name = "name">
	Purchase date: <input type="text" name="month" placeholder="mm" size="4">, 
	<input type="text" name="day" placeholder="dd" size="4">, 
	<input type="text" name="year" placeholder="yyyy" size="4"><br/>
	Buyer: <select name="buyer">
	<c:forEach items="${requestScope.allItems}" var="currentbuyer">
	<option value="${currentbuyer.id}">${currentbuyer.fname} ${currentbuyer.lname}</option>
	</c:forEach>
	</select>
	<input type = "submit" value = "Add Book">
	</form><br />
	<a href = "ViewAllBooksServlet">View all the books</a><br/>
	<a href = "index.html">Return to home</a><br/>
</body>
</html>