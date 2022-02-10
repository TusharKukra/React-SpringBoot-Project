package com.tk.service;

import java.util.List;

import com.tk.entity.Course;

public interface CourseService {

	/* In the service interface, create all methods (and implement them in impl class, due to loose coupling) */
	
	// Method to get all the courses:
	public List<Course> getCourses();
	
	// Method to get course by ID:
	public Course getCourse(long courseId);
	
	// Method to add course:
	public Course addCourse(Course course);
	
	// Method to update course:
	public Course updateCourse(Course course);
	
	// Method to delete course:
	public void deleteCourse(long courseId);
}
