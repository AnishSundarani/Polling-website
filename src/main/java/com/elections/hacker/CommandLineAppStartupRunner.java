package com.elections.hacker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.elections.hacker.service.UserService;
import com.elections.hacker.web.dto.UserRegistrationDto;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
		if (userService.findByName("admin") != null) {
			System.out.println("Admin already exist");
		} else {
			UserRegistrationDto admin = new UserRegistrationDto("admin", "admin", "admin", true);
			admin.setAdmin(true);
			userService.save(admin);
		}

		if (userService.findByName("anish") == null) {
			UserRegistrationDto user1 = new UserRegistrationDto("anish", 15, "pass", "pass", 5, false);
			userService.save(user1);
		}

		if (userService.findByName("sundarani") == null) {
			UserRegistrationDto user2 = new UserRegistrationDto("sundarani", 15, "pass", "pass", 5, false);
			userService.save(user2);
		}
		if (userService.findByName("hacker123") == null) {
			UserRegistrationDto user3 = new UserRegistrationDto("hacker123", 15, "pass", "pass", 5, false);
			userService.save(user3);
		}
	}
}