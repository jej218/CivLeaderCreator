package com.civleadercreator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.civleadercreator.entity.Combination;

@Repository
public class CombinationDAOImpl implements CombinationDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public CombinationDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Combination> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Combination> query = session.createQuery("from Combination", Combination.class);
		return query.getResultList();
	}
	
	

}
