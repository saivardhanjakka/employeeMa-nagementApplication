package com.twg.spring.springhibernate.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twg.spring.springhibernate.dao.EmployeeDao;
import com.twg.spring.springhibernate.entities.Employee;

@Component
public class EmployeeBusinessImpl implements EmployeeBusiness {


	@Autowired
	
	private EmployeeDao employeeDao;

	public void save(Employee employee) {
		employeeDao.save(employee);
		
		
	}

	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
		
	}

	public Employee findById(int id) {
	
		return employeeDao.findById(id);
	}

	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

}
	


