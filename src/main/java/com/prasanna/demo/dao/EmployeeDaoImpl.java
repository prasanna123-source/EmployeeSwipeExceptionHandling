package com.prasanna.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.prasanna.demo.model.Employee;

@Service
public class EmployeeDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	
	Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplateObject = template;
	}
	class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee=new Employee();
			employee.setEmpId(rs.getString("empId"));
			employee.setEmpName(rs.getString("empName"));
			employee.setSwipeIn(rs.getString("swipeIn"));
			employee.setSwipeOut(rs.getString("swipeOut"));
			employee.setCreateDate(rs.getDate("createDate"));
			employee.setLocationName(rs.getString("locationName"));			
			return employee;
		}		
	}
	
	public int saveEmployee(Employee employee) {
         return jdbcTemplateObject.update(
                    "insert into employee(empid, empname,locationname,swipein,swipeout,createDate) values(?,?,?,?,?,?)",
                    employee.getEmpId(), employee.getEmpName(),employee.getLocationName(),employee.getSwipeIn(),employee.getSwipeOut(),employee.getCreateDate());
    }

	public List<Employee> listEmployeess() {
		String sql = "select * from employee";			
		return jdbcTemplateObject.query(sql, new EmployeeRowMapper());	
	}
	
	

	public Employee getEmployeeById(String empId) {
		String sql = "SELECT * FROM employee WHERE empId = ?";		
	    Object[] args = {empId};
	    Employee employee = jdbcTemplateObject.queryForObject(sql, args,
	                    BeanPropertyRowMapper.newInstance(Employee.class));
	    return employee;		
		
    }
	
	public Employee getAdminEmployeeByLocation(String locationName) {
		String sql = "SELECT * FROM Employee WHERE locationName = ?";
		 Object[] args = {locationName};
		 Employee employeeByLoc = jdbcTemplateObject.queryForObject(sql, args,
                 BeanPropertyRowMapper.newInstance(Employee.class));		
		return employeeByLoc;
	}
	
	public List<Employee> getAdminEmployeeByDate(String date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
