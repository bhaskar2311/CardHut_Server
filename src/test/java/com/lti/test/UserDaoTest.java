package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.UserDao;
import com.lti.entity.CardType;
import com.lti.entity.User;

public class UserDaoTest {

	UserDao dao;

	@Before
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		dao = context.getBean(UserDao.class);

	}
	

	@Test
	public void addOrUpdateUserTest() {

		User user = new User();
		user.setUserName("john123");
		user.setUserPassword("john123");
		user.setUserPhone("7789456123");
		user.setUserAddress("A wing ,room no-802");
		user.setCardType(CardType.gold.toString());
		user.setUserBank("HDFC");
		user.setUserAccountNo("789456478945");
		user.setUserIfsc("HDFC1234");

		User savedUser = dao.addOrUpdateUser(user);

		assertNotNull(savedUser);
	}

	@Test
	public void searchUserById() {
		User user = dao.getUserById(200);
		assertNotNull(user);
	}

	@Test
	public void viewAllUsers() {
		List<User> users = dao.viewAllUsers();
		assertFalse(users.isEmpty());
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getUserName());
		}

	}

	@Test
	public void login() {
		boolean isValidUser = dao.login(200, "john123");
		assertTrue(isValidUser);
		
	}

}
