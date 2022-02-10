package com.tk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tk.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
