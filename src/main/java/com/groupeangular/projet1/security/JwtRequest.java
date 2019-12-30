package com.groupeangular.projet1.security;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2718490701494762320L;

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
