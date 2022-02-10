package com.tk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tk.entity.Course;
import com.tk.repository.CourseRepository;
import com.tk.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	
	// Here we need object of CourseRepository, but it is an Interface, so use @Autowired annotation so that Spring will create its object.
	// Autowired annotation will create object and wired it. (automatic wiring)
	@Autowired
	private CourseRepository courseRepo;
	
	
	public CourseServiceImpl() {
		
	}
	
	
	@Override
	public List<Course> getCourses() {
		// to get all the courses: use findAll() method of JpaRepo, it will provide all the data in list format.
		return courseRepo.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		
		// to get a course by Id, use getOne(parameter) method
		return courseRepo.getById(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		
		// to add courses: use save(param) method of JpaRepo
		courseRepo.save(course);
		return course;  // return the course after adding
	}


	@Override
	public Course updateCourse(Course course) {
		
		// to update the course use save() method again, bcoz before updating we already have that course in DB, so we are just editing its values
		courseRepo.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long courseId) {

		// by using stream, filter the courses whose id are different from given id and print them in list.
		//list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		
		// to delete: create entity by using course ID and then delete it.
		Course entity = courseRepo.getById(courseId);
		courseRepo.delete(entity);
		
	}

}
