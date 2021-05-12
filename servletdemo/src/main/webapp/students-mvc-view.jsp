<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Students List</title>
</head>
<body>
<h2>Students Table</h2>

<table border="1" >
<tr style="padding: 10px">
	<th style="padding: 10px">First Name</th>
	<th style="padding: 10px">Last Name</th>
	<th style="padding: 10px">Email</th>
</tr>

<c:forEach var="thisStudent" items="${students_data}">
<tr>
	<td style="padding: 6px">${thisStudent.firstName}</td>
	<td style="padding: 6px">${thisStudent.lastName}</td>
	<td style="padding: 6px">${thisStudent.email}</td>

</tr>

</c:forEach>
</table>
<br>
Time on the server: <%= new java.util.Date() %>
</body>
</html>