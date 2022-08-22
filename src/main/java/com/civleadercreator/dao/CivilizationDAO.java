package com.civleadercreator.dao;

import java.util.List;

import com.civleadercreator.entity.Civilization;

public interface CivilizationDAO {
	
	public List<Civilization> findAll();
}
