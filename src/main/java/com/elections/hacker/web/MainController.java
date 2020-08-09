package com.elections.hacker.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.elections.hacker.model.User;
import com.elections.hacker.model.Vote;
import com.elections.hacker.repository.VoteRepository;
import com.elections.hacker.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	VoteRepository vR;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}
	
	@GetMapping("/nav")
	public String nav(Model model, Authentication authentication, HttpServletRequest request) {
		try{
			String username = authentication.getName();
			model.addAttribute("username", username);
			model.addAttribute("isAuth", true);

		}
		catch(Exception e){
			model.addAttribute("username", request.getRemoteAddr());
			model.addAttribute("isAuth", false);
		}
		return "nav";
	}

	@GetMapping("/home")
	public String home(Model model, Authentication authentication, HttpServletRequest request) {
		try{
			String username = authentication.getName();
			model.addAttribute("username", username);
			model.addAttribute("isAuth", true);

		}
		catch(Exception e){
			model.addAttribute("username", request.getRemoteAddr());
			model.addAttribute("isAuth", false);
		}
		model.addAttribute("candidate", userService.findByIsAdminFalse());
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "auth/login";
	}
	
	@GetMapping("/candidate/{name}")
	public String candidateDetails(@PathVariable("name") String name, Model model, Authentication authentication, HttpServletRequest request) {
		User user = userService.findByName(name);
		String username = "";
		try{
			username = authentication.getName();

		}
		catch(Exception e){
			username = request.getRemoteAddr();
		}
		if(vR.findByIpAdd(username) != null) {
			model.addAttribute("disable", true);
		}
		else
			model.addAttribute("disable", false);
		System.out.println(user.toString());
		model.addAttribute("ip", request.getRemoteAddr());
		model.addAttribute("User", user);
		List<Vote> lV = vR.findByUser(user);
		model.addAttribute("votes", lV.size());
		return "candidate";
		
	}
}
