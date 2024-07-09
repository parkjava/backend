package com.parkjava.controller;

import com.parkjava.model.penaltyModel;
import com.parkjava.service.penaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/penalty")
public class penaltyController {

    @Autowired
    private penaltyService penaltyService;

    @GetMapping
    public List<penaltyModel> getAllPenalty() {
        return penaltyService.getAllPenalty();
    }

    @GetMapping("/{id}")
    public ResponseEntity<penaltyModel> getPenaltyById(@PathVariable Long id) {
        penaltyModel penalty = penaltyService.getPenaltyById(id);
        if (penalty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(penalty);
    }

    @PostMapping
    public penaltyModel createPenalty(@RequestBody penaltyModel penalty) {
        return penaltyService.createPenalty(penalty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<penaltyModel> updatePenalty(@PathVariable Long id, @RequestBody penaltyModel penaltyDetails) {
        penaltyModel updatedTest = penaltyService.updatePenalty(id, penaltyDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePenalty(@PathVariable Long id) {
        penaltyService.deletePenalty(id);
        return ResponseEntity.noContent().build();
    }
}