<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Buyer</title>
</head>
<body>
<form action = "AddBuyerServlet" method="post">
	Firstname: <input type = "text" name = "fname">
	Lastname: <input type = "text" name = "lname">
	City: <input type = "text" name = "city">
	State: <input type="text" name="state" size="2">, 
	<input type = "submit" value = "Add Buyer">
	</form><br/>
</body>
</html>