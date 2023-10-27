package com.springorm.employee.dao;

import java.util.List;

import com.springorm.employee.entity.Employee;

public interface EmployeeDao {
	int create(Employee employee);
	void update(Employee employee);
	void delete(Employee employee);
	
	Employee find(int id);
	List<Employee> findAll();

}
