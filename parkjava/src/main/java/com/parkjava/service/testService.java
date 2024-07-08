package com.parkjava.service;

import com.parkjava.model.test;
import com.parkjava.repository.testRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testService {

    @Autowired
    private testRepository testRepository;

    public List<test> getAllUsers() {
        return testRepository.findAll();
    }

    public test getUserById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public test createUser(test test) {
        return testRepository.save(test);
    }

    public test updateUser(Long id, test testDetails) {
        test test = testRepository.findById(id).orElse(null);

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