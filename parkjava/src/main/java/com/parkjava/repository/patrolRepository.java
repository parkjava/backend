package com.parkjava.repository;

import com.parkjava.model.patrolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface patrolRepository extends JpaRepository<patrolModel, Long> {
    @Query(value="SELECT * FROM PATROL ORDER BY PATROL_INDEX DESC", nativeQuery = true)
    List<patrolModel> patrolDESCAll();
}
