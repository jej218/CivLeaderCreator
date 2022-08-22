package com.civleadercreator.service;

import java.util.List;


import com.civleadercreator.entity.Civilization;

public interface CivilizationService {

	public List<Civilization> getAllCivilizationsRest();
	public List<Civilization> getAllCivilizations();
	
	public Civilization findCivilizationByIdRest(int id);
	
	public void deleteCivilizationByIdRest(int id);
	public boolean doesCivilizationExist(Civilization civilization);
	public void save(Civilization civilization);
	public Civilization getCivilizationById(int i);
	public void deleteCivilization(Civilization civilization);
}
