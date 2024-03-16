package com.springboot1.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot1.entity.Student;

/**
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
	
	/**
	 * any name is used as method name as JPQL query is not using method proxy
	 * use column name same as class variable, table name same as class name
	 * variable param should be start with colon
	 */
	@Query("From Student where firstName = :fname and lastName = :lastName")
	List<Student> getByFirstNameAndLastName(@Param("fname") String firstName, String lastName);
	
	
	/**
	 * when JPQL query is used to upate database, @Modifying and @Transactional (from springboot)
	 * annotation is must to be added
	 * in JPQL, query param can be access though param number (ex :?2)
	 * when @Modifying anotation is used, method's return type should be void or Integer,
	 * method will return number of rows which were updated
	 */
//	@Modifying
//	@Transactional
//	@Query("Update Student set firstName = :?2 where id = :id")
//	Integer updateFirstName(Long id, String firstName);
	
	/**
	 * using method proxy, rows can be deleteed by Id,
	 * to delete rows using other columns, have to use JPQL query
	 */
	@Modifying
	@Transactional
	@Query("Delete from Student where firstName = :firstName")
	Integer deleteByFirstName(String firstName);
	
	/**
	 * method proxy query to get list of student with particular city of Address
	 * SQL Join Query for same : SELECT * FROM `student` s INNER JOIN `address` a on s.address_id = a.id where a.city = "Dubai";
	 */
	List<Student> findByAddressCity(String city);
	
	/**
	 * JPQL to get list of student with particular city of Address
	 * SQL Join Query for same : SELECT * FROM `student` s INNER JOIN `address` a on s.address_id = a.id where a.city = "Dubai";
	 */
	@Query("From Student where address.city = :city")
	List<Student> getByAddressCity(String city);
	
}
