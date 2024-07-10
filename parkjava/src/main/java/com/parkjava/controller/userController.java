package com.parkjava.controller;

import com.parkjava.model.userModel;
import com.parkjava.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class userController {

    @Autowired
    private userService userService;

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

    @PostMapping
    public userModel createUser(@RequestBody userModel user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{userIndex}")
    public ResponseEntity<userModel> updateUser(@PathVariable Long userIndex, @RequestBody userModel userDetails) {
        userModel updateduser = userService.updateUser(userIndex, userDetails);
        if (updateduser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateduser);
    }

    @DeleteMapping("/delete/{userIndex}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userIndex) {
        userService.deleteUser(userIndex);
        return ResponseEntity.noContent().build();
    }
}