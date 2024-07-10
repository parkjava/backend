package com.parkjava.service;

import com.parkjava.model.patrolModel;
import com.parkjava.repository.patrolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patrolService {

    @Autowired
    private patrolRepository patrolRepository;

    public List<patrolModel> getAllPatrols() {
        return patrolRepository.findAll();
    }

    public patrolModel getPatrolById(Long patrolIndex) {
        return patrolRepository.findById(patrolIndex).orElse(null);
    }

    public patrolModel createPatrol(patrolModel patrol) {
        return patrolRepository.save(patrol);
    }

    public patrolModel updatePatrol(Long patrolIndex, patrolModel patrolDetails) {
        patrolModel patrol = patrolRepository.findById(patrolIndex).orElse(null);

        if (patrol != null) {
            patrol.setUserIndex(patrolDetails.getUserIndex());
            patrol.setUserName(patrolDetails.getUserName());
            patrol.setPatrolArea(patrolDetails.getPatrolArea());
            patrol.setPatrolSummary(patrolDetails.getPatrolSummary());
            patrol.setCreateDate(patrolDetails.getCreateDate());
            patrol.setUpdateDate(patrolDetails.getUpdateDate());
            return patrolRepository.save(patrol);
        }

        return null;
    }

    public void deletePatrol(Long patrolIndex) {
        patrolRepository.deleteById(patrolIndex);
    }
}