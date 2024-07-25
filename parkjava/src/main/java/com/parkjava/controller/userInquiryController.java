package com.parkjava.controller;

import com.parkjava.model.inquiryModel;
import com.parkjava.repository.inquiryRepository;
import com.parkjava.service.inquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user/api/inquiry")
public class userInquiryController {

    @Autowired
    private inquiryService inquiryService;
    @Autowired
    private inquiryRepository inquiryRepository;

    @GetMapping
    public List<inquiryModel> inquiryDESCAll(Long inquiryIndex) {
        return inquiryRepository.inquiryDESCAll();
    }

    @GetMapping("/phone/{inquiryPhone}")
    public List<inquiryModel> inquiryListAll(@PathVariable String inquiryPhone) {
        return inquiryRepository.inquiryListAll(inquiryPhone);
    }

    @GetMapping("/{inquiryIndex}")
    public ResponseEntity<inquiryModel> getUserById(@PathVariable Long inquiryIndex) {
        inquiryModel inquiry = inquiryService.getUserById(inquiryIndex);
        if (inquiry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquiry);
    }

    @PostMapping("/create")
    public inquiryModel createUser(@RequestBody inquiryModel inquiry) {
        return inquiryService.createUser(inquiry);
    }

    @PutMapping("/update/{inquiryIndex}")
    public ResponseEntity<inquiryModel> updateUser(@PathVariable Long inquiryIndex, @RequestBody inquiryModel inquiryDetails) {
        inquiryModel updatedTest = inquiryService.updateUser(inquiryIndex, inquiryDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

}