package com.elections.hacker.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @Column(nullable = true)
    private int challengeCount;
    
    @Column(nullable = true)
    private int totalExpertise;
    
    @Column(nullable = true)
    private int vote;
    
    private boolean isAdmin;
    
    @JsonBackReference
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    
    @JsonBackReference
    private Collection<Role> roles;

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subjects;
	
	
    public User() {
    }

    
    
    public int getVote() {
		return vote;
	}



	public void setVote(int vote) {
		this.vote = vote;
	}



	public Set<Subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	public User(String name, boolean isAdmin, String password) {
		super();
		this.name = name;
		this.isAdmin = isAdmin;
		this.password = password;
	}



	public User(String name, int challengeCount, int totalExpertise, String password, boolean isAdmin) {
		super();
		this.name = name;
		this.challengeCount = challengeCount;
		this.totalExpertise = totalExpertise;
		this.password = password;
		this.isAdmin = isAdmin;
	}

   

    public Collection<Role> getRoles() {
		return roles;
	}



	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getChallengeCount() {
		return challengeCount;
	}



	public void setChallengeCount(int challengeCount) {
		this.challengeCount = challengeCount;
	}



	public int getTotalExpertise() {
		return totalExpertise;
	}



	public void setTotalExpertise(int expertise) {
		this.totalExpertise = expertise;
	}



	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



	@Override
	public String toString() {
		return "User [name=" + name + ", challengeCount=" + challengeCount + ", totalExpertise=" + totalExpertise
				+ ", vote=" + vote + ", subjects=" + subjects + "]";
	}




	


}
