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

    @GetMapping("/{penaltyIndex}")
    public ResponseEntity<penaltyModel> getPenaltyById(@PathVariable Long penaltyIndex) {
        penaltyModel penalty = penaltyService.getPenaltyById(penaltyIndex);
        if (penalty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(penalty);
    }

    @PostMapping("/create")
    public penaltyModel createPenalty(@RequestBody penaltyModel penalty) {
        return penaltyService.createPenalty(penalty);
    }

    @PutMapping("/update/{penaltyIndex}")
    public ResponseEntity<penaltyModel> updatePenalty(@PathVariable Long penaltyIndex, @RequestBody penaltyModel penaltyDetails) {
        penaltyModel updatedTest = penaltyService.updatePenalty(penaltyIndex, penaltyDetails);
        if (updatedTest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/delete/{penaltyIndex}")
    public ResponseEntity<Void> deletePenalty(@PathVariable Long penaltyIndex) {
        penaltyService.deletePenalty(penaltyIndex);
        return ResponseEntity.noContent().build();
    }
}