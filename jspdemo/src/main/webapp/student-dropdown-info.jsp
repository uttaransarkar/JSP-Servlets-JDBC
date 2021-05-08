<html>
<head>
<title>Student Confirmation JSP</title>
</head>
<body>

The student has been registered: ${param.firstName} ${param.lastName}
<br><br>

The student is from: <%= request.getParameter("country") %>

<jsp:include page="my-footer.jsp"></jsp:include>
</body>

</html>