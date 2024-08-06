package com.parkjava.service;

import com.parkjava.model.patrolModel;
import com.parkjava.repository.patrolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            patrol.setPatrolArea(patrolDetails.getPatrolArea());
            patrol.setPatrolSummary(patrolDetails.getPatrolSummary());

            // 현재 날짜와 시간 설정, 날짜/시/분 형식
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            patrol.setUpdateDate(formattedDateTime);
            return patrolRepository.save(patrol);
        }

        return null;
    }

    public void deletePatrol(Long patrolIndex) {
        patrolRepository.deleteById(patrolIndex);
    }
}