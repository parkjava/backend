package com.parkjava.repository;


import com.parkjava.model.penaltyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface penaltyRepository extends JpaRepository<penaltyModel, Long>{

    @Query(value="SELECT * FROM PENALTY ORDER BY PENALTY_INDEX DESC", nativeQuery = true)
    List<penaltyModel> carNumberDESCAll();

    @Query(value="SELECT * FROM PENALTY ORDER BY PENALTY_INDEX DESC", nativeQuery = true)
    List<penaltyModel> carNumberASCAll();

    @Query(value = "SElECT * FROM PENALTY WHERE PENALTY_CAR_NUMBER LIKE %:penaltyCarNumber%", nativeQuery = true)
    List<penaltyModel> carNumberSearch(String penaltyCarNumber);

    @Query(value = "SElECT * FROM PENALTY WHERE PENALTY_DATE LIKE %:penaltyDate%", nativeQuery = true)
    List<penaltyModel> penaltyDateSearch(String penaltyDate);

    @Query(value = "SELECT * FROM PENALTY WHERE PENALTY_INDEX =:penaltyIndex", nativeQuery = true)
    List<penaltyModel> penaltyIndexSearch(String penaltyIndex);

//    @Query("SELECT p.penaltyDate, COUNT(p) FROM penaltyModel p GROUP BY p.penaltyDate")
//    List<Object[]> countPenaltiesByDate();
    @Query("SELECT DATE(p.penaltyDate) AS penaltyDate, COUNT(p) AS count FROM penaltyModel p GROUP BY DATE(p.penaltyDate)")
    List<Object[]> countPenaltiesByDate();
}
