package com.parkjava.controller;

import com.parkjava.model.noticeModel;
import com.parkjava.model.penaltyModel;
import com.parkjava.repository.penaltyRepository;
import com.parkjava.service.penaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/penalty")
public class penaltyController {

    @Autowired
    private penaltyService penaltyService;

    @Autowired
    private penaltyRepository penaltyRepository;

    @GetMapping("/desc")
    public List<penaltyModel> carNumberDESCAll() {
        return penaltyRepository.carNumberDESCAll();
    }

    @GetMapping("/asc")
    public List<penaltyModel> carNumberASCAll() {
        return penaltyRepository.carNumberASCAll();
    }

    @GetMapping("/{penaltyIndex}")
    public ResponseEntity<penaltyModel> getPenaltyById(@PathVariable Long penaltyIndex) {
        penaltyModel penalty = penaltyService.getPenaltyById(penaltyIndex);
        if (penalty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(penalty);
    }
    // 차량번호로 검색
    @GetMapping("/number/{penaltyCarNumber}")
    public List<penaltyModel> carNumberSearch(@PathVariable("penaltyCarNumber") String penaltyCarNumber) {
        return penaltyRepository.carNumberSearch(penaltyCarNumber);
    }

    // 단속날짜로 검색
    @GetMapping("/date/{penaltyDate}")
    public List<penaltyModel> penaltyDateSearch(@PathVariable("penaltyDate") String penaltyDate) {
        return penaltyRepository.penaltyDateSearch(penaltyDate);
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

    @GetMapping("/countDate")
    public List<Map<String, String>> getPenaltiesCountByDate() {
        return penaltyService.getPenaltiesCountByDate();
    }

}