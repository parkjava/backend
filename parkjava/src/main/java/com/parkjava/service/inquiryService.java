package com.parkjava.service;

import com.parkjava.model.inquiryModel;
import com.parkjava.repository.inquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inquiryService {

    @Autowired
    private inquiryRepository inquiryRepository;

    public List<inquiryModel> getAllUsers() {
        return inquiryRepository.findAll();
    }

    public inquiryModel getUserById(Long inquiryIndex) {
        return inquiryRepository.findById(inquiryIndex).orElse(null);
    }

    public inquiryModel createUser(inquiryModel test) {
        return inquiryRepository.save(test);
    }

    public inquiryModel updateUser(Long id, inquiryModel inquiryDetails) {
        inquiryModel inquiryModel = inquiryRepository.findById(id).orElse(null);

        if (inquiryModel != null) {
            inquiryModel.setInquiryTitle(inquiryDetails.getInquiryTitle());
            inquiryModel.setInquiryContent(inquiryDetails.getInquiryContent());
            inquiryModel.setInquiryPhone(inquiryDetails.getInquiryPhone());
            inquiryModel.setInquiryEmail(inquiryDetails.getInquiryEmail());
            inquiryModel.setInquiryWriter(inquiryDetails.getInquiryWriter());
            inquiryModel.setInquiryDate(inquiryDetails.getInquiryDate());
            return inquiryRepository.save(inquiryModel);
        }

        return null;
    }

    public void deleteUser(Long id) {
        inquiryRepository.deleteById(id);
    }
}