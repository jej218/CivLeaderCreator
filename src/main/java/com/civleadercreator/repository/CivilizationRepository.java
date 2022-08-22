package com.civleadercreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.civleadercreator.entity.Civilization;

public interface CivilizationRepository extends JpaRepository<Civilization, Integer>{
	
	public List<Civilization> findAll();
	
	public Civilization findCivilizationById(int id);
	
	public void deleteCivilizationById(int id);
}
