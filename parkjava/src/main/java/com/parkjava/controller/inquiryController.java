package com.parkjava.controller;

import com.parkjava.model.inquiryModel;
import com.parkjava.service.inquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/inquiry")
public class inquiryController {

    @Autowired
    private inquiryService inquiryService;

    @GetMapping
    public List<inquiryModel> getAllUsers() {
        return inquiryService.getAllUsers();
    }

    @GetMapping("/{inquiryIndex}")
    public ResponseEntity<inquiryModel> getUserById(@PathVariable Long inquiryIndex) {
        inquiryModel inquiry = inquiryService.getUserById(inquiryIndex);
        if (inquiry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inquiry);
    }

    @PostMapping
    public inquiryModel createUser(@RequestBody inquiryModel inquiry) {
        return inquiryService.createUser(inquiry);
    }

    @PutMapping("/{inquiryIndex}")
    public ResponseEntity<inquiryModel> updateUser(@PathVariable Long inquiryIndex, @RequestBody inquiryModel inquiryDetails) {
        inquiryModel updatedTest = inquiryService.updateUser(inquiryIndex, inquiryDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{inquiryIndex}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long inquiryIndex) {
        inquiryService.deleteUser(inquiryIndex);
        return ResponseEntity.noContent().build();
    }
}