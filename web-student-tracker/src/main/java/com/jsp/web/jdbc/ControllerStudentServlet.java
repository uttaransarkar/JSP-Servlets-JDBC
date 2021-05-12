package com.jsp.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControllerStudentServlet
 */

@WebServlet("/ControllerStudentServlet")
public class ControllerStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbModel studentDbModel;
	
	//Define datasource/connection fool for resource injection by Tomcat
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	
   //this method is called by Tomcat when servlet is first initialized
    
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			//instance of the helper(model) class
			studentDbModel = new StudentDbModel(dataSource);
			
		} catch (Exception e) {
			throw new ServletException();
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Read the "command" parameter from form
			String opCommand = request.getParameter("command");
			
			//if command is null, then list students
			if (opCommand == null) 
				opCommand = "list students";
			
			//go to the appropriate method according to the opCommand
			switch(opCommand) {
				case "list command": 
					//we will list students in MVC way, so we will use a helper method for the same
					listStudents(request, response);
					break;
					
				case "ADD":
					addStudent(request, response);
					break;
					
				default:
					listStudents(request, response);
			
			}
					
		} catch (Exception e) {
			throw new ServletException();
		}
	
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//reading student info from form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		//creating new Student object
		Student newStudent = new Student(firstName, lastName, email);
		
		//adding new student to DB
		studentDbModel.addStudent(newStudent);
		
		//redirecting to page with updated list of students
		listStudents(request, response);
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get the data via the helper class instance
		List<Student> studentsData = studentDbModel.listStudents();
		
		//set as attribute to request
		request.setAttribute("students_list", studentsData);
		
		//request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/students-list.jsp");
		
		//forward data to jsp
		dispatcher.forward(request, response);
	}
	
	

}
