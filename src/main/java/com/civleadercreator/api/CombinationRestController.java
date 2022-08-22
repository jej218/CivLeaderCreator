package com.civleadercreator.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civleadercreator.dto.CombinationDto;
import com.civleadercreator.entity.Combination;
import com.civleadercreator.service.CombinationService;

@RestController
@RequestMapping("/api/combination")
public class CombinationRestController {
	
	@Autowired
	private CombinationService combinationService;
	
	@GetMapping("/index")
	public List<CombinationDto> getAllCombinations(){
		List<Combination> entityCombinations = combinationService.getAllCombinations();
		List<CombinationDto> combinations = new ArrayList<>();
		entityCombinations.stream().map(combination -> combinations.add(new CombinationDto(combination))).collect(Collectors.toList());	
		return combinations;
	}
	
	@GetMapping("/{id}")
	public CombinationDto getCombination(@PathVariable int id) {
		
		Combination entityCombination = combinationService.findCombinationByIdRest(id);
		return (new CombinationDto(entityCombination));
	}
}
