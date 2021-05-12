package com.jsp.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbModel {
	
	private DataSource dataSource;
	
	public StudentDbModel(DataSource datasrc) {	
		dataSource = datasrc;
	}
	
	public List<Student> listStudents() throws Exception {
		
		List<Student> studentsData = new ArrayList<Student>();
		
		//connect to database
		Connection conn = null;
		Statement stm = null;
		ResultSet res = null;
		
		try {
			//get connection
			conn = dataSource.getConnection();
			
			//create sql statement
			String sql = "select * from student order by last_name";
			
			stm = conn.createStatement();
			
			//execute sql query
			res = stm.executeQuery(sql);
			
			//processing result set
			while (res.next()) {
				
				//retrieving data from result set row
				int id = res.getInt("id");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				
				//creating new Student object
				Student thisStudent = new Student(id,firstName,lastName,email);
				
				//adding the object to the studentsData list
				studentsData.add(thisStudent);	
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//closing the JDBC objects
			close(conn,stm,res);
		
		}
		
		return studentsData;
	}

	private void close(Connection conn, Statement stm, ResultSet res) {

		try {
			if(res != null) 
				res.close();
			if(stm != null)
				res.close();
			if(conn != null)
				conn.close();			//becomes free in the connection pool
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	

}
