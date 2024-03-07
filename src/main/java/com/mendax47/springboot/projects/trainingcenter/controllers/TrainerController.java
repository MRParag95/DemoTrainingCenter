package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.models.Trainer;
import com.mendax47.springboot.projects.trainingcenter.services.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/trainers")
public class TrainerController {
    private TrainerService trainerService;

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return this.trainerService.createTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return this.trainerService.getAllTrainers();
    }

    @GetMapping("{id}")
    public Trainer getTrainerById(@PathVariable Long id) {
        return this.trainerService.getTrainerById(id);
    }

    @PutMapping("{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) throws RuntimeException {
        return this.trainerService.updateTrainer(id, trainer);
    }

    @DeleteMapping("{id}")
    public String deleteTrainer(@PathVariable Long id) {
        return this.trainerService.deleteTrainer(id);
    }
}