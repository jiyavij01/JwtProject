package com.Authentication.JwtProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Authentication.JwtProject.Models.College;
import com.Authentication.JwtProject.Repositories.CollegeRepository;

@RestController
@RequestMapping("/api/college")
public class CollegeController {
	
	@Autowired
	private CollegeRepository collegerepo;
	
	@PostMapping("/save")
	public void saveCollege(@RequestBody College col)
	{
		collegerepo.save(col);
	}

	@GetMapping("/getcolleges")
	public List<College> getAllCollege()
	{
		return collegerepo.findAll();
	}
	
	
}

