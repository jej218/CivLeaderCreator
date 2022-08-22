package com.civleadercreator.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civleadercreator.dto.LeaderDto;
import com.civleadercreator.entity.Leader;
import com.civleadercreator.service.LeaderService;

@RestController
@RequestMapping("/api/leader")
public class LeaderRestController {

	@Autowired
	private LeaderService leaderService;
	

	@GetMapping("/index")
	public List<LeaderDto> getAllLeadersRest() {
		List<Leader> entityLeaders = leaderService.getAllLeadersRest();
		List<LeaderDto> leaders = new ArrayList<>();
		entityLeaders.stream().map(entityLeader -> leaders.add(new LeaderDto(entityLeader))).collect(Collectors.toList());
		return leaders;
	}
	
	@GetMapping("/{id}")
	public LeaderDto getLeaderRest(@PathVariable int id) {
		Leader entityLeader = leaderService.findLeaderByIdRest(id);
		return (new LeaderDto(entityLeader));
	}
	
	@PostMapping("/create")
	public LeaderDto createLeader(@RequestBody Leader newLeader) {
		leaderService.saveRest(newLeader);
		return (new LeaderDto(newLeader));
	}
	
	
}
