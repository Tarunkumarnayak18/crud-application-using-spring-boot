package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends 
				JpaRepository<Student, Integer>{
	
	@Query("SELECT s FROM Student s WHERE s.name = :name")
	Student findByName(String name);

}
