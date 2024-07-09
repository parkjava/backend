package com.parkjava.repository;

import com.parkjava.model.penaltyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface penaltyRepository extends JpaRepository<penaltyModel, Long>{
}
