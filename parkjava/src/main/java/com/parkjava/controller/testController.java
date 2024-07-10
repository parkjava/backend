package com.parkjava.controller;

import com.parkjava.model.testModel;
import com.parkjava.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class testController {

	@Autowired
	private testService testService;

	@GetMapping
	public List<testModel> getAllUsers() {
		return testService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<testModel> getUserById(@PathVariable Long id) {
		testModel test = testService.getUserById(id);
		if (test == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(test);
	}

	@PostMapping
	public testModel createUser(@RequestBody testModel test) {
		return testService.createUser(test);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<testModel> updateUser(@PathVariable Long id, @RequestBody testModel testDetails) {
		testModel updatedTest = testService.updateUser(id, testDetails);
		if (updatedTest == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedTest);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		testService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}