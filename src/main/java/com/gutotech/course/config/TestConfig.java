package com.gutotech.course.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gutotech.course.entities.User;
import com.gutotech.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(List.of(user1, user2));
	}

}
