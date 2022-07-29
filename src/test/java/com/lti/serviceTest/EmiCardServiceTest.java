package com.lti.serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dao.EmiCardDao;
import com.lti.dao.UserDao;
import com.lti.entity.CardType;
import com.lti.entity.EmiCard;
import com.lti.entity.User;
import com.lti.service.EmiCardService;

public class EmiCardServiceTest {

	EmiCardService emiCardService;
	UserDao dao1;
	
	@Before
	public void initializeDao() {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/dispatcher-servlet.xml");
		emiCardService = context.getBean(EmiCardService.class);
		dao1=context.getBean(UserDao.class);
	}
	
	@Test
	public void test() {
		System.out.println(emiCardService);
	}
	
	@Test
	public void addOrUpdateEmiCard()
	{
		EmiCard emiCard = new EmiCard();
		User user=dao1.getUserById(22);
		emiCard.setEmiValidity("202");
		emiCard.setEmiCardType(CardType.gold);
		emiCard.setEmiCardLimit(250000);
		emiCard.setEmiCardBalance(14500);
		emiCard.setUser(user);
		emiCard.setActivated(true);

		String savedEmiCard = emiCardService.addOrUpdateEmiCard(emiCard);

		System.out.println(savedEmiCard);
	}
	
	@Test
	public void getEmiCardByUserId() {
		EmiCard emiCard = emiCardService.getEmiCardByUserId(21);
		assertNotNull(emiCard);
		System.out.println(emiCard.getEmiCardNo());
	}

}
