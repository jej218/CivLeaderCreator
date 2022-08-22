package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.entity.Leader;
import com.civleadercreator.service.LeaderService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class LeaderServiceTest {

	@Autowired
	LeaderService leaderService;
	
	
	@Test
	void testGetLeaderById() {
		Leader leader = new Leader();
		Assertions.assertNotNull(leaderService.getLeaderById(leader.getId()));
	}
}
