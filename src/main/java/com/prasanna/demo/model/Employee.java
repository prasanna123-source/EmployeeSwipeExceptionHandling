package com.prasanna.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	String empId;
	String empName;	
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
    private Set<EmployeeSwipeActivity> employeeActivities;
		
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
		
	public Set<EmployeeSwipeActivity> getEmployeeActivities() {
		return employeeActivities;
	}
	public void setEmployeeActivities(Set<EmployeeSwipeActivity> employeeActivities) {
		this.employeeActivities = employeeActivities;
	}
	public Employee() {		
		// TODO Auto-generated constructor stub
	}

	
}
