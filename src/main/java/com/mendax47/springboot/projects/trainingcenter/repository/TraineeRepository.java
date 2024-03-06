package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long>, JpaSpecificationExecutor<Trainee> {
}