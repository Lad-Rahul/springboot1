package com.springboot1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot1.entity.Student;

/* *
 * Repository is an interface
 * JpaRepository is combination of CrudRepository and PagingAndSortingRepository
 * first param will be entity and second is datatype of unique Indentifier
 * Every Entity will have their repository
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	/*
	 * findBy* - here * should be entity class Variable name mapped to column
	 */
	List<Student> findByFirstName(String firstName);
	
	/*
	 * paramers should be in same order given in function name
	 */
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameContains(String firstName);
	
	List<Student> findByFirstNameStartsWith(String firstName);
	
	List<Student> findByFirstNameEndsWith(String firstName);
	
	List<Student> findByFirstNameIn(List<String> firstNames);

}
