package com.gutotech.course.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gutotech.course.entities.User;
import com.gutotech.course.repositories.UserRepository;
import com.gutotech.course.services.exceptions.ResourceNotFoundExeception;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeception(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public User update(long id, User user) {
		try {
			User currentUser = repository.getOne(id);
			currentUser.setName(user.getName());
			currentUser.setEmail(user.getEmail());
			currentUser.setPhone(user.getPhone());
			return repository.save(currentUser);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExeception(id);
		}
	}

	public void delete(long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeception(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
