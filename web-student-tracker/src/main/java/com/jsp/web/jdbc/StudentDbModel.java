package com.jsp.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				stm.close();
			if(conn != null)
				conn.close();			//becomes free in the connection pool
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void addStudent(Student newStudent) throws Exception{
		
		//adding student to DB
		Connection conn = null;
		PreparedStatement prepstm = null;
		
		try {
			//get connection
			conn = dataSource.getConnection();
			
			//creating sql statement for insert
			String sql = "insert into student (first_name, last_name, email) "
					+ "values (?, ?, ?)";
			
			prepstm = conn.prepareStatement(sql);
			
			//setting parameter values for the student
			prepstm.setString(1, newStudent.getFirstName());
			prepstm.setString(2, newStudent.getLastName());
			prepstm.setString(3, newStudent.getEmail());
			
			//executing the insert statement
			prepstm.execute();
			
		} finally {
			//closing jdbc objects
			close(conn, prepstm, null);
		}		
	}

	public Student loadStudentInfo(int studentId) throws Exception{
		//loading student info from DB
		Student loadStudent = null;
		Connection conn = null;
		PreparedStatement prepstm = null;
		ResultSet res = null;
		
		try {
			//get connection
			conn = dataSource.getConnection();
			
			//creating sql statement for loading student row
			String sql = "select * from student where id=?";
						
			//creating prepared statement
			prepstm = conn.prepareStatement(sql);
			
			//setting params for the statement
			prepstm.setInt(1, studentId);
			
			//executing the statement
			res = prepstm.executeQuery();
			
			//retrieving data from result set and storing in student object fields
			if(res.next()) {
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");

				//initialize student fields using constructor with id
				loadStudent = new Student(studentId, firstName, lastName, email);
			} else {
				throw new Exception("could not find student id: " + studentId);
			}
		
		} finally {
			//cleaning JDBC objects
			close(conn, prepstm, res);		
		}
		
		return loadStudent;
	}

	public void updateStudent(Student upStudent) throws Exception {
		
		//update the student info in DB
		Connection conn = null;
		PreparedStatement prepstm = null;
		try {
			//get connection
			conn = dataSource.getConnection();
			
			//creating sql statement for loading student row
			String sql = "update student set first_name=?, last_name=?, email=? "
					+ "where id=?";
						
			//creating prepared statement
			prepstm = conn.prepareStatement(sql);
			
			//setting params for the statement
			prepstm.setString(1, upStudent.getFirstName());
			prepstm.setString(2, upStudent.getLastName());
			prepstm.setString(3, upStudent.getEmail());
			prepstm.setInt(4, upStudent.getId());

			
			//executing the statement
			prepstm.execute();
		} finally {
			
			//cleaning JDBC objects
			close(conn, prepstm, null);
		}
	
	}

	public void deleteStudent (int id) throws Exception {
		//delete the student info in DB
		Connection conn = null;
		PreparedStatement prepstm = null;
		try {
			//get connection
			conn = dataSource.getConnection();
			
			//creating sql statement for loading student row
			String sql = "delete from student where id=?";
			
			//creating prepared statement
			prepstm = conn.prepareStatement(sql);
			
			//setting params for the statement
			prepstm.setInt(1, id);
			
			//execute the sql statement
			prepstm.execute();
			
		} finally {
			//cleaning JDBC objects
			close(conn, prepstm, null);
		}
	}
}
