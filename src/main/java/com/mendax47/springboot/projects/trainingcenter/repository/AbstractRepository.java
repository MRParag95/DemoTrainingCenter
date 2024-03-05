package com.mendax47.springboot.projects.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractRepository<T, V> extends JpaRepository<T, V> {
}