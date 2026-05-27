package com.Authentication.JwtProject.Security;

import org.springframework.stereotype.Service;

import com.Authentication.JwtProject.Models.AppUser;
import com.Authentication.JwtProject.Repositories.UserRepository;

import java.util.Collections;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository user_repo;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		AppUser user = user_repo.findByEmail(email).orElseThrow(() -> 
		new UsernameNotFoundException("User not found"));
		return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
	}
}
