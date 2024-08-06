package com.parkjava.controller;

import com.parkjava.model.patrolModel;
import com.parkjava.repository.patrolRepository;
import com.parkjava.service.patrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/patrol")
public class patrolController {

    @Autowired
    private patrolService patrolService;

    @Autowired
    private patrolRepository patrolRepository;

    @GetMapping
    public List<patrolModel> patrolDESCAll() {
        return patrolRepository.patrolDESCAll();
    }

    @GetMapping("/asc")
    public List<patrolModel> patrolASCAll() {
        return patrolRepository.patrolASCAll();
    }

    @GetMapping("/{patrolIndex}")
    public ResponseEntity<patrolModel> getPatrolById(@PathVariable Long patrolIndex) {
        patrolModel patrol = patrolService.getPatrolById(patrolIndex);
        if (patrol == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patrol);
    }

    @PostMapping("/create")
    public patrolModel createPatrol(@RequestBody patrolModel patrol) {
        return patrolService.createPatrol(patrol);
    }

    @PutMapping("/update/{patrolIndex}")
    public ResponseEntity<patrolModel> updatePatrol(@PathVariable Long patrolIndex, @RequestBody patrolModel patrolDetails) {
        patrolModel updatedTest = patrolService.updatePatrol(patrolIndex, patrolDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/delete/{patrolIndex}")
    public ResponseEntity<Void> deletePatrol(@PathVariable Long patrolIndex) {
        patrolService.deletePatrol(patrolIndex);
        return ResponseEntity.noContent().build();
    }
}