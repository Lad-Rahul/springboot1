package com.springboot1.entity;

import com.springboot1.request.CreateStudentRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/* 
 * Entity class represent table in database
 * Each table have their own entity class
 * Each entity class have their own repository
 * Need to add in EntityScan annotation in main class
 * @Column Annotation represent column name of table
 * @Id represnt primary key (unique identifier)
 * @GeneratedValue is annotation for auto increment field 
 * 
 * strategy needs to provide for auto increament identifier for POST API
 * */
@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	/**
	 * @Transient annotation is used for variable in class which is not refers to column in table
	 * It is used when this field should not persist in database
	 * It's value is calculated based on data available, ex fullName, total, percentage etc
	 */
	@Transient
	private String fullName;
	
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
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
		this.fullName = firstName + " " + lastName;
	}
	
	/**
	 * constructor to create student instance from create request payload 
	 */
	public Student(CreateStudentRequest createStudentRequest) {
		super();
		String firstName = createStudentRequest.getFirstName();
		String lastName = createStudentRequest.getLastName();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = createStudentRequest.getEmail();
		this.fullName = firstName + " " + lastName;
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
	
	public String getFullName() {
		String fullName = this.firstName + " " + this.lastName;
		return fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
