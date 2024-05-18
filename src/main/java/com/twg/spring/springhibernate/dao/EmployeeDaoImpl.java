package com.twg.spring.springhibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twg.spring.springhibernate.entities.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    
    private HibernateTemplate hibernateTemplate;

    @Transactional(readOnly = false)
    public void save(Employee employee) {
        hibernateTemplate.save(employee);
    }

   @Transactional(readOnly = false)
    public void update(Employee employee) {
        hibernateTemplate.update(employee);
    }

    @Transactional(readOnly = false)
    public void delete(Employee employee) {
        hibernateTemplate.delete(employee);
    }

    public Employee findById(int id) {
        Employee emp = hibernateTemplate.get(Employee.class, id);
        return emp;
    }

    public List<Employee> findAll() {
        return hibernateTemplate.loadAll(Employee.class);
    }
}
