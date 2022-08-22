package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.dao.CombinationDAO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class CombinationDAOTest {

	@Autowired
	CombinationDAO combinationDAO;
	
	
	@Test
	void testAutowiring() {
		Assertions.assertNotNull(combinationDAO);
	}
	
	@Test
	void findAllIsNotNull() {
		Assertions.assertNotNull(combinationDAO.findAll());
	}
}
