package com.jsp.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Define datasource/connection fool for resource injection by Tomcat
	
	@Resource(name = "jdbc/web_student_tracker") 
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set up printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		//connecting to database
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		
		try {
			conn = dataSource.getConnection();
			
			//Create a SQL statement
			String sql = "select * from student";
			stm = conn.createStatement();
		
			//executing a SQL query
			res = stm.executeQuery(sql);
		
			//processing the result set
			while (res.next()) {
				String email = res.getString("email");
				out.println(email);
				
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
