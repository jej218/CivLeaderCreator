package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.dao.CivilizationDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class CivilizationDAOTest {

	@Autowired
	CivilizationDAO civilizationDAO;
	
	@Test
	void testAutowiring() {
		Assertions.assertNotNull(civilizationDAO);
	}
	
	@Test
	void findAllIsNotNull() {
		Assertions.assertNotNull(civilizationDAO.findAll());
	}
}
