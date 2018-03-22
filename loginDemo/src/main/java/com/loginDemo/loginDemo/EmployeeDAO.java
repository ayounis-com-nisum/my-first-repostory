package com.loginDemo.loginDemo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO{
	public void addEmployee(EmployeeModel employeeModel );
}
