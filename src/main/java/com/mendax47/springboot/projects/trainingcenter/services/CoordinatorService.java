package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.models.Coordinator;
import com.mendax47.springboot.projects.trainingcenter.models.Director;
import com.mendax47.springboot.projects.trainingcenter.repository.CoordinatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;

    public Coordinator createCoordinator(Coordinator coordinator) {
        return this.coordinatorRepository.save(coordinator);
    }

    public List<Coordinator> getAllCoordinators() {
        return this.coordinatorRepository.findAll();
    }

    public Coordinator getCoordinatorById(Long id) {
        return this.coordinatorRepository.findById(id).orElseThrow();
    }

    public Coordinator updateCoordinator(Long id, Coordinator coordinator) throws RuntimeException {
        Coordinator foundCoordinator = this.getCoordinatorById(id);

        foundCoordinator.setFirstName(coordinator.getFirstName());
        foundCoordinator.setLastName(coordinator.getLastName());
        foundCoordinator.setUsername(coordinator.getUsername());
        foundCoordinator.setEmail(coordinator.getEmail());

        foundCoordinator.setTrainees(coordinator.getTrainees());
        foundCoordinator.setSupervisedBy(coordinator.getSupervisedBy());

        return this.coordinatorRepository.save(foundCoordinator);
    }

    public String deleteCoordinator(Long id) {
        this.coordinatorRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}