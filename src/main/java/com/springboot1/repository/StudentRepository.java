package com.springboot1.repository;

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
	
}
