package com.springboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot1.entity.Address;
import com.springboot1.response.AddressResponse;
import com.springboot1.service.AddressService;

@RestController
@RequestMapping("api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/get/{id}")
	public AddressResponse getAddressById(@PathVariable Long id){
		Address address = addressService.getById(id);
		AddressResponse addressResponse = new AddressResponse(address);
		return addressResponse;
	}

}
