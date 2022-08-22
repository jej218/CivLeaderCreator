package com.civleadercreator.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.civleadercreator.entity.Combination;

public interface CombinationRepository extends JpaRepository<Combination, Integer>{
	public List<Combination> findAll();
	
	public Combination findCombinationById(int id);
	
	public void deleteCombinationById(int id);
}
