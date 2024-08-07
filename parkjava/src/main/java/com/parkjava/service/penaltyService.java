package com.parkjava.service;

import com.parkjava.model.penaltyModel;
import com.parkjava.repository.penaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class penaltyService {

    @Autowired
    private penaltyRepository penaltyRepository;

    public List<penaltyModel> getAllPenalty() {
        return penaltyRepository.findAll();
    }

    public penaltyModel getPenaltyById(Long penaltyIndex) {
        return penaltyRepository.findById(penaltyIndex).orElse(null);
    }

    public penaltyModel createPenalty(penaltyModel penalty) {
        return penaltyRepository.save(penalty);
    }

    public penaltyModel updatePenalty(Long penaltyIndex, penaltyModel penaltyDetails) {
        penaltyModel penalty = penaltyRepository.findById(penaltyIndex).orElse(null);

        if (penalty != null) {
            penalty.setPenaltyImageUrl(penaltyDetails.getPenaltyImageUrl());
            penalty.setPenaltyCarNumber(penaltyDetails.getPenaltyCarNumber());
            penalty.setPenaltyCash(penalty.getPenaltyCash());
            penalty.setPenaltyDate(penalty.getPenaltyDate());
            return penaltyRepository.save(penalty);
        }

        return null;
    }

    public void deletePenalty(Long penaltyIndex) {
        penaltyRepository.deleteById(penaltyIndex);
    }

    public List<Map<String,String>> getPenaltiesCountByDate() {
        List<Object[]> results = penaltyRepository.countPenaltiesByDate();
        List<Map<String, String>> formattedResults = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Object[] result : results) {
            Date date = (Date) result[0];
            Long count = (Long) result[1];
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("penaltyDate", dateFormat.format(date));
            resultMap.put("count", count.toString());
            formattedResults.add(resultMap);
        }

        return formattedResults;
    }
}