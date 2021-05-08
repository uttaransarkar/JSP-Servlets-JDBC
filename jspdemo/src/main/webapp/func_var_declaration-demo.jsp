<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Declaration</title>
</head>

<body>

<h2>Learning about JSP Declaration</h2>

<%!
	int returnSum(int a, int b) {
		return a+b;	
	}
%>
The sum of 45 + 59 = <%= returnSum(45,59) %>
</body>
</html>