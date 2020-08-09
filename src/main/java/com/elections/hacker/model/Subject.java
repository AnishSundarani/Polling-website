package com.elections.hacker.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String subjectName;
	
	private int expertise;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Subject() {
	}

	

	public Subject(String subjectName, int expertise, User user) {
		super();
		this.subjectName = subjectName;
		this.expertise = expertise;
		this.user = user;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public int getExpertise() {
		return expertise;
	}



	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
