<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">

</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>MyTech University</h2>
	</div>
</div>

<div id="container">
	<h3>Add Student</h3>	
	
	<form action="ControllerStudentServlet" method="POST">
		
		<!-- this won't be visible to user, but we will use command to determine whether to ADD or DELETE from database -->
		<input type="hidden" name="command" value="ADD">
		
		<table>
			<tbody>
				<tr>
					<td><label>First Name:</label></td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
			</tbody>
		</table> 
		 	
	</form>
	<div style="clear: both;"></div>
	<p>
		<a href="ControllerStudentServlet">View list</a>
	</p>

</div>

</body>
</html>