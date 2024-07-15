package com.parkjava.repository;

import com.parkjava.model.inquiryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface inquiryRepository extends JpaRepository<inquiryModel, Long> {

    @Query(value = "SELECT * FROM INQUIRY ORDER BY INQUIRY_INDEX DESC", nativeQuery = true)
    List<inquiryModel> inquiryDESCAll();

    @Query(value = "SELECT * FROM INQUIRY ORDER BY INQUIRY_INDEX ASC", nativeQuery = true)
    List<inquiryModel> inquiryASCAll();
}