package com.groupeangular.projet1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupeangular.projet1.dao.UserDAO;
import com.groupeangular.projet1.entity.RegistrationUser;
import com.groupeangular.projet1.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Optional<User> findByUsername(String username) {
		User user = this.userDAO.findByUsername(username);
		return user == null ? Optional.empty() : Optional.of(user);
	}
	
	public void registerUser(RegistrationUser registration) {
		//TODO check username and password are valid
		User user = this.userDAO.findByUsername(registration.getUsername());
		if(user == null) {
			user = new User();
			user.setUsername(registration.getUsername());
			user.setPassword(this.bCryptPasswordEncoder.encode(registration.getPassword()));
			userDAO.save(user);
		} else {
			//TODO error user already exists
		}
	}

}
