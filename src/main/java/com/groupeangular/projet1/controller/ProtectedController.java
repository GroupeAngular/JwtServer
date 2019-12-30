package com.groupeangular.projet1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class ProtectedController {

	@GetMapping
	public ResponseEntity<String> test2() {
		return ResponseEntity.ok("successfully accessed protected resource");
	}
	
}
