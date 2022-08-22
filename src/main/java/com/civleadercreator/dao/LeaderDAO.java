package com.civleadercreator.dao;

import java.util.List;

import com.civleadercreator.entity.Leader;

public interface LeaderDAO {

	public List<Leader> findAll();
	
	public void save(Leader leader);

	Leader findById(int id);
	
}
