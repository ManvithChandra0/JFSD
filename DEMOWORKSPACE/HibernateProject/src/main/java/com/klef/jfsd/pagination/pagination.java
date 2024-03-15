package com.klef.jfsd.pagination;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class pagination {
public static void main(String[] args)
	{
	pagination  demo = new pagination();
		//demo.insertproduct();

		demo.pagination();
	}
	public void insertproduct()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Employee employee = new Employee();
	       employee.setId(103);
	       employee.setName("chandra");
	       employee.setContact("9634151591");
	       employee.setDept("ece");
	       
	       Transaction t = session.beginTransaction();
	       session.save(employee);
	       t.commit();
	       
	       System.out.println("Employee Object Saved Successfully");
	       
	       session.close();
	       sf.close();
	}


	public void pagination()
    {
      Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Criteria c = session.createCriteria(Employee.class);
        c.setFirstResult(1); 
        c.setMaxResults(3);  
        List<Employee> elist = c.list();
        System.out.println("Pagination:-");      
        System.out.println("Number of Employees="+elist.size());
        if(elist.size()>0)
        {
          for(Employee e : elist)
          {
            System.out.println(e.toString());
          }
        }
        else
        {
          System.out.println("Employee Data Not Found");
        }
        
       
        session.close();
        sf.close();
    }
	
	
}
