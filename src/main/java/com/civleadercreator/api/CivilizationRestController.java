package com.civleadercreator.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civleadercreator.dto.CivilizationDto;
import com.civleadercreator.entity.Civilization;
import com.civleadercreator.service.CivilizationService;

@RestController
@RequestMapping("/api/civilization")
public class CivilizationRestController {

	@Autowired
	private CivilizationService civilizationService;
	
	@GetMapping("/index")
	public List<CivilizationDto> getAllCivilizations() {
		List<Civilization> entityCivs = civilizationService.getAllCivilizationsRest();
		List<CivilizationDto> civilizations = new ArrayList<>();
		entityCivs.stream().map(entityCiv -> civilizations.add(new CivilizationDto(entityCiv))).collect(Collectors.toList());
		return civilizations;
	}
	
	
	@GetMapping("/{id}")
	public CivilizationDto getCivilization(@PathVariable int id) {
		
		Civilization entityCiv = civilizationService.findCivilizationByIdRest(id);
		return (new CivilizationDto(entityCiv));
	}
}
