<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loop For Each Demo</title>
</head>

<% //creating sample data...to be provided by MVC later
	String[] cities = {"Mumbai", "Bengaluru", "Chennai", "Kolkata"};

	pageContext.setAttribute("cityList", cities);
%>

<body>
	<c:forEach var="thisCity" items="${cityList}">

		${thisCity} <br>
	
	</c:forEach>
</body>
</html>