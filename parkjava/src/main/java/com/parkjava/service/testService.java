package com.parkjava.service;

import com.parkjava.model.testModel;
import com.parkjava.repository.testRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testService {

    @Autowired
    private testRepository testRepository;

    public List<testModel> getAllUsers() {
        return testRepository.findAll();
    }

    public testModel getUserById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public testModel createUser(testModel test) {
        return testRepository.save(test);
    }

    public testModel updateUser(Long id, testModel testDetails) {
        testModel test = testRepository.findById(id).orElse(null);

        if (test != null) {
            test.setName(testDetails.getName());
            test.setEmail(testDetails.getEmail());
            return testRepository.save(test);
        }

        return null;
    }

    public void deleteUser(Long id) {
        testRepository.deleteById(id);
    }
}