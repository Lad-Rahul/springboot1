package com.springboot1.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot1.entity.Student;
import com.springboot1.request.CreateStudentRequest;
import com.springboot1.request.InQueryRequest;
import com.springboot1.request.UpdateStudentRequest;
import com.springboot1.response.StudentResponse;
import com.springboot1.service.StudentService;

import jakarta.validation.Valid;

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
	 *
	 */
	@Value("${app.name:defaultValue}")
	private String appName;
	
	@Autowired
	StudentService studentService;
	
	private List<StudentResponse> makeStudentResponseList(List<Student> studentList) {
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("/get")
//	@RequestMapping(value="/get", method=RequestMethod.GET)
	public StudentResponse getStudent() {
		StudentResponse student = new StudentResponse(1, "Firstname", "LastName", "abc@gmail.com");
		return student;
	}
	
	@GetMapping("/get-all")
	public List<StudentResponse> getAllStudents() {

		List<Student> studentList = studentService.getAllStudents();

		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	/**
	 * it should return data in response class format
	 * @Requestbody will convert JSON payload to modal class
	 * @Valid is required if validation present in request class
	 */
	@PostMapping("/create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		
		Student student = studentService.createStudent(createStudentRequest);
		
		StudentResponse studentResponse = new StudentResponse(student);
		
		return studentResponse;
		
	}
	
	/*
	 * payload must contain id field
	 * based on id field it will identify record in database
	 * and update database with other field provided in payload
	 */
	@PutMapping("/update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		
		Student student = studentService.updateStudent(updateStudentRequest);
		
		StudentResponse studentResponse = new StudentResponse(student);
		
		return studentResponse;
	}
	
	/*
	 * delete using id given in queryParam
	 * @RequestParam("paramKey") is used to get queryParam value
	 */
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestParam("id") Long id) {
		String message = studentService.deleteStudent(id);
		return message;
	}
	
	/*
	 * delete using id given in path variable
	 * @PathVariable is used to get id from path
	 */
	@DeleteMapping("/delete-by-id/{id}")
	public String deleteStudentById(@PathVariable("id") Long id) {
		String message = studentService.deleteStudent(id);
		return message;
	}
	
	
	@GetMapping("/get-by-first-name/{firstName}")
	public List<StudentResponse> getStudentsByFirstName(@PathVariable String firstName) {
		List<Student> studentList = studentService.getStudentsByFirstName(firstName);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;	
	}
	
	@GetMapping("/get-by-firstname-and-lastname/{firstName}/{lastName}")
	public List<StudentResponse> getStudentsByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		List<Student> studentList = studentService.getStudentsByFirstNameAndLastName(firstName, lastName);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	@GetMapping("/get-by-firstname-contains/{firstName}")
	public List<StudentResponse> getStudentsByFirstNameContains(@PathVariable String firstName){
		List<Student> studentList = studentService.getStudentsByFirstNameContains(firstName);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	@GetMapping("/get-by-firstname-startswith/{firstName}")
	public List<StudentResponse> getStudentsByFirstNameStartsWith(@PathVariable String firstName){
		List<Student> studentList = studentService.getStudentsByFirstNameStartsWith(firstName);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	@GetMapping("/get-by-firstname-endswith/{firstName}")
	public List<StudentResponse> getStudentsByFirstNameEndsWith(@PathVariable String firstName){
		List<Student> studentList = studentService.getStudentsByFirstNameEndsWith(firstName);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	/**
	 * 2 ways to get data
	 * 1. get the data through payload (preferred)
	 * 2. get data through params where data is seperated through comma
	 */
	@PostMapping("/get-by-firstname-in")
	public List<StudentResponse> getStudentsByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
		List<Student> studentList = studentService.getStudentsByFirstNameIn(inQueryRequest);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	@GetMapping("/get-all-with-pagination")
	public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
		List<Student> studentList = studentService.getAllStudentsWithPagination(pageNo, pageSize);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}
	
	/**
	 * API to work without requestParam
	 * Need top make requestParam not required and give a defauleValue
	 */
	@GetMapping("/get-all-with-sort")
	public List<StudentResponse> getAllStudentsWithSort(@RequestParam(required = false, defaultValue = "ASC") String sortOrder){
		List<Student> studentList = studentService.getAllStudentsWithSort(sortOrder);
		
		List<StudentResponse> studentResponseList = makeStudentResponseList(studentList);
		
		return studentResponseList;
	}

	
}