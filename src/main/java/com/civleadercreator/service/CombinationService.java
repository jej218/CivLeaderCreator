package com.civleadercreator.service;

import java.util.List;

import com.civleadercreator.entity.Combination;

public interface CombinationService {

	public List<Combination> getAllCombinationsRest();
	public List<Combination> getAllCombinations();
	
	public Combination findCombinationByIdRest(int id);
	
	public void deleteCombinationByIdRest(int id);
	public boolean doesCombinationExist(Combination combination);
	public void save(Combination combination);
	public Combination getCombinationById(int id);
	public void deleteCombination(Combination combination);

}
