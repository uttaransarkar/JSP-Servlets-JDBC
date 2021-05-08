<html>
<head>
<title>Student Confirmation JSP</title>
</head>
<body>

The student has been registered: ${param.firstName} ${param.lastName}
<br><br>

<!-- display the student's list of favorite languages -->

The student's favorite languages are:
<%
	String[] languages = request.getParameterValues("favoriteLanguage");
	
	//print out all the favorite languages
	for(int i=0; i<languages.length; i++) {
		out.println("<li>" + languages[i] + "</li>");
	}
%>

<jsp:include page="my-footer.jsp"></jsp:include>
</body>

</html>