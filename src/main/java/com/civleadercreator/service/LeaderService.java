package com.civleadercreator.service;

import java.util.List;

import com.civleadercreator.entity.Leader;

public interface LeaderService {
	
	public List<Leader> getAllLeadersRest();
	public List<Leader> getAllLeaders();
	
	public Leader findLeaderByIdRest(int id);
	
	public void deleteLeaderByIdRest(int id);

	public void saveRest(Leader newLeader);
	public void save(Leader newLeader);
	public boolean doesLeaderExist(Leader leader);
	public Leader getLeaderById(int id);
	public void deleteLeader(Leader leader);
}
