package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

}