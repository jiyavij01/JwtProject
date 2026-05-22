package com.Authentication.JwtProject.DTO;

public class AuthRequest {
	
	private String email;
	private String password;
	
	public AuthRequest() {}
	
	public AuthRequest(String e, String p)
	{
		this.email=e;
		this.password=p;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
