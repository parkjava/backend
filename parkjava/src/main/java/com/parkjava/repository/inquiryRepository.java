package com.parkjava.repository;

import com.parkjava.model.inquiryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inquiryRepository extends JpaRepository<inquiryModel, Long> {
}