<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Split Join Demo</title>
</head>
<body>

<c:set var="data" value="Mumbai,Delhi,Kolkata,Chennai,Pune"></c:set>

<h3>Split Demo</h3>
<!-- splitting the composite string into array of strings -->
<c:set var="citiesArray" value="${fn:split(data,',')}"></c:set>

Result of split() on <b>${data}</b>:<br>
<!-- Displaying the strings in the array -->
<c:forEach var="thisCity" items="${citiesArray}">
	
	${thisCity} <br>	
	
</c:forEach>

<h3>Join Demo</h3>
<!-- joining the array of strings into a composite string -->
<c:set var="citiesData" value="${fn:join(citiesArray, '-')}"></c:set>
Result of join() on the above array of strings:<br> ${citiesData}

</body>
</html>