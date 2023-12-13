package com.springboot1.controller;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController is  combination of @controller and @ResponseBody annotation
 * @RequestMapping - url of API - (prefix of url) for controller
 */

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@GetMapping("/get")
//	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String getStudent() {
		return "Hello World 2";
	}
}
