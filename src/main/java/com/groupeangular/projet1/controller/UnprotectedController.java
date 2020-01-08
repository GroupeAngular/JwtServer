package com.groupeangular.projet1.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unprotected")
@CrossOrigin
public class UnprotectedController {
	
	@GetMapping(produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> accessUnprotectedResource() {
		return ResponseEntity.ok("successfully accessed unprotected resource");
	}

}
