package com.mendax47.springboot.projects.trainingcenter.controllers;

import com.mendax47.springboot.projects.trainingcenter.models.Coordinator;
import com.mendax47.springboot.projects.trainingcenter.services.CoordinatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/coordinators")
public class CoordinatorController {
    private final CoordinatorService coordinatorService;

    @PostMapping
    public Coordinator createCoordinator(@RequestBody Coordinator coordinator) {
        return this.coordinatorService.createCoordinator(coordinator);
    }

    @GetMapping
    public List<Coordinator> getAllCoordinators() {
        return this.coordinatorService.getAllCoordinators();
    }

    @GetMapping("{id}")
    public Coordinator getCoordinatorById(@PathVariable Long id) {
        return this.coordinatorService.getCoordinatorById(id);
    }

    @PutMapping("{id}")
    public Coordinator updateCoordinator(@PathVariable Long id, @RequestBody Coordinator coordinator) throws RuntimeException {
        return this.coordinatorService.updateCoordinator(id, coordinator);
    }

    @DeleteMapping("{id}")
    public String deleteCoordinator(@PathVariable Long id) {
        return this.coordinatorService.deleteCoordinator(id);
    }
}