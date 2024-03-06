package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.models.Course;
import com.mendax47.springboot.projects.trainingcenter.models.Trainee;
import com.mendax47.springboot.projects.trainingcenter.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return this.courseRepository.findAllCourse();
    }

    public Course getCourseById(Long id) {
        return this.courseRepository.findById(id).orElseThrow();
    }

    public Course updateCourse(Long id, Course course) throws RuntimeException {
        Course foundCourse = this.getCourseById(id);

        foundCourse.setName(course.getName());
        foundCourse.setDuration(course.getDuration());

        foundCourse.setTrainees(course.getTrainees());

        return this.courseRepository.save(foundCourse);
    }

    public String deleteCourse(Long id) {
        this.courseRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}