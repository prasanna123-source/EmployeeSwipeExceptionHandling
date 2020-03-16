package com.prasanna.demo.dao;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prasanna.demo.model.Employee;

@Service
@Transactional
public class EmployeeSwipeDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }	
	
	Logger logger = LoggerFactory.getLogger(EmployeeSwipeDaoImpl.class);

	public Employee saveEmployee(Employee employee) {
		// sessionFactory.getCurrentSession().persist(user);
		sessionFactory.getCurrentSession().save(employee);
		return Objects.nonNull(employee) && Objects.nonNull(employee.getEmpId()) ? employee : null;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> resultList = getSession().createQuery("from Employee",Employee.class).getResultList();
	    return resultList;
	  }

	public Employee getById(int id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public Employee updateEmployee(Employee employee, int id) {
		if (Objects.nonNull(employee) && Objects.nonNull(employee.getEmpId())) {
			sessionFactory.getCurrentSession().saveOrUpdate(employee);
		} else {
			throw new RuntimeException();
		}
		return employee;
	}

//	public Employee getAdminEmployeeByLocation(String locationName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public void deleteUser(int id) {
//		User user = sessionFactory.getCurrentSession().get(User.class, id);
//		getSession().delete(user);
//	}

//	public List<Employee> listEmployeess() {
//		return null;
//			
//	}
//	
//	
//
//	public Employee getEmployeeById(String empId) {
//		
//	    return employee;		
//		
//    }
//	
//	public Employee getAdminEmployeeByLocation(String locationName) {
//		return null;
//		
//	}
//	
//	public List<Employee> getAdminEmployeeByDate(String date) {
//		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		 Date date1;
//			List<Employee> employees = listEmployeess();
//			List<Employee> employeeByLoc = new ArrayList<Employee>();
//		try {
//			date1 = formatter.parse(date);
//		
//		for(Employee emp : employees) {
//			if(date1.equals(emp.getCreateDate())) {
//				employeeByLoc.add(emp);
//			}
//		}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return employeeByLoc;
//		
//	}	
//	
}
