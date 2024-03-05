package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.services.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DirectorController {
    private final DirectorService directorService;
}
