package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.models.Coordinator;
import com.mendax47.springboot.projects.trainingcenter.models.Trainee;
import com.mendax47.springboot.projects.trainingcenter.repository.TraineeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TraineeService {
    private TraineeRepository traineeRepository;

    public Trainee createTrainee(Trainee trainee) {
        return this.traineeRepository.save(trainee);
    }

    public List<Trainee> getAllTrainees() {
        return this.traineeRepository.findAll();
    }

    public Trainee getTraineeById(Long id) {
        return this.traineeRepository.findById(id).orElseThrow();
    }

    public Trainee updateTrainee(Long id, Trainee trainee) throws RuntimeException {
        Trainee foundTrainee = this.getTraineeById(id);

        foundTrainee.setFirstName(trainee.getFirstName());
        foundTrainee.setLastName(trainee.getLastName());
        foundTrainee.setUsername(trainee.getUsername());
        foundTrainee.setEmail(trainee.getEmail());

        foundTrainee.setSupervisedBy(trainee.getSupervisedBy());
        foundTrainee.setCourses(trainee.getCourses());

        return this.traineeRepository.save(foundTrainee);
    }

    public String deleteTrainee(Long id) {
        this.traineeRepository.deleteById(id);

        return "Director Deleted Successfully.";
    }
}