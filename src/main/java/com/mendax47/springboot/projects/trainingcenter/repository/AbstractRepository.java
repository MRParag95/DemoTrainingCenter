package com.mendax47.springboot.projects.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T, V> extends JpaRepository<T, V> {
}