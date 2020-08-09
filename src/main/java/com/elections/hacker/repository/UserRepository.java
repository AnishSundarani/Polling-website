package com.elections.hacker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elections.hacker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByNameIgnoreCase(String username);
	
	List<User> findAll();
	
	List<User> findByIsAdminFalse();
}
