package com.springboot1.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest {
	
	@JsonProperty("first_name")
	private String firstName;
	
	private String lastName;
	
	/**
	 * Not blank validation in request payload for email field 
	 */
	@NotBlank(message ="email id is mandatory")
	private String email;
	
	
	private String street;
	
	private String city;
	
	private List<CreateSubjectRequest> subjects;

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

	public List<CreateSubjectRequest> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<CreateSubjectRequest> subjects) {
		this.subjects = subjects;
	}
	
}
