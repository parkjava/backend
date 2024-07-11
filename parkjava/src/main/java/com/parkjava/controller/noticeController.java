package com.parkjava.controller;

import com.parkjava.model.noticeModel;
import com.parkjava.repository.noticeRepository;
import com.parkjava.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notice")
public class noticeController {

    @Autowired
    private noticeService noticeService;
    @Autowired
    private noticeRepository noticerepository;

    @GetMapping
    public List<noticeModel> getAllNotice() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{noticeIndex}")
    public ResponseEntity<noticeModel> getNoticeById(@PathVariable Long noticeIndex) {
        noticeModel notice = noticeService.getNoticeById(noticeIndex);
        if (notice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notice);
    }

    @GetMapping("/titleAsc")
    public List<noticeModel> noticeTitleAscAll() {
        return noticerepository.noticeTitleAscAll();
    }

    @GetMapping("/titleDesc")
    public List<noticeModel> noticeTitleDescAll() {
        return noticerepository.noticeTitleDescAll();
    }

    @GetMapping("/title/{noticeTitle}")
    public List<noticeModel> noticeTitleParam(@PathVariable("noticeTitle") String noticeTitle) {
        return noticerepository.noticeTitleParam(noticeTitle);
    }

    @GetMapping("/name/{userName}")
    public List<noticeModel> noticeNameParam(@PathVariable("userName") String userName) {
        return noticerepository.noticeNameParam(userName);
    }


    @PostMapping("/create")
    public noticeModel createNotice(@RequestBody noticeModel notice) {
        return noticeService.createNotice(notice);
    }

    @PutMapping("/update/{noticeIndex}")
    public ResponseEntity<noticeModel> updateNotice(@PathVariable Long noticeIndex, @RequestBody noticeModel noticeDetails) {
        noticeModel updatedTest = noticeService.updateNotice(noticeIndex, noticeDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/delete/{noticeIndex}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeIndex) {
        noticeService.deleteNotice(noticeIndex);
        return ResponseEntity.noContent().build();
    }
}