package com.elections.hacker.web.dto;

import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

    @NotEmpty
    private String name;
    
    private int challengeCount;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    private int totalExpertise;
	
    private boolean isAdmin;
    

    public UserRegistrationDto(@NotEmpty String name, @NotEmpty String password, @NotEmpty String confirmPassword,
			boolean isAdmin) {
		super();
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.isAdmin = isAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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


	public void setTotalExpertise(int totalExpertise) {
		this.totalExpertise = totalExpertise;
	}

	public UserRegistrationDto() {
		super();
	}

    

}
