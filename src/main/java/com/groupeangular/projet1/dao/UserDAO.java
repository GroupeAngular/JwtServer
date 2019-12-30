package com.groupeangular.projet1.dao;

import org.springframework.data.repository.CrudRepository;

import com.groupeangular.projet1.entity.User;

public interface UserDAO extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
