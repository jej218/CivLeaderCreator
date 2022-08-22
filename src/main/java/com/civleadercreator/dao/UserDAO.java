package com.civleadercreator.dao;

import com.civleadercreator.entity.User;

public interface UserDAO {
	
	public User findUserById(int id);

	public void createUser(User user);

	User save(User user);

	boolean emailExist(String email);
	
	
}
