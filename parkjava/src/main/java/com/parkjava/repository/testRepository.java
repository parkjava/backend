package com.parkjava.repository;

import com.parkjava.model.testModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRepository extends JpaRepository<testModel, Long> {
}