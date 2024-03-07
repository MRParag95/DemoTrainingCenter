package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.mappers.TrainerInfo;
import com.mendax47.springboot.projects.trainingcenter.models.Trainer;
import com.mendax47.springboot.projects.trainingcenter.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    public Set<TrainerInfo> getAllTrainers() {
        return this.trainerRepository.findAllTrainers();
    }

    public Trainer getTrainerById(Long id) {
        return this.trainerRepository.findById(id).orElseThrow();
    }

    public Trainer updateTrainer(Long id, Trainer trainer) throws RuntimeException {
        Trainer foundTrainer = this.getTrainerById(id);

        foundTrainer.setFirstName(trainer.getFirstName());
        foundTrainer.setLastName(trainer.getLastName());
        foundTrainer.setUsername(trainer.getUsername());
        foundTrainer.setEmail(trainer.getEmail());

        foundTrainer.setSupervisedBy(trainer.getSupervisedBy());
        foundTrainer.setTrainees(trainer.getTrainees());

        return this.trainerRepository.save(foundTrainer);
    }

    public String deleteTrainer(Long id) {
        this.trainerRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}