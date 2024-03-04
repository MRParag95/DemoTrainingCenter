package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {
}