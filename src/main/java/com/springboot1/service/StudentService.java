package com.springboot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.entity.Student;
import com.springboot1.repository.StudentRepository;

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
}
