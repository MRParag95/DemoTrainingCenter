package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.models.Trainee;
import com.mendax47.springboot.projects.trainingcenter.services.TraineeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/trainees")
public class TraineeController {
    private TraineeService traineeService;

    @PostMapping
    public Trainee createTrainee(@RequestBody Trainee trainee) {
        return this.traineeService.createTrainee(trainee);
    }

    @GetMapping
    public List<Trainee> getAllTrainees() {
        return this.traineeService.getAllTrainees();
    }

    @GetMapping("{id}")
    public Trainee getTraineeById(@PathVariable Long id) {
        return this.traineeService.getTraineeById(id);
    }

    @PutMapping("{id}")
    public Trainee updateTrainee(@PathVariable Long id, @RequestBody Trainee trainee) throws RuntimeException {
        return this.traineeService.updateTrainee(id, trainee);
    }

    @DeleteMapping("{id}")
    public String deleteTrainee(@PathVariable Long id) {
        return this.traineeService.deleteTrainee(id);
    }
}