package com.parkjava.controller;

import com.parkjava.model.adminModel;
import com.parkjava.service.adminService;
import com.parkjava.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @Autowired
    private adminRepository adminRepository;

    @GetMapping("/find1Admin")
    public List<adminModel> find1Admin(){
        return adminRepository.find1Admin();
    }

    @GetMapping
    public List<adminModel> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{adminIndex}")
    public ResponseEntity<adminModel> getAdminById(@PathVariable Long adminIndex) {
        adminModel admin = adminService.getAdminById(adminIndex);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/create")
    public adminModel createAdmin(@RequestBody adminModel admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/update/{adminIndex}")
    public ResponseEntity<adminModel> updateAdmin(@PathVariable Long adminIndex, @RequestBody adminModel adminDetails) {
        adminModel updateAdmin = adminService.updateAdmin(adminIndex, adminDetails);
        if (updateAdmin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateAdmin);
    }

    @DeleteMapping("/delete/{adminIndex}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminIndex) {
        adminService.deleteAdmin(adminIndex);
        return ResponseEntity.noContent().build();
    }
}