package com.elections.hacker.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elections.hacker.model.User;
import com.elections.hacker.model.Vote;
import com.elections.hacker.repository.VoteRepository;
import com.elections.hacker.service.UserService;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	UserService userService;

	@Autowired
	VoteRepository vR;

	@PostMapping("/{name}")
	public String addVote(@PathVariable("name") String name, Authentication authentication, HttpServletRequest request) {
		User user = userService.findByName(name);
		String username="";
		try{
			username = authentication.getName();

		}
		catch(Exception e){
			username = request.getRemoteAddr();
		}
		if (vR.findByIpAdd(username) == null) {
			Vote vote = new Vote(username, user);
			vR.save(vote);
			user.setVote(user.getVote()+1);
			userService.save(user);
		}
		return "done";
	}

}
