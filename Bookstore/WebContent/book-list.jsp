<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of books</title>
</head>
<body>
<form method = "post" action = "BookNavServlet">

	<table>
	<c:forEach items="${requestScope.allItems}" var="currentbook">
	<tr>
		<td><input type="radio" name="id" value="${currentbook.id}"></td>
		<td>${currentbook.name}</td>
		<td>${currentbook.author}</td>
		<td>${currentbook.publisher}</td>
		<td>${currentbook.purchaseDate}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToItem">
	<input type = "submit" value = "delete" name = "doThisToItem">
	</form>
<a href="AddBookServlet">Add a new book</a><br/>
<a href = "index.html">Return home</a><br/>
</body>

</html>