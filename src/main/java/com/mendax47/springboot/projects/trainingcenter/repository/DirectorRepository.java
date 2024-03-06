package com.mendax47.springboot.projects.trainingcenter.repository;

import com.mendax47.springboot.projects.trainingcenter.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>, JpaSpecificationExecutor<Director> {
}