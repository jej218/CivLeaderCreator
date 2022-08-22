package com.civleadercreator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civleadercreator.dao.CivilizationDAO;
import com.civleadercreator.entity.Civilization;
import com.civleadercreator.repository.CivilizationRepository;

@Service
public class CivilizationServiceImpl implements CivilizationService {
	
	@Autowired
	private CivilizationRepository civilizationRepository;
	
	@Autowired
	private CivilizationDAO civilizationDAO;
	
	@Override
	@Transactional
	public List<Civilization> getAllCivilizationsRest() {
		return (List<Civilization>) civilizationRepository.findAll(); 
	}
	@Override
	@Transactional
	public List<Civilization> getAllCivilizations() {
		return (List<Civilization>) civilizationDAO.findAll();
	}
	
	
	@Override
	@Transactional
	public Civilization findCivilizationByIdRest(int id) {
		return civilizationRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteCivilizationByIdRest(int id) {
		civilizationRepository.deleteCivilizationById(id);
	}
	
	@Override
	@Transactional
	public boolean doesCivilizationExist(Civilization civilization) {
		List<Civilization> civilizations = civilizationRepository.findAll();
		for(Civilization civilizationInList : civilizations) {
			if(civilizationInList.equals(civilization)) {
				return true;
			}
		}
		return false;
	}
	@Override
	@Transactional
	public void save(Civilization civilization) {
		civilizationRepository.save(civilization);
	}
	@Override
	@Transactional
	public Civilization getCivilizationById(int id) {
		return civilizationRepository.findCivilizationById(id);
	}
	@Override
	@Transactional
	public void deleteCivilization(Civilization civilization) {
		civilizationRepository.delete(civilization);
		
	}
}
