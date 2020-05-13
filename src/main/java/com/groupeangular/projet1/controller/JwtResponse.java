package com.groupeangular.projet1.controller;

public class JwtResponse {
	
	private final String jwtToken;
	
	private final String username;
	
	public JwtResponse(String jwtToken, String username) {
		this.jwtToken = jwtToken;
		this.username = username;
	}
	
	public String getJwtToken() {
		return jwtToken;
	}
	
	public String getUsername() {
		return username;
	}

}
