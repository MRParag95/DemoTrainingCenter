package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.mappers.TraineeInfo;
import com.mendax47.springboot.projects.trainingcenter.models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long>, JpaSpecificationExecutor<Trainee> {
    @Query("select t from Trainee t")
    Set<TraineeInfo> findAllTrainees();
}