package com.klef.jfsd.service;

import java.util.List;

import com.klef.jfsd.dao.EmployeeDAO;
import com.klef.jfsd.model.Employee;

public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDAO dao;
	
	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String AddEmployee(Employee emp) {
		
		return dao.AddEmployee(emp);
	}

	@Override
	public String UpdateEmployee(Employee emp) {
		
		return dao.UpdateEmployee(emp);
	}

	@Override
	public String DeleteEmployee(int id) {
		
		return dao.DeleteEmployee(id);
	}

	@Override
	public List<Employee> ViewAllEmployee() {
		
		return dao.ViewAllEmployee();
	}

	@Override
	public Employee ViewEmployeeByID(int id) {
		
		return dao.ViewEmployeeByID(id);
	}
	
	
}
