package com.gutotech.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.course.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Gustavo", "1234-5678", "root", "toor");
		return ResponseEntity.ok(user);
	}

}
