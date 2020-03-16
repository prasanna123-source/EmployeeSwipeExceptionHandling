package com.prasanna.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeSwipe_activity")
public class EmployeeSwipeActivity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empSwipeid;
	private String locationName;
	private Date swipeIn;
	private Date swipeOut;
	private Date swipeCreatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empId", nullable = false)
    private Employee employee;
			
	public Long getEmpSwipeid() {
		return empSwipeid;
	}

	public void setEmpSwipeid(Long empSwipeid) {
		this.empSwipeid = empSwipeid;
	}

	public Date getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(Date swipeIn) {
		this.swipeIn = swipeIn;
	}

	public Date getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(Date swipeOut) {
		this.swipeOut = swipeOut;
	}

	public Date getSwipeCreatedDate() {
		return swipeCreatedDate;
	}

	public void setSwipeCreatedDate(Date swipeCreatedDate) {
		this.swipeCreatedDate = swipeCreatedDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public EmployeeSwipeActivity(Long empSwipeid, String locationName, Date swipeIn, Date swipeOut,
			Date swipeCreatedDate, Employee employee) {
		super();
		this.empSwipeid = empSwipeid;
		this.locationName = locationName;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
		this.swipeCreatedDate = swipeCreatedDate;
		this.employee = employee;
	}

	public EmployeeSwipeActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
