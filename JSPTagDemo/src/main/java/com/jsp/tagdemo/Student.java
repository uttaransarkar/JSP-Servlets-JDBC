package com.jsp.tagdemo;

public class Student {
	private String firstName;
	private String lastName;
	private boolean goldCustomer;
	
	//generated constructor by right-click, source
	public Student(String firstName, String lastName, boolean goldCustomer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.goldCustomer = goldCustomer;
	}

	//generated getters and setters by right-click, source
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isGoldCustomer() {
		return goldCustomer;
	}


	public void setGoldCustomer(boolean goldCustomer) {
		this.goldCustomer = goldCustomer;
	}	
	
	
}
