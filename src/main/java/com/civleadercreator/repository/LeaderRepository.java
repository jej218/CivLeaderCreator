package com.civleadercreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.civleadercreator.entity.Leader;

public interface LeaderRepository extends JpaRepository<Leader, Integer> {
	
	public List<Leader> findAll();
	
	public Leader findLeaderById(int id);
	
	public void deleteLeaderById(int id);
	
}
