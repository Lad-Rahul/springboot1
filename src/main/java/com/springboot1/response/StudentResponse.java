package com.springboot1.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot1.entity.Student;

public class StudentResponse {
	
	//Field is ignored in response if JsonIgnore is added
	//@JsonIgnore
	private long id;
	
	//key gets renamed in response 
	@JsonProperty("first_name")
	private String firstName;

	private String lastName;
	
	private String email;
	
	private String fullName;

	public StudentResponse(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fullName = firstName + lastName;
	}

	public StudentResponse(Student student) {
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		
		this.id = student.getId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = student.getEmail();
		this.fullName = firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		String fullName = this.firstName + " " + this.lastName;
		return fullName;
	}
	
}
