<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
</head>
<body>
<form action = "EditBuyerServlet" method="post">
		Firstname: <input type = "text" name = "fname" value = "${buyerToEdit.fname}">
		Lastname: <input type = "text" name = "lname" value = "${buyerToEdit.lname}">
		City: <input type = "text" name = "city" value = "${buyerToEdit.city}">
		State: <input type="text" name="state" size="2" value="${buyerToEdit.state}">, 		
		<input type = "hidden" name = "id" value = "${buyerToEdit.id}">
		<input type = "submit" value = "Save Edited Buyer">		
	</form>
</body>
</html>