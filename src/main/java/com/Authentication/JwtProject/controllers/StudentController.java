package com.Authentication.JwtProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Authentication.JwtProject.Models.College;
import com.Authentication.JwtProject.Models.Student;
import com.Authentication.JwtProject.Repositories.CollegeRepository;
import com.Authentication.JwtProject.Repositories.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentRepository studentrepo;
	
	@Autowired 
	private CollegeRepository collegerepo;
	
	
	@PostMapping("/save/{id}")
	public void saveStudent (@RequestBody Student std, @PathVariable Long id)
	{
		College col=collegerepo.findById(id).orElseThrow(()-> new RuntimeException("college not found"));
		std.setCollege(col);
		studentrepo.save(std);
	}
	
	@GetMapping("/getstudent")
	public List<Student> getStudents()
	{
		return studentrepo.findAll();
	}
	
}
