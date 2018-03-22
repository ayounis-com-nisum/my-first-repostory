package com.loginDemo.loginDemo;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserDAOImpl implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public void addUserModel(UserModel model) {
		this.entityManager.persist(model);
		
	}

}
