package com.civleadercreator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.civleadercreator.entity.Civilization;

@Repository
public class CivilizationDAOImpl implements CivilizationDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CivilizationDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Civilization> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Civilization> query = session.createQuery("from Civilization", Civilization.class);
		return query.getResultList();
	}

}
