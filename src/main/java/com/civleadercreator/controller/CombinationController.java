package com.civleadercreator.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.civleadercreator.dto.CombinationDto;
import com.civleadercreator.entity.Civilization;
import com.civleadercreator.entity.Combination;
import com.civleadercreator.entity.Leader;
import com.civleadercreator.entity.User;
import com.civleadercreator.service.CivilizationService;
import com.civleadercreator.service.CombinationService;
import com.civleadercreator.service.LeaderService;
import com.civleadercreator.service.UserService;


@Controller
@RequestMapping("/combination")
public class CombinationController {

	@Autowired
	private CombinationService combinationService;
	@Autowired
	private LeaderService leaderService;
	@Autowired
	private CivilizationService civilizationService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String indexCombination(Model model) {
		List<Combination> entityCombinations = combinationService.getAllCombinations();
		List<CombinationDto> combinations = new ArrayList<>();
		entityCombinations.stream().map(combination -> combinations.add(new CombinationDto(combination))).collect(Collectors.toList());	
		model.addAttribute("combinations", combinations);
		return "combination/index";
	}
	
	@GetMapping("/new")
	public String newCombination(Model model) {
		CombinationDto combinationDto = new CombinationDto();
		model.addAttribute("combinationDto", combinationDto);
		List<Leader> leaders = leaderService.getAllLeaders();
		model.addAttribute("leaders", leaders);
		List<Civilization> civilizations = civilizationService.getAllCivilizations();
		model.addAttribute("civilizations", civilizations);
		List<String> colorNames = new ArrayList<>();
		List<String> colorHexes = new ArrayList<>();
		Set<Entry<String, String>> entries = Combination.COLORS.entrySet();
		Iterator<Entry<String, String>> entriesIterator = entries.iterator();
		while(entriesIterator.hasNext()) {
			Map.Entry<String, String> mapping = entriesIterator.next();
			colorNames.add(mapping.getKey());
			colorHexes.add(mapping.getValue());
		}
		model.addAttribute("colors", new Combination());
		return "combination/new";
	}

	@PostMapping("/create")
	public String createCombination(CombinationDto combinationDto, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.getUserByUsername(currentPrincipalName);
		String outerColorName = Combination.findKey(combinationDto.getOuterColorHexCode());
		String innerColorName = Combination.findKey(combinationDto.getInnerColorHexCode());
		Leader leader = leaderService.getLeaderById(Integer.parseInt(combinationDto.getLeaderId()));
		Civilization civilization = civilizationService.getCivilizationById((Integer.parseInt(combinationDto.getCivId())));
		Combination combination = new Combination(combinationDto.getOuterColorHexCode(), combinationDto.getInnerColorHexCode(), outerColorName, innerColorName, civilization, leader);
		combination.setUser(user);
		if(combinationService.doesCombinationExist(combination)) {
			return "redirect:/combination/new";
		}
		combinationService.save(combination);
		return "redirect:/combination/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLeader(@PathVariable int id, Model model) {
		Combination combination = combinationService.getCombinationById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.getUserByUsername(currentPrincipalName);
		if(combination.getUser() != user) {
			return "redirect:/combination/index";
		}
		combinationService.deleteCombination(combination);
		return "redirect:/combination/index";
	}
	
	
}
