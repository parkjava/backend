package com.parkjava.repository;

import com.parkjava.model.patrolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patrolRepository extends JpaRepository<patrolModel, Long> {
}
