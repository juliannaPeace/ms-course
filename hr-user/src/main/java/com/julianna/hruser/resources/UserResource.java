package com.julianna.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julianna.hruser.entities.User;
import com.julianna.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();

		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User user = userRepository.findByEmail(email);

		return ResponseEntity.ok().body(user);
	}
}
