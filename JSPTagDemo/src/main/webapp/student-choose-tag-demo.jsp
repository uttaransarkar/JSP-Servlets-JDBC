<%@page import="com.jsp.tagdemo.Student, java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 

	//create sample data which normally is provided by MVC
	
	ArrayList<Student> students = new ArrayList<>();
	
	students.add(new Student("Sheldon","Cooper",false));
	students.add(new Student("Uttaran","Sakar",true));
	students.add(new Student("Raj","Sharma",true));
	students.add(new Student("Jack","Sparrow",false));
	
	pageContext.setAttribute("studentsList",students);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Display</title>
</head>
<body>

<table border="1">
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Gold Customer</th>
</tr>
<c:forEach var="thisStudent" items="${studentsList}">
	
	<tr>	
	<td>${thisStudent.firstName}</td> 
	<td>${thisStudent.lastName}</td> 
	
	<td>
	<!-- choose block -->
	
	<!-- All cases have a condition except the last case -->
	<c:choose>
		
		<c:when test="${thisStudent.goldCustomer}">
			Special Discount
		</c:when>
		
		<c:otherwise>
			Nada
		</c:otherwise>
	
	</c:choose>	
	</td>
	<tr>

</c:forEach>
</table>

</body>
</html>