package com.parkjava.service;

import com.parkjava.model.inquiryModel;
import com.parkjava.repository.inquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


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

    public inquiryModel createInquiry(inquiryModel test) {
        return inquiryRepository.save(test);
    }

    public inquiryModel updateInquiry(Long id, inquiryModel inquiryDetails) {
        inquiryModel inquiryModel = inquiryRepository.findById(id).orElse(null);

        if (inquiryModel != null) {
            inquiryModel.setInquiryTitle(inquiryDetails.getInquiryTitle());
            inquiryModel.setInquiryContent(inquiryDetails.getInquiryContent());
            inquiryModel.setInquiryPhone(inquiryDetails.getInquiryPhone());
            inquiryModel.setInquiryEmail(inquiryDetails.getInquiryEmail());
            inquiryModel.setInquiryWriter(inquiryDetails.getInquiryWriter());
            inquiryModel.setInquiryDate(inquiryDetails.getInquiryDate());
            inquiryModel.setInquiryAnswer(inquiryDetails.getInquiryAnswer());
            return inquiryRepository.save(inquiryModel);
        }

        return null;
    }

    public inquiryModel updateAnswer(Long id, inquiryModel inquiryDetails) {
        inquiryModel inquiryModel = inquiryRepository.findById(id).orElse(null);

        if (inquiryModel != null) {
            inquiryModel.setInquiryAnswer(inquiryDetails.getInquiryAnswer());
            return inquiryRepository.save(inquiryModel);
        }

        return null;
    }

    public void deleteInquiry(Long inquiryIndex) {
        inquiryRepository.deleteById(inquiryIndex);
    }

    public List<Map<String,String>> getInquiryCountByDate(){
        List<Object[]> results = inquiryRepository.countInquiryByDate();
        List<Map<String,String>> inquiryResults = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Object[] result : results) {
            Date date = (Date) result[0];
            Long count = (Long) result[1];
            Map<String,String> resultMap = new HashMap<>();
            resultMap.put("inquiryDate", dateFormat.format(date));
            resultMap.put("count", count.toString());
            inquiryResults.add(resultMap);
        }
        return inquiryResults;
    }
}