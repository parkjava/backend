package com.parkjava.controller;

import com.parkjava.model.test;
import com.parkjava.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class testController {

	@Autowired
	private testService testService;

	@GetMapping
	public List<test> getAllUsers() {
		return testService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<test> getUserById(@PathVariable Long id) {
		test test = testService.getUserById(id);
		if (test == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(test);
	}

	@PostMapping
	public test createUser(@RequestBody test test) {
		return testService.createUser(test);
	}

	@PutMapping("/{id}")
	public ResponseEntity<test> updateUser(@PathVariable Long id, @RequestBody test testDetails) {
		test updatedTest = testService.updateUser(id, testDetails);
		if (updatedTest == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedTest);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		testService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}