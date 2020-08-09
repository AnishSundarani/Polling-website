package com.elections.hacker.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.elections.hacker.model.User;
import com.elections.hacker.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User findByName(String name);

    User save(UserRegistrationDto registration);
    
    User save(User user);
    
    List<User> findAll();
    
    List<User> findByIsAdminFalse();
    
}
