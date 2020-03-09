package com.prasanna.demo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.prasanna.demo.model.Employee;

@Service
public class EmployeeDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	
	Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplateObject = template;
	}

	
	public List<Employee> listEmployeess() {
		String sql = "select * from Employee";
		List<Map<String, Object>> list = jdbcTemplateObject.queryForList(sql);
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:list){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setEmpId((String)row.get("swipeIn"));
			emp.setEmpName((String)row.get("swipeOut"));
			emp.setEmpId((String)row.get("createDate"));
			emp.setEmpName((String)row.get("locationName"));
			result.add(emp);
		}		
		return result;	
	}

	public List<Employee> getEmployeeById(String empid) {

		String sql = "SELECT * FROM Employee WHERE empId = ?";
		List<Map<String, Object>> list = jdbcTemplateObject.queryForList(sql);
		List<Employee> resultEmployeeId = new ArrayList<Employee>();
		for(Map<String, Object> row:list){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setEmpId((String)row.get("swipeIn"));
			emp.setEmpName((String)row.get("swipeOut"));
			emp.setEmpId((String)row.get("createDate"));
			emp.setEmpName((String)row.get("locationName"));
			resultEmployeeId.add(emp);
		}		
		return resultEmployeeId;	
	}
	public List<Employee> getAdminEmployeeByLocation(String location) {
		String sql = "SELECT * FROM Employee WHERE locationName = ?";
		List<Map<String, Object>> list = jdbcTemplateObject.queryForList(sql);
		List<Employee> employeeByLoc = new ArrayList<Employee>();
		for(Map<String, Object> row:list){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setEmpId((String)row.get("swipeIn"));
			emp.setEmpName((String)row.get("swipeOut"));
			emp.setEmpId((String)row.get("createDate"));
			emp.setEmpName((String)row.get("locationName"));
			employeeByLoc.add(emp);
		}			
		return employeeByLoc;
	}
	public List<Employee> getAdminEmployeeByDate(String date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		 Date date1;
			List<Employee> employees = listEmployeess();
			List<Employee> employeeByLoc = new ArrayList<Employee>();
		try {
			date1 = formatter.parse(date);
		
		for(Employee emp : employees) {
			if(date1.equals(emp.getCreateDate())) {
				employeeByLoc.add(emp);
			}
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeByLoc;
		
	}	
	
}
