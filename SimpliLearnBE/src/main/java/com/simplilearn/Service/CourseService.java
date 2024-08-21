package com.simplilearn.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Entity.Course;
import com.simplilearn.repository.CourseRepository;
import com.simplilearn.repository.UserRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}
	
	// Getting all Courses from the database
    public Collection<Course> getAllCourses() {
    	return courseRepo.findAll();
    }
    
    // returning single course from the database
    public Course getSingleCourse(Integer id) {
    	Course course = null;
    	Optional<Course> oneCourse = courseRepo.findById(id);
    	if(oneCourse.isPresent()) {
    		course = oneCourse.get();
    	}
    	return course;
    }
    
    // deleting the single course from db
    public String deleteCourse( Integer id) {
    	Course course = null;
    	Optional<Course> oneCourse = courseRepo.findById(id);
    	if(oneCourse.isPresent()) {
    		course = oneCourse.get();
    	}
    	if(course == null) {
    		return "Course is not present to Delete with ID " + id ;
    	}
    	courseRepo.deleteById(id);
    	return "Course deleted Successfuly";
    }

}
