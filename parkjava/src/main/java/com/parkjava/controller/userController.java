package com.parkjava.controller;

import com.parkjava.model.userModel;
import com.parkjava.service.userService;
import com.parkjava.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private userRepository userRepository;

    @GetMapping("/find1User")
    public List<userModel> find1User(){
        return userRepository.find1User();
    }

    @GetMapping
    public List<userModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userIndex}")
    public ResponseEntity<userModel> getUserById(@PathVariable Long userIndex) {
        userModel user = userService.getUserById(userIndex);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{userIndex}")
    public ResponseEntity<userModel> updateUser(@PathVariable Long userIndex, @RequestBody userModel userDetails) {
        userModel updateUser = userService.updateUser(userIndex, userDetails);
        if (updateUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/delete/{userIndex}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userIndex) {
        userService.deleteUser(userIndex);
        return ResponseEntity.noContent().build();
    }
}