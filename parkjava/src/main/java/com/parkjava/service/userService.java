package com.parkjava.service;

import com.parkjava.model.userModel;
import com.parkjava.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    public List<userModel> getAllUsers() {
        return userRepository.findAll();
    }

    public userModel getUserById(Long userIndex) {
        return userRepository.findById(userIndex).orElse(null);
    }

    public userModel createUser(userModel test) {
        return userRepository.save(test);
    }

    public userModel updateUser(Long id, userModel userDetails) {
        userModel userModel = userRepository.findById(id).orElse(null);

        if (userModel != null) {
            userModel.setUserName(userDetails.getUserName());
            userModel.setUserId(userDetails.getUserId());
            userModel.setUserPassword(userDetails.getUserPassword());
            return userRepository.save(userModel);
        }

        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}