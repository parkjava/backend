package com.parkjava.repository;

import com.parkjava.model.noticeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface noticeRepository extends JpaRepository<noticeModel, Long> {

    @Query(value = "SELECT * FROM NOTICE ORDER BY NOTICE_VIEW ASC", nativeQuery = true)
    List<noticeModel> noticeTitleAscAll();

    @Query(value = "SELECT * FROM NOTICE ORDER BY NOTICE_VIEW DESC", nativeQuery = true)
    List<noticeModel> noticeTitleDescAll();

    @Query(value = "SElECT * FROM NOTICE WHERE NOTICE_TITLE = :noticeTitle", nativeQuery = true)
    List<noticeModel> noticeTitleParam(String noticeTitle);

    @Query(value = "SElECT * FROM NOTICE WHERE USER_NAME = :userName", nativeQuery = true)
    List<noticeModel> noticeNameParam(@Param("userName") String userName);


}