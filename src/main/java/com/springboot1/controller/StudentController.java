package com.springboot1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController is  combination of @controller and @ResponseBody annotation
 * @RequestMapping - url of API - (prefix of url) for controller
 */

@RestController
@RequestMapping("api/student")
public class StudentController {
	/*
	 * To get value from application.properties
	 * default value can be given so it will fallback to that 
	 * if not found in properties file
	 * Only works with spring manage beans, not with POJO
	 */
	@Value("${app.name:defaultValue}")
	private String appName;
	
	@GetMapping("/get")
//	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String getStudent() {
		return appName;
	}
}
