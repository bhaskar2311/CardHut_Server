package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.UserDao;
import com.lti.entity.CardType;
import com.lti.entity.User;

public class UserDaoTest {

	UserDao userDao;

	@Before
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		userDao = context.getBean(UserDao.class);

	}
	

	@Test
	public void addOrUpdateUserTest() {

		User user = new User();
		user.setFullName("Harish");
		user.setEmail("harish@gmail.com");
		
		user.setUserPassword("john123");
		user.setUserPhone("7789456123");
		user.setUserAddress("A wing ,room no-802");
		user.setCardType(CardType.gold.toString());
		user.setUserBank("HDFC");
		user.setUserAccountNo("789456478945");
		user.setUserIfsc("HDFC1234");

		User savedUser = userDao.addOrUpdateUser(user);

		assertNotNull(savedUser);
	}

	@Test
	public void searchUserById() {
		User user = userDao.getUserById(21);
		assertNotNull(user);
	}

	@Test
	public void viewAllUsers() {
		List<User> users = userDao.viewAllUsers();
		assertFalse(users.isEmpty());
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getEmail());
		}

	}

	@Test
	public void login() {
		boolean isValidUser = userDao.login(200, "john123");
		assertTrue(isValidUser);
		
	}

}