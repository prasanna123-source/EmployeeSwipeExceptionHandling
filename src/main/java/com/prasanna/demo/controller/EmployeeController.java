package com.prasanna.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasanna.demo.ExceptionHandler.CustomException;
import com.prasanna.demo.dao.EmployeeDaoImpl;
import com.prasanna.demo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDaoImpl employeeDaoRef;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostMapping(value = "/saveEmployee")
	public int save(@ModelAttribute("employee") Employee emp) {		  
		 return employeeDaoRef.saveEmployee(emp);    
	}
  
	@GetMapping(value = "/getEmployees")
	public List<Employee> listEmployees(Model model) {
		List<Employee> empList = employeeDaoRef.listEmployeess();
		if (!empList.isEmpty()) {
			model.addAttribute("employees", empList);
		} else {
			throw new CustomException("Employee record Not found");
		}
		return empList;
	}

	@GetMapping(value = "/getEmployeeByID/{empId}")
	public Employee getEmployeeById(@PathVariable(name = "empId") String empId) {

		return employeeDaoRef.getEmployeeById(empId);
	}

	@GetMapping(value = "/getEmployeesByLocation/{user}/{location}")
	public List<Employee> getEmployeeByLocation(@PathVariable ("user") String user,@PathVariable("location") String locationName){
		
		if(user.equalsIgnoreCase("admin")) {
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(employeeDaoRef.getAdminEmployeeByLocation(locationName));
		return empList;
		}else {
		return employeeDaoRef.listEmployeess();
		}
	}

	@GetMapping(value = "/getEmployeesByDate/{user}/{date}")
	public List<Employee> getEmployeeByDate(@PathVariable("user") String user,@PathVariable("date") String date) {
		if (user.equalsIgnoreCase("admin")) {		
			return employeeDaoRef.getAdminEmployeeByDate(date);
		} else {
			return employeeDaoRef.listEmployeess();
		}
	}

}
