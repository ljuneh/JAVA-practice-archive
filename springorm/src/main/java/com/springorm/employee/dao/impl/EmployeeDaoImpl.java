package com.springorm.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.employee.dao.EmployeeDao;
import com.springorm.employee.entity.Employee;

@Component("employeedao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public int create(Employee employee) {
		Integer result = (Integer) hibernateTemplate.save(employee);
		return result;
	}
	
	@Override
	@Transactional
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		hibernateTemplate.delete(employee);
	}

	@Override
	public Employee find(int id) {
		return hibernateTemplate.get(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

}
