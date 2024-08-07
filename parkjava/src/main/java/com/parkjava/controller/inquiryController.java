package com.parkjava.controller;

import com.parkjava.model.inquiryModel;
import com.parkjava.repository.inquiryRepository;
import com.parkjava.service.inquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/inquiry")
public class inquiryController {

    @Autowired
    private inquiryService inquiryService;
    @Autowired
    private inquiryRepository inquiryRepository;

    @GetMapping
    public List<inquiryModel> inquiryDESCAll() {
        return inquiryRepository.inquiryDESCAll();
    }

    @GetMapping("/asc")
    public List<inquiryModel> inquiryASCAll() {
        return inquiryRepository.inquiryASCAll();
    }

    @GetMapping("/{inquiryIndex}")
    public ResponseEntity<inquiryModel> getUserById(@PathVariable Long inquiryIndex) {
        inquiryModel inquiry = inquiryService.getUserById(inquiryIndex);
        if (inquiry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquiry);
    }

//    @PostMapping("/create")
//    public inquiryModel createUser(@RequestBody inquiryModel inquiry) {
//        return inquiryService.createInquiry(inquiry);
//    }

    @PutMapping("/update/{inquiryIndex}")
    public ResponseEntity<inquiryModel> updateUser(@PathVariable Long inquiryIndex, @RequestBody inquiryModel inquiryDetails) {
        inquiryModel updatedTest = inquiryService.updateInquiry(inquiryIndex, inquiryDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @PutMapping("/answer/{inquiryIndex}")
    public ResponseEntity<inquiryModel> updateAnswer(@PathVariable Long inquiryIndex, @RequestBody inquiryModel inquiryDetails) {
        inquiryModel updatedTest = inquiryService.updateAnswer(inquiryIndex, inquiryDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }


    @DeleteMapping("/delete/{inquiryIndex}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long inquiryIndex) {
        inquiryService.deleteInquiry(inquiryIndex);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/countDate")
    public List<Map<String,String>> getInquiryCountDate() {
        return inquiryService.getInquiryCountByDate();
    }

}