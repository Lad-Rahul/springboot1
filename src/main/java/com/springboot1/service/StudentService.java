package com.springboot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.entity.Student;
import com.springboot1.repository.StudentRepository;
import com.springboot1.request.CreateStudentRequest;
import com.springboot1.request.UpdateStudentRequest;

/**
 * it initialize repository instance here
 * it will use repository method to make query
 */

@Service
public class StudentService {
	                               
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		/*
		 * findAll method is provided by JpaRepository interface
		 */
		List<Student> list = studentRepository.findAll();
		
		return list;
	}
	
	public Student createStudent(CreateStudentRequest createStudentRequest) {
			
		Student student = new Student(createStudentRequest);
		
		/**
		 * save will create new record in database
		 */
		student = studentRepository.save(student);
		
		return student;
	}
	
	/**
	 * use orElse method with findById otherwise need to make return type <Optional>
	 */
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		
		Long payloadId = updateStudentRequest.getId();
		Student student = studentRepository.findById(payloadId).orElse(null);
		
		String payloadFirstName = updateStudentRequest.getFirstName();
		
		if(student != null && payloadFirstName != null && !payloadFirstName.isEmpty()) {
			student.setFirstName(payloadFirstName);
			student = studentRepository.save(student);
		}
		
		return student;
	}
	
	public String deleteStudent(Long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
}
