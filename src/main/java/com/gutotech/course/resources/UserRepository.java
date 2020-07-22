package com.gutotech.course.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutotech.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
