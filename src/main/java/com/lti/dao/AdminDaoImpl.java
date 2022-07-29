package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

//import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.User;

@Repository
//@Component
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	public Admin addAdmin(Admin admin) {
		Admin adminPersisted = em.merge(admin);
		return adminPersisted;
		
	}

	@Transactional
	public boolean activateCard(int emiCardNo) {
		
		String jpql = "update EmiCard ec set ec.activated=:approve where ec.emiCardNo=:emc";
		Query query = em.createQuery(jpql);
		query.setParameter("approve", true);
		query.setParameter("emc", emiCardNo);
		int rec = query.executeUpdate();
		System.out.println(rec);
		if(rec!=0)
			return true;
		else
			return false;
//		EmiCard emiCard = em.find(EmiCard.class, emiCardNo);
//		System.out.println(emiCard.getEmiCardNo());
//		emiCard.setActivated(true);
//		EmiCard updatedCard = em.merge(emiCard);
//		if(updatedCard!=null)
//			return true;
//		else
//			return false;
	}

	public boolean adminLogin(String adminUsername, String adminPassword) {
		String jpql = "select a from Admin a where a.adminUsername=:aname and a.adminPassword=:pwd";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("aname", adminUsername);
		query.setParameter("pwd", adminPassword);
//		User user = query.getSingleResult();
//		return user!=null?true:false;
		Admin admin = query.getResultList()
				.stream().findFirst().orElse(null);
		return admin!=null?true:false;
//		try {
//			User user = query.getSingleResult();
//		}
//		catch(Exception e){
//			return false;
//		}
//		return true;
	}

}
