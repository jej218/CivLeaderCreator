package com.civleadercreator.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.civleadercreator.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public User findUserById(int id) throws NoResultException {
		try {
			Session session = entityManager.unwrap(Session.class);

			return session.get(User.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void createUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
	}
	
	@Override
	public User save(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
		return user;
	}
	
	@Override
	public boolean emailExist(String email) throws NoResultException{
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<User> query = session.createQuery("from User where email=:email", User.class);
			query.setParameter("email", email);
			return true;
		} catch (NoResultException e) {
			return false;
		}
		
	}

}
