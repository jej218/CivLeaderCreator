package com.civleadercreator.service;

import com.civleadercreator.dto.UserDto;
import com.civleadercreator.entity.User;
import com.civleadercreator.exceptions.UserAlreadyExistException;

public interface UserService {

	public User saveUser(UserDto userDto);

	void register(UserDto user) throws UserAlreadyExistException;

	boolean checkIfUserExist(String email);

	User getUserByUsername(String email);
	
}
