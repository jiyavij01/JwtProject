package com.Authentication.JwtProject.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Authentication.JwtProject.Models.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByEmail(String email);
}
