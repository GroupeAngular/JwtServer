package com.groupeangular.projet1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupeangular.projet1.dao.UserDAO;
import com.groupeangular.projet1.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public Optional<User> findByUsername(String username) {
		User user = this.userDAO.findByUsername(username);
		return user == null ? Optional.empty() : Optional.of(user);
	}

}
