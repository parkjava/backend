package com.parkjava.repository;

import com.parkjava.model.noticeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface noticeRepository extends JpaRepository<noticeModel, Long> {
    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_INDEX DESC", nativeQuery = true)
    List<noticeModel> noticeSearchDESCAll();

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_INDEX ASC", nativeQuery = true)
    List<noticeModel> noticeSearchASCAll();

    @Query(value = "SELECT * FROM notice WHERE NOTICE_INDEX = :noticeIndex", nativeQuery = true)
    noticeModel noticeSearchIndex(Long noticeIndex);

    @Query(value = "SElECT * FROM NOTICE WHERE NOTICE_TITLE LIKE %:noticeTitle%", nativeQuery = true)
    List<noticeModel> noticeSearchTitle(String noticeTitle);

//    @Query(value = "SElECT * FROM NOTICE WHERE ADMIN_NAME LIKE %:adminName%", nativeQuery = true)
//    List<noticeModel> noticeSearchName(String adminName);

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_TITLE ASC", nativeQuery = true)
    List<noticeModel> noticeTitleAscAll();

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_TITLE DESC", nativeQuery = true)
    List<noticeModel> noticeTitleDescAll();

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_VIEW ASC", nativeQuery = true)
    List<noticeModel> noticeViewAscAll();

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_VIEW DESC", nativeQuery = true)
    List<noticeModel> noticeViewDescAll();

    @Query(value = "SELECT * FROM notice ORDER BY NOTICE_INDEX DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<noticeModel> noticePaginate(int limit, int offset);

//    @Query(value ="UPDATE NOTICE SET NOTICE_TITLE= :noticeTitle, NOTICE_CONTENT= :noticeContent, UPDATE_DATE WHERE NOTICE_INDEX =:NOTICE_INDEX", nativeQuery = true)
//    List<noticeModel> noticeUpdate(String noticeTitle, String noticeContent, Long noticeIndex);


}