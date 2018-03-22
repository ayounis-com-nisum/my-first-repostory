package com.loginDemo.loginDemo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Component
public class LocationDAOImpl implements LocationDAO{
	
	
	
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addLocationModel(LocationModel locationModel) {
		this.sessionFactory.getCurrentSession().save(locationModel);
		
	}

}
