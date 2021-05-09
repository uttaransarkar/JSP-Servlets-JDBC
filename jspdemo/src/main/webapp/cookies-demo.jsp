<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>

<%
	//read form data
	String lang = request.getParameter("programmingLang");
	
	//create new cookie
	Cookie myCookie = new Cookie("myApp.progLang",lang);
	
	myCookie.setMaxAge(60*60*24*365);
	
	response.addCookie(myCookie);
%>

<body>

Great! We've set your favorite language to: ${param.programmingLang}
<br><br>

Return to the <a href="cookies-homepage.jsp">homepage</a>.

</body>
</html>