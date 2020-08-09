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
    public void run(String...args) throws Exception {
    	if(userService.findByName("admin") != null) {
    		System.out.println("Admin already exist");
    	}
    	else {
    		UserRegistrationDto admin = new UserRegistrationDto("admin", "admin", "admin" , true);
    		userService.save(admin);
    	}
    }
}