package com.elections.hacker.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ipAdd;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public String getIpAdd() {
		return ipAdd;
	}

	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vote() {
		super();
	}

	public Vote(String ipAdd, User user) {
		super();
		this.ipAdd = ipAdd;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", ipAdd=" + ipAdd + ", user=" + user + "]";
	}
	
	
}
