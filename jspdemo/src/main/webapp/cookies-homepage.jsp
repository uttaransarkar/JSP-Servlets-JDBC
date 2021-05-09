<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customised Homepage</title>
</head>

<!-- read the favorite language cookie -->
<%
	String siteLang = "Java";	//default language
	
	//get the cookies from the browser
	Cookie[] cookies = request.getCookies();
	
	//find the favorite language cookie named "myApp.progLang"
	if(cookies != null) {
		
		for(Cookie thisCookie : cookies) {
			
			if(thisCookie.getName().equals("myApp.progLang")){
				siteLang = thisCookie.getValue();
				break;
			}
		}
	}
%>

<body>
<h2>Your Training Dashboard</h2>
<!-- show personalised page..using favorite language i.e siteLang variable -->

<h4>New Books for <%= siteLang %></h4>
<ul>
	<li>lorem ipsum</li>
	<li>lorem ipsum</li>
</ul>

<h4>New Projects for <%= siteLang %></h4>
<ul>
	<li>lorem ipsum</li>
	<li>lorem ipsum</li>
</ul>

<h4>Latest News on <%= siteLang %></h4>
<ul>
	<li>lorem ipsum</li>
	<li>lorem ipsum</li>
</ul>

<a href="cookies-demo-form.html">Personalize this page</a>
<br><br>

<jsp:include page="my-footer.jsp"></jsp:include>

</body>
</html>