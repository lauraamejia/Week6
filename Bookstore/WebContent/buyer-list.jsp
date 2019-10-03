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
<form method = "post" action = "BuyerNavServlet">
	<table>
	<c:forEach items="${requestScope.allItems}" var="currentbuyer">
	<tr>
		<td><input type="radio" name="id" value="${currentbuyer.id}"></td>
		<td>${currentbuyer.fname}</td>
		<td>${currentbuyer.lname}</td>
		<td>${currentbuyer.city}</td>
		<td>${currentbuyer.state}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToItem">
	<input type = "submit" value = "delete" name = "doThisToItem">
	</form>
<a href="AddBuyerServlet">Add a new buyer</a>
</body>
</html>