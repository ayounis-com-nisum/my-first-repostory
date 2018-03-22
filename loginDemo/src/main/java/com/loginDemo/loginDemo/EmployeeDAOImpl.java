package com.loginDemo.loginDemo;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private EntityManager entityManager;
	

	
	@Transactional
	@Override
	public void addEmployee(EmployeeModel employeeModel) {
		this.entityManager.persist(employeeModel);
		
	}

}
