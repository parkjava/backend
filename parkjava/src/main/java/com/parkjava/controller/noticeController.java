package com.parkjava.controller;

import com.parkjava.model.noticeModel;
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

    @GetMapping
    public List<noticeModel> getAllNotice() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<noticeModel> getNoticeById(@PathVariable Long id) {
        noticeModel notice = noticeService.getNoticeById(id);
        if (notice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notice);
    }

    @PostMapping
    public noticeModel createNotice(@RequestBody noticeModel notice) {
        return noticeService.createNotice(notice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<noticeModel> updateNotice(@PathVariable Long id, @RequestBody noticeModel noticeDetails) {
        noticeModel updatedTest = noticeService.updateNotice(id, noticeDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}