package com.servletdemo.mvc_student;

import java.util.ArrayList;
import java.util.List;

//helper class to return data to controller
public class StudentListModel {
	
	public static List<Student> getStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		
		//add sample data
		studentsList.add(new Student("Sheldon", "Cooper", "sheldcooper@abc.com"));
		studentsList.add(new Student("Uttaran", "Sarkar", "sarkaruttaran@gmail.com"));
		studentsList.add(new Student("Howard", "Stark", "howie@xyz.com"));
		studentsList.add(new Student("Steve", "Rogers", "capam@marvel.org"));

		return studentsList;
	}
	
}
