<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Functions demo</title>
</head>
<body>

<c:set var="data" value="Hey there!"></c:set>

<!-- fn:length() for length of string -->
The length of string <b>${data}</b> = ${fn:length(data)}
<br><br>

<!-- fn:toUpperCase for converting to upper case -->
The string in uppercase: <b>${fn:toUpperCase(data)}</b>
<br><br>

<!-- fn:startsWith to check if string starts with a particular letter/word -->
Does the string <b>${data}</b> start with <b>Hel</b>? : ${fn:startsWith(data,"Hel")}

</body>
</html>