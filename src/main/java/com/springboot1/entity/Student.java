package com.springboot1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * Entity class represent table in database
 * Each table have their own entity class
 * Each entity class have their own repository
 * Need to add in EntityScan annotation in main class
 * @Column Annotation represent column name of table
 * @Id represnt primary key (unique identifier)
 * @GeneratedValue is annotation for auto increment field 
 * */
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	/**
	 * default constructor is mandatory for Entity class
	 */
	public Student() {
		super();
	}
	
	public Student(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	
}
