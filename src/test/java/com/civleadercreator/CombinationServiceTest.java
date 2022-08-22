package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.entity.Combination;
import com.civleadercreator.service.CombinationService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class CombinationServiceTest {

	@Autowired
	private CombinationService combinationService;
	
	@Test
	void testDeleteCombination() {
		Combination combination = new Combination();
		combinationService.deleteCombination(combination);
		Assertions.assertTrue(combinationService.findCombinationByIdRest(combination.getId()) == null);
	}

}
