package com.civleadercreator;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.civleadercreator.dao.UserDAO;
import com.civleadercreator.entity.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Transactional
@Rollback
@SpringBootTest(classes = CapstoneApplication.class)
public class UserDAOTest {
	
	@Autowired
	UserDAO userDAO;
	
	@Test
	void testAutowiring() {
		Assertions.assertNotNull(userDAO);
	}

	@Test
	void testFindById() {
		User user = new User();
		user.setFirstName("Jake");
		userDAO.createUser(user);
		User user2 = userDAO.findUserById(user.getId());
		Assertions.assertNotNull(user2);
		Assertions.assertEquals("Jake", user2.getFirstName());
	}
	
	@Test
	void testCreation() {
		User user = new User();
		userDAO.createUser(user);
		Assertions.assertEquals(user, userDAO.findUserById(user.getId()));
	}
	
	@Test
	void testSave() {
		User user = new User();
		User user2 = userDAO.save(user);
		Assertions.assertEquals(user, userDAO.findUserById(user.getId()));
		Assertions.assertEquals(user, user2);
	}
	
	@Test
	void testEmail() {
		User user = new User();
		user.setEmail("jjasinski2018@gmail.com");
		Assertions.assertTrue(userDAO.emailExist(user.getEmail()));
	}
	
}
