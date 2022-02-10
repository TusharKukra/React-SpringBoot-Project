package com.tk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tk.entity.Course;
import com.tk.service.CourseService;

/* Main Controller File */

// As we are making Rest API, so use @RestController: Rest = Representational State Transfer

@RestController
public class CourseController {
	
	/* To get all the methods of Service Class: create object of the Service Layer. */
	// And use @Autowired bcoz using autowired we will tell spring to create object of impl class of service interface (using Dependency Injection)
	
	@Autowired
	private CourseService courseService;
	
	
	/* Get the Courses */
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		// here I want to return the courses, so for that first we need courses:
		// so it will get courses from the Service Layer
		return this.courseService.getCourses();
	}
	
	
	/* Get the Course by ID */
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	
	/* Adding a new Course (using @PostMapping to post the data) */
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	
	/* Updating Course using @PutMapping */
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	
	/* Deleting Course using Course Id (@DeleteMapping) */
	@DeleteMapping("courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}