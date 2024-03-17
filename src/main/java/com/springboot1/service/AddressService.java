package com.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.entity.Address;
import com.springboot1.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public Address getById(Long id) {
		Address address = addressRepository.findById(id).orElse(null);
		return address;
	}
}	
