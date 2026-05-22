package com.Authentication.JwtProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Authentication.JwtProject.DTO.AuthRequest;
import com.Authentication.JwtProject.DTO.AuthResponse;
import com.Authentication.JwtProject.DTO.RegistrationRequest;
import com.Authentication.JwtProject.Models.AppUser;
import com.Authentication.JwtProject.Repositories.UserRepository;
import com.Authentication.JwtProject.Security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public String register(@RequestBody RegistrationRequest request)
	{
		AppUser user = new AppUser();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userrepo.save(user);
		return "user registered successfully";
	}
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest request)
	{
		authenticationmanager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		String token=jwtUtil.generateToken(request.getEmail());
		return new AuthResponse(token);
	}
}

