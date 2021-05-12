<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Student Registry App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>MyTech University</h2>
	</div>
	
	
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="thisStudent" items="${students_list}">
				
					<tr>
						<td>${thisStudent.firstName}</td>
						<td>${thisStudent.lastName}</td>
						<td>${thisStudent.email}</td>
					</tr>	
				
				</c:forEach>
			</table>
		</div>
	</div>
</div>

</body>
</html>