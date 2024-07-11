package com.parkjava.service;

import com.parkjava.model.adminModel;
import com.parkjava.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService {

    @Autowired
    private adminRepository adminRepository;

    public List<adminModel> getAllAdmins() {
        return adminRepository.findAll();
    }

    public adminModel getAdminById(Long adminIndex) {
        return adminRepository.findById(adminIndex).orElse(null);
    }

    public adminModel createAdmin(adminModel test) {
        return adminRepository.save(test);
    }

    public adminModel updateAdmin(Long adminIndex, adminModel adminDetails) {
        adminModel adminModel = adminRepository.findById(adminIndex).orElse(null);

        if (adminModel != null) {
            adminModel.setAdminName(adminDetails.getAdminName());
            adminModel.setAdminId(adminDetails.getAdminId());
            adminModel.setAdminPassword(adminDetails.getAdminPassword());
            return adminRepository.save(adminModel);
        }

        return null;
    }

    public void deleteAdmin(Long adminIndex) {
        adminRepository.deleteById(adminIndex);
    }
}