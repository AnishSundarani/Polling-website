package com.elections.hacker.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elections.hacker.model.Role;
import com.elections.hacker.model.User;
import com.elections.hacker.repository.UserRepository;
import com.elections.hacker.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    
    @Override
	public User findByName(String name) {
		return userRepository.findByNameIgnoreCase(name);
	}

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setName(registration.getName());
        user.setChallengeCount(registration.getChallengeCount());
        user.setTotalExpertise(registration.getTotalExpertise());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByNameIgnoreCase(name);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));

    }
    
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByIsAdminFalse() {
		// TODO Auto-generated method stub
		return userRepository.findByIsAdminFalse();
	}

}
