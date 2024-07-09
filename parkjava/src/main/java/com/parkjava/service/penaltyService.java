package com.parkjava.service;

import com.parkjava.model.penaltyModel;
import com.parkjava.repository.penaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            penalty.setImageUrl(penaltyDetails.getImageUrl());
            penalty.setCarNumber(penaltyDetails.getCarNumber());
            penalty.setPenaltyCash(penalty.getPenaltyCash());
            penalty.setFineDate(penalty.getFineDate());
            return penaltyRepository.save(penalty);
        }

        return null;
    }

    public void deletePenalty(Long penaltyIndex) {
        penaltyRepository.deleteById(penaltyIndex);
    }
}