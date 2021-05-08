<html>
<head>
<title>Student Confirmation JSP</title>
</head>
<body>

The student has been registered: ${param.firstName} ${param.lastName}
<br><br>

Student's favorite programming language is <%= request.getParameter("favoriteLanguage") %>

<jsp:include page="my-footer.jsp"></jsp:include>
</body>

</html>