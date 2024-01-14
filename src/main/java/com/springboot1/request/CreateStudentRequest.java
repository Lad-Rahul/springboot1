package com.springboot1.request;

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
	
}
