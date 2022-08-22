package com.civleadercreator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.civleadercreator.dto.LeaderDto;
import com.civleadercreator.entity.Leader;
import com.civleadercreator.entity.User;
import com.civleadercreator.service.LeaderService;
import com.civleadercreator.service.UserService;

@Controller
@RequestMapping("/leader")
public class LeaderController {
	
	@Autowired
	private LeaderService leaderService;
	@Autowired
	private UserService userService;
	

	@GetMapping(value="/index")
	public String indexLeader(Model model) {
		List<Leader> leaders = leaderService.getAllLeaders();
		List<LeaderDto> leaderDtos = new ArrayList<>();
		for(Leader leader : leaders) {
			LeaderDto leaderDto = new LeaderDto(leader);
			leaderDtos.add(leaderDto);
		}
		model.addAttribute("leaders", leaderDtos);
		return "leader/index";
	}
	
	@GetMapping("/new")
	public String newLeader(Model model) {
		Leader leader = new Leader();
		model.addAttribute("leader", leader);
		return "leader/new";
	}
	
	@PostMapping("/create")
	public String createLeader(@Valid Leader leader, BindingResult bindingResult,  Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		System.out.println(leader);
		
		if(leaderService.doesLeaderExist(leader)) {
			return "redirect:/leader/new";
		}
		
		User user = userService.getUserByUsername(currentPrincipalName);
		leader.setUser(user);
		leaderService.save(leader);
		return "redirect:/leader/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLeader(@PathVariable int id, Model model) {
		Leader leader = leaderService.getLeaderById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.getUserByUsername(currentPrincipalName);
		if(leader.getUser() != user) {
			return "redirect:/leader/index";
		}
		leaderService.deleteLeader(leader);
		return "redirect:/leader/index";
	}
	
}
