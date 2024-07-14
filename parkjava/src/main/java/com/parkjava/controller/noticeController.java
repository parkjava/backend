package com.parkjava.controller;

import com.parkjava.model.noticeModel;
import com.parkjava.repository.noticeRepository;
import com.parkjava.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notice")
public class noticeController {

    @Autowired
    private noticeService noticeService;
    @Autowired
    private noticeRepository noticerepository;

    // 공지 전체
    @GetMapping
    public List<noticeModel> noticeSearchAll() {
        return noticerepository.noticeSearchAll();
    }

    // 공지 인덱스 상세
    @GetMapping("/index/{noticeIndex}")
    public noticeModel noticeSearchIndex(@PathVariable("noticeIndex") Long noticeIndex, String noticeView) {
        return noticerepository.noticeSearchIndex(noticeIndex);

    }

    @GetMapping("/{id}")
    public ResponseEntity<noticeModel> getUserById(@PathVariable Long id) {
        noticeModel test = noticeService.getNoticeById(id);
        if (test == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(test);
    }



    // 공지 제목으로 검색
    @GetMapping("/title/{noticeTitle}")
    public List<noticeModel> noticeSearchTitle(@PathVariable("noticeTitle") String noticeTitle) {
        return noticerepository.noticeSearchTitle(noticeTitle);
    }

    // 작성자 이름으로 검색
    @GetMapping("/name/{adminName}")
    public List<noticeModel> noticeSearchName(@PathVariable("adminName") String adminName) {
        return noticerepository.noticeSearchName(adminName);
    }

    // 공지 생성
    @PostMapping("/create")
    public noticeModel createNotice(@RequestBody noticeModel notice) {
        return noticeService.createNotice(notice);
    }

    // 공지 수정
    @PutMapping("/update/{noticeIndex}")
    public ResponseEntity<noticeModel> updateNotice(@PathVariable Long noticeIndex, @RequestBody noticeModel noticeDetails) {
        noticeModel updatedTest = noticeService.updateNotice(noticeIndex, noticeDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    // 공지 삭제
    @DeleteMapping("/delete/{noticeIndex}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeIndex) {
        noticeService.deleteNotice(noticeIndex);
        return ResponseEntity.noContent().build();
    }

    // 공지 제목 오름차순 정렬
    @GetMapping("/title/asc")
    public List<noticeModel> noticeTitleAscAll() {
        return noticerepository.noticeTitleAscAll();
    }

    // 공지 제목 내림차순 정렬
    @GetMapping("/title/desc")
    public List<noticeModel> noticeTitleDescAll() {
        return noticerepository.noticeTitleDescAll();
    }
    // 공지 조회수 오름차순
    @GetMapping("/view/asc")
    public List<noticeModel> noticeViewAscAll() {
        return noticerepository.noticeViewAscAll();
    }

    // 공지 조회수 내림차순
    @GetMapping("/view/desc")
    public List<noticeModel> noticeViewDescAll() {
        return noticerepository.noticeViewDescAll();
    }
}