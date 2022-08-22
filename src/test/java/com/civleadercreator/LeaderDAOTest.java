package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.dao.LeaderDAO;
import com.civleadercreator.entity.Leader;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class LeaderDAOTest {

	@Autowired
	LeaderDAO leaderDAO;
	
	@Test
	void testAutowiring() {
		Assertions.assertNotNull(leaderDAO);
	}
	
	@Test
	void findAllIsNotNull() {
		Assertions.assertNotNull(leaderDAO.findAll());
	}
	
	@Test
	void testSave() {
		Leader leader = new Leader();
		leaderDAO.save(leader);
		Assertions.assertEquals(leader, leaderDAO.findById(leader.getId()));
	}
	
	@Test
	void findById() {
		Leader leader = new Leader();
		leader.setName("Jake Jasinski");
		leaderDAO.save(leader);
		Leader newLeader = leaderDAO.findById(leader.getId());
		Assertions.assertNotNull(newLeader);
		Assertions.assertEquals("Jake Jasinki", newLeader.getName());
	}
}
