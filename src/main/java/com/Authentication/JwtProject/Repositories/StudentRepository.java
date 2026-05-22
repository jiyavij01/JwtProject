package com.Authentication.JwtProject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Authentication.JwtProject.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByCollegeId(Long c_id);

}
