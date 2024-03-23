package com.springboot1.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.springboot1.entity.Address;
import com.springboot1.entity.Student;
import com.springboot1.entity.Subject;
import com.springboot1.repository.AddressRepository;
import com.springboot1.repository.StudentRepository;
import com.springboot1.repository.SubjectRepository;
import com.springboot1.request.CreateStudentRequest;
import com.springboot1.request.CreateSubjectRequest;
import com.springboot1.request.InQueryRequest;
import com.springboot1.request.UpdateStudentRequest;

/**
 * it initialize repository instance here
 * it will use repository method to make query
 */

@Service
public class StudentService {
	
	private static final Map<String, Direction> SORT_DIRECTION_MAP = Map.of(
			"ASC", Direction.ASC,
			"DESC", Direction.DESC
		);
	                                
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Student> getAllStudents() {
		/*
		 * findAll method is provided by JpaRepository interface
		 */
		List<Student> list = studentRepository.findAll();
		
		return list;
	}
	
	public Student createStudent(CreateStudentRequest createStudentRequest) {
			
		Student student = new Student(createStudentRequest);
		
		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		
		// save will create new record in database for address with id
		address = addressRepository.save(address);
		
		/**
		 * save address in Student Object after it is stored in DB
		 * so it has address_id(foreign key) to store in student object
		 */
		student.setAddress(address);
		

		//save student object in database after it has address_id
		student = studentRepository.save(student);
		
		
		List<Subject> subjectList = new ArrayList<Subject>();
		
		List<CreateSubjectRequest> subjects = createStudentRequest.getSubjects();
		
		if(subjects != null) {
			
			/**
			 *  From subjectRequest List, collect subject data, map subject with student,
			 *  store all subject in subject database with student_id
			 *  After that add subjectList in student Entity class
			 */
			for(CreateSubjectRequest createSubjectRequest : subjects) {
				
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectList.add(subject);
			}
		}
		
		// store subject data in database
		subjectRepository.saveAll(subjectList);
		
		// store subjects in student Entity class
		student.setSubjects(subjectList);

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
	
	public List<Student> getStudentsByFirstName(String firstName) {
		List<Student> studentList = studentRepository.findByFirstName(firstName);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameAndLastName(String firstName, String lastName){
		List<Student> studentList = studentRepository.findByFirstNameAndLastName(firstName, lastName);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameContains(String firstName){
		List<Student> studentList = studentRepository.findByFirstNameContains(firstName);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameStartsWith(String firstName){
		List<Student> studentList = studentRepository.findByFirstNameStartsWith(firstName);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameEndsWith(String firstName){
		List<Student> studentList = studentRepository.findByFirstNameEndsWith(firstName);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameIn(InQueryRequest inQueryRequest){
		List<String> firstNames = inQueryRequest.getFirstNames();
		List<Student> studentList = studentRepository.findByFirstNameIn(firstNames);
		return studentList;
	}
	
	/**
	 * pageRequest.of(pageNo, pageSize)
	 * pageNo is based on zero based index
	 */
	public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		Page<Student> pageData = studentRepository.findAll(pageable);
		System.out.println("pageData : " + pageData);

		List<Student> studentList = pageData.getContent();
		return studentList;
	}

	/**
	 * Sort.by(direction, property)
	 * direction: direction object
	 * property: fieldName of class that refers to column in table
	 */
	public List<Student> getAllStudentsWithSort(String sortOrder){
		Direction direction = SORT_DIRECTION_MAP.get(sortOrder);
		System.out.println("sort direction: " + direction);
		Sort sort = Sort.by(direction , "firstName");
		
		List<Student> studentList = studentRepository.findAll(sort);
		return studentList;
	}
	
	public List<Student> getStudentsByFirstNameAndLastNameWithJpql(String firstName, String lastName){
		List<Student> studentList = studentRepository.getByFirstNameAndLastName(firstName, lastName);
		return studentList;
	}
	
//	public String updateFirstNameWithJpql(Long id, String firstName) {
//		Integer updatedRecordCount studentRepository.updateFirstName(id, firstName);
//		return updatedRecordCount + " students records are updated";
//	}
	
	public String deleteByFirstNameWithJpql(String firstName) {
		Integer deletedRecordCount = studentRepository.deleteByFirstName(firstName);
		return deletedRecordCount + " student records are deleted";
	}
	
	public List<Student> getAllStudentsByCity(String city){
		List<Student> studentList = studentRepository.findByAddressCity(city);
		return studentList;
	}
	
	public List<Student> getAllStudentsByCityWithJpql(String city){
		List<Student> studentList = studentRepository.getByAddressCity(city);
		return studentList;
	}
	
}
