package com.elections.hacker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elections.hacker.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	List<Subject> findByUser(Long uid);
	
}
