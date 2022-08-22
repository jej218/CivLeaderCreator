package com.civleadercreator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civleadercreator.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 
	
	public List<User> findAll();
	
	public User findUserById(int theId);
	
	public void deleteUserById(int theId);
	
	public User findByFirstName(String firstName);

	public User findByEmail(String email);

}
