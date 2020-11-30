package com.julianna.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianna.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);

}
