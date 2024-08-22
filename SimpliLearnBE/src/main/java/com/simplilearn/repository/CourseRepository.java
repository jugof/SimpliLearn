package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	// querry's to interact with database 
	
}
