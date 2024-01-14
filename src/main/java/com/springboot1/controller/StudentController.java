package com.springboot1.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot1.entity.Student;
import com.springboot1.response.StudentResponse;
import com.springboot1.service.StudentService;

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
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/get")
//	@RequestMapping(value="/get", method=RequestMethod.GET)
	public StudentResponse getStudent() {
		StudentResponse student = new StudentResponse(1, "Firstname", "LastName");
		return student;
	}
	
	@GetMapping("/get-all")
	public List<StudentResponse> getAllStudents() {
		
		List<Student> studentList = studentService.getAllStudents();
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
