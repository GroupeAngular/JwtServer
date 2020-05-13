package com.groupeangular.projet1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupeangular.projet1.entity.RegistrationUser;
import com.groupeangular.projet1.service.UserService;

@RestController
@RequestMapping("register")
@CrossOrigin
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody RegistrationUser user) {
		if(user != null) {
			userService.registerUser(user);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
