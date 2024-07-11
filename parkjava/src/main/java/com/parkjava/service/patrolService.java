package com.parkjava.service;

import com.parkjava.model.patrolModel;
import com.parkjava.model.usersModel;
import com.parkjava.repository.patrolRepository;
import com.parkjava.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patrolService {

    @Autowired
    private patrolRepository patrolRepository;

    @Autowired
    private usersRepository usersRepository;

    public void savePatrolWithUsers(patrolModel patrol,long patrolId) {
        usersModel users = usersRepository.findById(patrolId).orElse(null);
        patrol.setUsers(users);
        patrolRepository.save(patrol);
    }

    public List<patrolModel> getAllPatrol() { return patrolRepository.findAll(); }

    public patrolModel getPatrolById(long patrolId) { return patrolRepository.findById(patrolId).orElse(null); }

    public patrolModel createPatrol(patrolModel patrol) {
        return patrolRepository.save(patrol);
    }

    public patrolModel updatePatrol(long patrolId, patrolModel patrolDetails) {
        patrolModel patrol = patrolRepository.findById(patrolId).orElse(null);

        if (patrol != null) {
            patrol.setPatrol_area(patrolDetails.getPatrol_area());
            patrol.setPatrol_summary(patrolDetails.getPatrol_summary());
            patrol.setUser_name(patrolDetails.getUser_name());
            patrol.setUpdate_date(patrolDetails.getUpdate_date());
            patrol.setCreate_date(patrolDetails.getCreate_date());

            return patrolRepository.save(patrol);

        }
        return null;
    }
    public void deletePatrol(long patrolId) {
        usersRepository.deleteById(patrolId);
    }
}
