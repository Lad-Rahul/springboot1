package com.springboot1.response;

import com.springboot1.entity.Address;

public class AddressResponse {
	
	private Long id;
	
	private String street;
	
	private String city;
	
	private String firstName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public AddressResponse(Address address) {
		this.id = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
		this.firstName = address.getStudent().getFirstName();
	}
	

	public AddressResponse(Long id, String street, String city, String firstName) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "AddressResponse [id=" + id + ", street=" + street + ", city=" + city + ", firstName=" + firstName + "]";
	}
	
	
}
