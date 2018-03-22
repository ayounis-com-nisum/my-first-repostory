package com.loginDemo.loginDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="enployee_id")
	private Integer employeeId;
	@Column(name="employee_name")
	private String employeeName;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationModel locationModel;
	
	public LocationModel getLocationModel() {
		return locationModel;
	}
	public void setLocationModel(LocationModel locationModel) {
		this.locationModel = locationModel;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
