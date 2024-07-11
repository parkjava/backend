package com.parkjava.controller;

import com.parkjava.model.usersModel;
import com.parkjava.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class usersController {

    private final usersService usersService;

    public usersController(usersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<usersModel> getAllUsers(){ return usersService.getAllUsers(); }

    @GetMapping("/{user_index}")
    public ResponseEntity<usersModel> getUserById(@PathVariable Long user_index) {
        usersModel user = usersService.getUserById(user_index);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public usersModel createUser(@RequestBody usersModel user) {
        return usersService.createUsers(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usersModel> updateUser(@PathVariable Long id, @RequestBody usersModel userDetails) {
        usersModel updateUser = usersService.updateUsers(id,userDetails);
        if (updateUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.noContent().build();
    }
}
