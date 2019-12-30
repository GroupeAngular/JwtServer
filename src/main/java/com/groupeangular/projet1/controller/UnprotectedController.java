package com.groupeangular.projet1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unprotected")
public class UnprotectedController {
	
	@GetMapping
	public ResponseEntity<String> accessUnprotectedResource() {
		return ResponseEntity.ok("successfully accessed unprotected resource");
	}

}
