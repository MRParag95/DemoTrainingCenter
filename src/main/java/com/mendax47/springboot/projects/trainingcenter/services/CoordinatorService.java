package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.mappers.CoordinatorInfo;
import com.mendax47.springboot.projects.trainingcenter.models.Coordinator;
import com.mendax47.springboot.projects.trainingcenter.repository.CoordinatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;

    public Coordinator createCoordinator(Coordinator coordinator) {
        return this.coordinatorRepository.save(coordinator);
    }

    public Set<CoordinatorInfo> getAllCoordinators() {
        return this.coordinatorRepository.findAllCoordinators();
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

        foundCoordinator.setSupervisedBy(coordinator.getSupervisedBy());
        foundCoordinator.setTrainers(coordinator.getTrainers());

        return this.coordinatorRepository.save(foundCoordinator);
    }

    public String deleteCoordinator(Long id) {
        this.coordinatorRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}