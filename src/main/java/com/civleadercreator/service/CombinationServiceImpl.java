package com.civleadercreator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civleadercreator.dao.CombinationDAO;
import com.civleadercreator.entity.Combination;
import com.civleadercreator.repository.CombinationRepository;

@Service
public class CombinationServiceImpl implements CombinationService {

	@Autowired
	private CombinationRepository combinationRepository;
	
	
	@Autowired
	private CombinationDAO combinationDAO;
	
	@Override
	@Transactional
	public List<Combination> getAllCombinationsRest() {
		return (List<Combination>) combinationRepository.findAll();
	}
	@Override
	@Transactional
	public List<Combination> getAllCombinations() {
		return (List<Combination>) combinationDAO.findAll();
	}
	
	@Override
	@Transactional
	public Combination findCombinationByIdRest(int id) {
		return combinationRepository.findById(id).get();
	}
	
	@Override
	@Transactional
	public void deleteCombinationByIdRest(int id) {
		combinationRepository.deleteCombinationById(id);
	}
	@Override
	@Transactional
	public boolean doesCombinationExist(Combination combination) {
		List<Combination> combinations = combinationRepository.findAll();
		for(Combination combinationInList : combinations) {
			if(combinationInList.equals(combination)) {
				return true;
			}
		}
		return false;
	}
	@Override
	@Transactional
	public void save(Combination combination) {
		combinationRepository.save(combination);
		
	}
	@Override
	@Transactional
	public Combination getCombinationById(int id) {
		return combinationRepository.findCombinationById(id);
	}
	@Override
	@Transactional
	public void deleteCombination(Combination combination) {
		combinationRepository.delete(combination);
		
	}
}
