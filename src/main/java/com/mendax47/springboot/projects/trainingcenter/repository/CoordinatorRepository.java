package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.mappers.CoordinatorInfo;
import com.mendax47.springboot.projects.trainingcenter.models.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long>, JpaSpecificationExecutor<Coordinator> {
    @Query("select c from Coordinator c")
    Set<CoordinatorInfo> findAllCoordinators();
}