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
				case "list students": 
					//we will list students in MVC way, so we will use a helper method for the same
					listStudents(request, response);
					break;
					
				case "LOAD":
					loadStudentInfo(request, response);
					break;
					
				case "UPDATE":
					updateStudent(request, response);
					break;
					
				case "DELETE":
					deleteStudent(request, response);
					break;
					
				default:
					listStudents(request, response);		
			}
					
		} catch (Exception e) {
			throw new ServletException(e);
		}
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//adding student to DB
		try {
			
			String opCommand = request.getParameter("command");
			
			switch(opCommand) {
				
				case "ADD":
					addStudent(request, response);
					break;
				
				default:
					listStudents(request, response);
			
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//delete student from DB
		
		//reading student info from form
		int id = Integer.parseInt(request.getParameter("studentID"));
		
		//deleting
		studentDbModel.deleteStudent(id);
		
		//redirecting to updated list of students
		listStudents(request, response);
		
	}


	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//update student info in DB
		//reading student info from form
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		//creating new Student object
		Student upStudent = new Student(id, firstName, lastName, email); 
		
		//updating the DB
		studentDbModel.updateStudent(upStudent);
		
		//redirecting to updated list of students
		listStudents(request, response);
		
	}


	private void loadStudentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read the student id from url
		int studentId = Integer.parseInt(request.getParameter("studentID"));
		
		//get student data from DB
		Student loadedStudent = studentDbModel.loadStudentInfo(studentId);
		
		//set student data as attribute
		request.setAttribute("loaded_student", loadedStudent);
		
		//forward data to jsp page i.e student-update-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student-update-form.jsp?command=list students");
		
		dispatcher.forward(request, response);
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
		//listStudents(request, response);
		response.sendRedirect(request.getContextPath() + "/ControllerStudentServlet?command=");
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
