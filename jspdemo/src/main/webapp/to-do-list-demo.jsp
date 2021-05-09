<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-do List</title>
</head>
<body>

<!-- Learning about built-in SESSION object -->

<h2>To Do List</h2>

<!-- Create HTML form -->
<form action="to-do-list-demo.jsp">
	Add a new item: <input type="text" name="item">
	
	<input type="submit" value="ADD"">

</form>
<hr>

<%-- <%= request.getParameter("item") %> --%>
<!-- Add items to To-Do list -->
<%
	//get items from session
	ArrayList<String> items = (ArrayList<String>) session.getAttribute("usertodolist");
	
	//if no item exists, then create one
	if(items == null) {
		items = new ArrayList<String>();
		session.setAttribute("usertodolist", items);
	}
	
	//check if there's form data to add
	String it = request.getParameter("item");
	if(it != "" && it != null)
		items.add(it);
	
%>

<!-- Display all items in the TO-do list from session object -->

<h4>To-Do List Items</h4>
<ol>
<%
	for(String item:items) {
		out.println("<li>" + item + "</li>");
	}
%>
</ol>

</body>
</html>