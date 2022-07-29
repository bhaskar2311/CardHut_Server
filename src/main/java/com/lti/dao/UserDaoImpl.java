package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;
	
	
	@Transactional
	public User addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		User persistedUser=null;
		
		try {
			persistedUser=em.merge(user);
			return persistedUser;
			
		} catch (Exception e) {
			// TODO: handle exception
			return persistedUser;
		}
		
		
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			user=em.find(User.class, userId);
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return user;
		}
		
	
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean login(int userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addJoiningFee(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
