package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.entity.Civilization;
import com.civleadercreator.service.CivilizationService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class CivilizationServiceTest {

	@Autowired
	private CivilizationService civilizationService;
	
	@Test
	void testDoesCivilizationExist() {
		Civilization civlization = new Civilization();
		civlization.setName("Tester");
		
		Assertions.assertTrue(civilizationService.doesCivilizationExist(civlization));
		
	}
	
}
