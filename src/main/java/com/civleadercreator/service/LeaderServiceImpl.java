package com.civleadercreator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civleadercreator.repository.LeaderRepository;
import com.civleadercreator.dao.LeaderDAO;
import com.civleadercreator.entity.Leader;

@Service
public class LeaderServiceImpl implements LeaderService {

	@Autowired
	private LeaderRepository leaderRepository;
	@Autowired
	private LeaderDAO leaderDAO;
	
	@Override
	@Transactional
	public List<Leader> getAllLeadersRest() {
		return (List<Leader>) leaderRepository.findAll();
	}
	@Override
	@Transactional
	public List<Leader> getAllLeaders() {
		return (List<Leader>) leaderDAO.findAll();
	}
	
	@Override
	@Transactional
	public Leader findLeaderByIdRest(int id) {
		return leaderRepository.findById(id).get();
	}
	
	@Override
	@Transactional
	public void deleteLeaderByIdRest(int id) {
		leaderRepository.deleteLeaderById(id);
	}

	@Override
	@Transactional
	public void saveRest(Leader newLeader) {
		leaderRepository.save(newLeader);
	}
	@Override
	@Transactional
	public void save(Leader newLeader) {
		leaderDAO.save(newLeader);
	}
	
	@Override
	@Transactional
	public boolean doesLeaderExist(Leader leader) {
		List<Leader> leaders = leaderRepository.findAll();
		for(Leader leaderInList : leaders) {
			System.out.println(leaderInList);
			if(leaderInList.equals(leader)) {
				return true;
			}
		}
		return false;
	}
	@Override
	@Transactional
	public Leader getLeaderById(int id) {
		return leaderRepository.findLeaderById(id);
	}
	@Override
	@Transactional
	public void deleteLeader(Leader leader) {
		leaderRepository.delete(leader);
		
	}
}
