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

		//we will list students in MVC way, so we will use a helper method for the same
		try {
			listStudents(request, response);
			
		} catch (Exception e) {
			throw new ServletException();
		}
	
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
