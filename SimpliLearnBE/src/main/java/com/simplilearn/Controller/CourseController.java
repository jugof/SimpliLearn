package com.simplilearn.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.Entity.Course;
import com.simplilearn.Service.CourseService;

@CrossOrigin
@RestController
@RequestMapping
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addcourse")
	public Course addCourse( @RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@GetMapping("/allcourses")
	public Collection<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/course/{id}")
	public Course getSingleCourse( @PathVariable Integer id) {
		return courseService.getSingleCourse(id);
	}
	
	@DeleteMapping("/course/{id}")
	public String deleteCourse( @PathVariable Integer id) {
		return courseService.deleteCourse(id);
	}

}
