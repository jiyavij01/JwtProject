package com.Authentication.JwtProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Authentication.JwtProject.Models.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

}
