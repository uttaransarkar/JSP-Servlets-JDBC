<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Students</title>
</head>
<body>

<h3>Data sent from servlet to JSP</h3>

<c:forEach var="thisStudent" items="${studentsData}">

	${thisStudent}<br><br>

</c:forEach>

</body>
</html>