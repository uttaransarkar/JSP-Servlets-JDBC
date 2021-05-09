<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Tag</title>
</head>
<body>

<!-- Declare and initialize a variable -->
<c:set var="stuff" value="<%= new java.util.Date() %>"></c:set>

Time on the server is: ${stuff}

</body>
</html>