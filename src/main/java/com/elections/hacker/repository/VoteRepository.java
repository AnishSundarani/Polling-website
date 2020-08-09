package com.elections.hacker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elections.hacker.model.User;
import com.elections.hacker.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

	Vote findByIpAdd(String ip);
	
	List<Vote> findByUser(User user);
	
	List<Vote> findAll();
	
	
}
