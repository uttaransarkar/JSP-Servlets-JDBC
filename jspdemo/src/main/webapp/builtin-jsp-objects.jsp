<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Builtin Objects</title>
</head>

<body>

<h2>Learning about JSP Built-in Objects</h2>

<!-- Get the user's browser and OS -->
Request user agent: <%= request.getHeader("User-Agent") %>

<br><br>
Request user language: <%= request.getLocale() %>

</body>
</html>