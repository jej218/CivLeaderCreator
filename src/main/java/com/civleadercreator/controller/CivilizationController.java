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

import com.civleadercreator.dto.CivilizationDto;
import com.civleadercreator.entity.Civilization;
import com.civleadercreator.entity.User;
import com.civleadercreator.service.CivilizationService;
import com.civleadercreator.service.UserService;

@Controller
@RequestMapping("/civilization")
public class CivilizationController {
	
	@Autowired
	private CivilizationService civilizationService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String indexCivilization(Model model) {
		List<Civilization> civilizations = civilizationService.getAllCivilizations();
		List<CivilizationDto> civilizationDtos = new ArrayList<>();
		for(Civilization civilization : civilizations) {
			CivilizationDto civilizationDto = new CivilizationDto(civilization);
			civilizationDtos.add(civilizationDto);
		}
		model.addAttribute("civilizations", civilizationDtos);
		return "civilization/index";
	}
	
	@GetMapping("/new")
	public String newCivilization(Model model) {
		Civilization civilization = new Civilization();
		model.addAttribute("civilization", civilization);
		return "civilization/new";
	}
	
	@PostMapping("/create")
	public String createCivilization(@Valid Civilization civilization, BindingResult bindingResult,  Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		if(civilizationService.doesCivilizationExist(civilization)) {
			return "redirect:/civilization/new";
		}
		
		User user = userService.getUserByUsername(currentPrincipalName);
		civilization.setUser(user);
		civilizationService.save(civilization);
		return "redirect:/civilization/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCivilization(@PathVariable int id, Model model) {
		
		Civilization civilization = civilizationService.getCivilizationById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.getUserByUsername(currentPrincipalName);
		if(civilization.getUser() != user) {
			return "redirect:/civilization/index";
		}
		civilizationService.deleteCivilization(civilization);
		
		return "redirect:/civilization/index";
	}
	
}
