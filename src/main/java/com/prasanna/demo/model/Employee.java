package com.prasanna.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Employee {	
	
	String empId;
	String empName;
	String swipeIn;
	String swipeOut;
	Date createDate;
	String locationName;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(String swipeIn) {
		this.swipeIn = swipeIn;
	}
	public String getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(String swipeOut) {
		this.swipeOut = swipeOut;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", swipeIn=" + swipeIn + ", swipeOut="
				+ swipeOut + ", createDate=" + createDate + ", locationName=" + locationName + "]";
	}
	public Employee() {		
		// TODO Auto-generated constructor stub
	}

	
}
