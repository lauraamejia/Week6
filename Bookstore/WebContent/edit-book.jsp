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
	<form action = "EditBookServlet" method="post">
		Name: <input type = "text" name = "name" value = "${bookToEdit.name}">
		Author: <input type = "text" name = "author" value = "${bookToEdit.author}">
		Publisher: <input type = "text" name = "publisher" value = "${bookToEdit.publisher}">
		Purchase date: <input type="text" name="month" placeholder="mm" size="4" value="${bookToEdit.purchaseDate.getMonthValue()}">, 
		<input type="text" name="day" placeholder="dd" size="4" value="${bookToEdit.purchaseDate.getDayOfMonth()}">, 
		<input type="text" name="year" placeholder="yyyy" size="4" value="${bookToEdit.purchaseDate.getYear()}"><br/>
		<input type = "hidden" name = "id" value = "${bookToEdit.id}">
		<input type = "submit" value = "Save Edited Book">		
	</form>
</body>

</html>