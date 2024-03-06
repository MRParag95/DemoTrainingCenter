package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.models.Course;
import com.mendax47.springboot.projects.trainingcenter.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return this.courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable Long id) {
        return this.courseService.getCourseById(id);
    }

    @PutMapping("{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) throws RuntimeException {
        return this.courseService.updateCourse(id, course);
    }

    @DeleteMapping("{id}")
    public String deleteCourse(@PathVariable Long id) {
        return this.courseService.deleteCourse(id);
    }
}