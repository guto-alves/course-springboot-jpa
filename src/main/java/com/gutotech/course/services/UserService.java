package com.gutotech.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.course.entities.User;
import com.gutotech.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(long id) {
		return repository.findById(id).get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
}
