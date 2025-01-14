package com.parkjava.repository;

import com.parkjava.model.inquiryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface inquiryRepository extends JpaRepository<inquiryModel, Long> {

    @Query(value = "SELECT * FROM inquiry ORDER BY INQUIRY_INDEX DESC", nativeQuery = true)
    List<inquiryModel> inquiryDESCAll();

    @Query(value = "SELECT * FROM inquiry ORDER BY INQUIRY_INDEX ASC", nativeQuery = true)
    List<inquiryModel> inquiryASCAll();

    @Query(value = "SELECT * FROM inquiry WHERE INQUIRY_PHONE = :inquiryPhone", nativeQuery = true)
    List<inquiryModel> inquiryListAll(String inquiryPhone);

    @Query("SELECT DATE(i.inquiryDate) AS inquiryDate, COUNT(i) AS count FROM inquiryModel i GROUP BY DATE(i.inquiryDate)")
    List<Object[]> countInquiryByDate();

//    @Query(value = "UPDATE INQUIRY SET INQUIRY_ANSWER = :inquiryAnswer WHERE INQUIRY_INDEX = :inquiryIndex", nativeQuery = true)
//    inquiryModel inquiryAnswer(Long inquiryIndex);
}