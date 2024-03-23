package com.springboot1.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot1.entity.Student;
import com.springboot1.entity.Subject;

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
	
	private String street;
	
	private String city;
	
	private List<SubjectResponse> subjects;

	public StudentResponse(long id, String firstName, String lastName, String email, String street, String city, List<SubjectResponse> subjects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fullName = firstName + lastName;
		this.street = street;
		this.city = city;
		this.subjects = subjects;
	}

	public StudentResponse(Student student) {
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		
		this.id = student.getId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = student.getEmail();
		this.fullName = firstName + " " + lastName;
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		
		List<Subject> subjectsFromStudent = student.getSubjects();
		
		if(subjectsFromStudent != null) {
			List<SubjectResponse> subjects = new ArrayList<SubjectResponse>();
			
			for(Subject subject : subjectsFromStudent) {
				subjects.add(new SubjectResponse(subject));
			}
			
			this.subjects = subjects;
		}
		
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", street=" + street + ", city=" + city + "]";
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SubjectResponse> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectResponse> subjects) {
		this.subjects = subjects;
	}
	
}
