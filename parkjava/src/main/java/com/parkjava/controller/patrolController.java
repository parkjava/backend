package com.parkjava.controller;

import com.parkjava.service.patrolService;
import com.parkjava.model.patrolModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrol")
public class patrolController {

    private final patrolService patrolService;

    public patrolController(patrolService patrolService) {
        this.patrolService = patrolService;
    }

    @GetMapping
    public List<patrolModel> getAllPatrol() { return patrolService.getAllPatrol(); }

    @GetMapping("/{patrol_index}")
    public ResponseEntity<patrolModel> getUserById(@PathVariable Long patrol_index) {
        patrolModel patrol = patrolService.getPatrolById(patrol_index);
        if (patrol == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patrol);
    }

    @PostMapping
    public patrolModel createPatrol(@RequestBody patrolModel patrol) {
        return patrolService.createPatrol(patrol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<patrolModel> updatePatrol(@PathVariable Long id, @RequestBody patrolModel patrolDetails) {
        patrolModel patrol = patrolService.updatePatrol(id, patrolDetails);
        if (patrol == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patrol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatrol(@PathVariable Long id) {
        patrolService.deletePatrol(id);
        return ResponseEntity.noContent().build();
    }
}
