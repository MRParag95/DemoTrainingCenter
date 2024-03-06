package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>, JpaSpecificationExecutor<Trainer> {
}