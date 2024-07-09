package com.parkjava.repository;

import com.parkjava.model.noticeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface noticeRepository extends JpaRepository<noticeModel, Long> {
}