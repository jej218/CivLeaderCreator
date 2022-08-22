package com.civleadercreator.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.civleadercreator.entity.Leader;

@Repository
public class LeaderDAOImpl implements LeaderDAO {


	private EntityManager entityManager;
	
	@Autowired
	public LeaderDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Leader> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Leader> query = session.createQuery("from Leader", Leader.class);
		return query.getResultList();
	}

	@Override
	public void save(Leader leader) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(leader);
	}

	@Override
	public Leader findById(int id) {
		try {
			Session session = entityManager.unwrap(Session.class);

			return session.get(Leader.class, id);
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
