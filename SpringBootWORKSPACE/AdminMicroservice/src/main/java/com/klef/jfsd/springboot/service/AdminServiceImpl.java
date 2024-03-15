package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;
import com.klef.jfsd.springboot.repository.EmployeeRepository;


@Service
public class AdminServiceImpl  implements AdminService
{

	@Autowired
	private AdminRepository adminrepository;
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public List<Employee> viewallemps() 
	{
		return employeerepository.findAll();
		
	}

	@Override
	public Employee viewempbyid(int eid)
	{
		Optional<Employee> obj =  employeerepository.findById(eid);
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public String deleteemp(int eid) {
		Optional<Employee> obj =  employeerepository.findById(eid);
	       
	       String msg = null;
	       
	       if(obj.isPresent())
	       {
	         Employee emp = obj.get();
	         
	         employeerepository.delete(emp);
	         
	         msg = "Employee Deleted Successfully";
	       }
	       else
	       {
	         msg = "Employee Not Found";
	       }
	       
	       return msg;
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) 
	{
		return adminrepository.checkadminlogin(uname, pwd);
	}

	@Override
	public String addcustomer(Customer c) 
	{
		customerRepository.save(c);
		return "Customer Added Successfully";
	}

	@Override
	public long empcount() 
	{
		return employeerepository.count();		
	}

	@Override
	public long customercount() 
	{
		return customerRepository.count();
	}

	
	
	//Employee Active Status Update
	
	@Override
	public int updatestatus(int eid, boolean status) 
	{
		return adminrepository.updatestatus(eid, status);
	}

}
