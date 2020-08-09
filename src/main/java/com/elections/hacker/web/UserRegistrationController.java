package com.elections.hacker.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elections.hacker.model.User;
import com.elections.hacker.service.UserService;
import com.elections.hacker.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/create")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model, Authentication authentication) {
    	model.addAttribute("isAdmin", false);
    	try {
    		User user = userService.findByName(authentication.getName());
    		if(user.isAdmin()) {
    			model.addAttribute("isAdmin", true);
    		}
    	}
    	catch(Exception e) {
    		System.out.println("not admin");
    	}
        return "create";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){
    	
        User existing = userService.findByName(userDto.getName());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()){
            return "create";
        }

        userService.save(userDto);
        return "redirect:/create?success";
    }

}
