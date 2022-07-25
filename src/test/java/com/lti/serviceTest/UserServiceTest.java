package com.lti.serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.entity.CardType;
import com.lti.entity.User;
import com.lti.service.UserService;

public class UserServiceTest {
	UserService userService;

	@Before
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		userService = context.getBean(UserService.class);

	}

	@Test
	public void addOrUpdateUser() {

		
		User user = new User();
		user.setName("rishabh pant");
		user.setUsername("rishabh123");

		user.setUserPassword("rishabh123");
		user.setUserPhone("7789456123");
		user.setUserAddress("A wing ,room no-802");
		user.setCardType(CardType.gold.toString());
		user.setUserBank("HDFC");
		user.setUserAccountNo("789456478945");
		user.setUserIfsc("HDFC1234");

		System.out.println(userService.addOrUpdateUser(user));

	}
	
	
	@Test
	public void getUserById() {
		assertNotNull(userService.getUserById(220));

	}
	
	
	@Test
	public void viewAllUsers(){
		assertNotEquals(0, userService.viewAllUsers().size());

	}
	
	@Test
	public void login() {
		System.out.println(userService.login(202, "john123"));
		
	}
	
	@Test
	public void addJoiningFee() {
		
	}
}
