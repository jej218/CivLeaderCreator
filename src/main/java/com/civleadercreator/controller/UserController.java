package com.civleadercreator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.civleadercreator.dto.UserDto;
import com.civleadercreator.exceptions.UserAlreadyExistException;
import com.civleadercreator.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}

	@GetMapping("/register")
	public String registerView(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("userDto", userDto);
		return "registration";
	}
	
	@PostMapping("/register")
	public String registration(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
		try {
			if(bindingResult.hasErrors()) {
				model.addAttribute("userDto", userDto);
				return "registration";
			}
			userService.register(userDto);
		}catch (UserAlreadyExistException e) {
			if(bindingResult.hasErrors()) {
				model.addAttribute("userDto", userDto);
				return "registration";
			}
			bindingResult.rejectValue("email",  "userDto.email", "An account has already been created with this email");
			model.addAttribute("userDto", userDto);
			return "registration";
		}
		
		model.addAttribute("user", userDto);
		return "registrationConfirmation";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
}
