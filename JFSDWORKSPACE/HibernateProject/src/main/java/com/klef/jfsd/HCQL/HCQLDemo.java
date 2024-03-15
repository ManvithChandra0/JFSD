package com.klef.jfsd.HCQL;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HCQLDemo {
public static void main(String[] args)
	{
		HCQLDemo  demo = new HCQLDemo();
		//demo.insertproduct();
		//demo.restrictionsdemo();
		//demo.ProjectionswithAggregateFunctions();
		//demo.ProjectionswithProperties();
		//demo.multiplerestrictions();
		//demo.orderdemo();
		//demo.HCQAll();
		demo.pagination();
	}
	public void insertproduct()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Product product = new Product();
	       product.setId(1006);
	       product.setCategory("Furniture");
	       product.setName("bookshelf");
	       product.setVendor("IKEA");
	       product.setCost(12000.00);
	       product.setStock(2);
	       
	       Transaction t = session.beginTransaction();
	       session.save(product);
	       t.commit();
	       
	       System.out.println("Product Object Saved Successfully");
	       
	       session.close();
	       sf.close();
	}
	public void restrictionsdemo()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       Criteria c1 = session.createCriteria(Product.class);
	       List<Product> plist1 = c1.list();
	       System.out.println("*****ALL Products*****");
	       System.out.println("Total Products = "+plist1.size());

	       if(plist1.size()>0)
	       {
	    	   for(Product p:plist1)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c2 = session.createCriteria(Product.class);
	       c2.add(Restrictions.eq("category", "Electronics"));
	       //category = "Electronics",where category is property name
	       List<Product> plist2 = c2.list();
	       System.out.println("*****Eq Restrictions*****");
	       System.out.println("Total Products = "+plist2.size());

	       if(plist2.size()>0)
	       {
	    	   for(Product p:plist2)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c3 = session.createCriteria(Product.class);
	       
	       c3.add(Restrictions.lt("cost", 20000.00));
	       //cost <20000.0,where cost is property name
	       List<Product> plist3 = c3.list();
	       System.out.println("*****Lt Restrictions*****");
	       System.out.println("Total Products = "+plist3.size());

	       if(plist3.size()>0)
	       {
	    	   for(Product p:plist3)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c4 = session.createCriteria(Product.class);
	       
	       c4.add(Restrictions.gt("cost", 10000.00));
	       //cost > 10000.0,where cost is property name
	       List<Product> plist4 = c4.list();
	       System.out.println("*****Gt Restrictions*****");
	       System.out.println("Total Products = "+plist4.size());
	       if(plist4.size()>0)
	       {
	    	   for(Product p:plist4)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c5 = session.createCriteria(Product.class);
	       
	       c5.add(Restrictions.le("stock", 10));
	       //stock <= 10,where stock is property name
	       List<Product> plist5 = c5.list();
	       System.out.println("*****Le Restrictions*****");
	       System.out.println("Total Products = "+plist5.size());
	       if(plist5.size()>0)
	       {
	    	   for(Product p:plist5)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c6 = session.createCriteria(Product.class);
	       
	       c6.add(Restrictions.ge("cost", 15000.0));
	       //cost >= 15000.0,where cost is property name
	       List<Product> plist6 = c6.list();
	       System.out.println("*****Ge Restrictions*****");
	       System.out.println("Total Products = "+plist6.size());
	       if(plist6.size()>0)
	       {
	    	   for(Product p:plist6)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c7 = session.createCriteria(Product.class);
	       
	       c7.add(Restrictions.between("cost", 2000.0, 20000.0));
	       //cost >= 2000.0 and cost <= 20000.0,where cost is property name
	       List<Product> plist7 = c7.list();
	       System.out.println("*****Ge Restrictions*****");
	       System.out.println("Total Products = "+plist7.size());
	       if(plist7.size()>0)
	       {
	    	   for(Product p:plist7)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }
	       Criteria c8 = session.createCriteria(Product.class);
	       //c8.add(Restrictions.in("stock", new Integer[] {10,20,30}));
	       //stock=10 or stock=20 or stock=30, stock is property name
	       c8.add(Restrictions.in("category", new String[] {"Furniture","Clothes"}));
	       //category=Furniture or category=Clothes  category is property name

	       List<Product> plist8 = c8.list();
	       System.out.println("*****In Restrictions*****");
	       System.out.println("Total Products = "+plist8.size());
	       if(plist8.size()>0)
	       {
	    	   for(Product p:plist8)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
		       System.out.println("Product Data Not Found");

	       }

	       Criteria c9 = session.createCriteria(Product.class);
	       c9.add(Restrictions.idEq(1003));
	       List<Product> plist9 = c9.list();
	       System.out.println("*****idEQ Restriction*****");
	       System.out.println("Total Products="+plist9.size());
	       if(plist9.size()>0)
	       {
	    	   for(Product p:plist9)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       Criteria c10 = session.createCriteria(Product.class);
	       c10.add(Restrictions.like("name", "s%"));
	       //product name starts with s
	       List<Product> plist10 = c10.list();
	       System.out.println("*****like Restriction*****");
	       System.out.println("Total Products="+plist10.size());
	       if(plist10.size()>0)
	       {
	    	   for(Product p:plist10)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }

	       Criteria c11 = session.createCriteria(Product.class);
	       c11.add(Restrictions.isNull("review")); //review is property name
	       //product name starts with s
	       List<Product> plist11 = c11.list();
	       System.out.println("*****isNull Restriction*****");
	       System.out.println("Total Products="+plist11.size());
	       if(plist11.size()>0)
	       {
	    	   for(Product p:plist11)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       session.close();
	       sf.close();
	       

	}
	public void ProjectionswithAggregateFunctions()
	{
		   Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       System.out.println("****Projections With AggregateFunctions****");
	       Criteria c1 = session.createCriteria(Product.class);
	       c1.setProjection(Projections.rowCount()); //count(*)
	       List list1 = c1.list();
	       System.out.println("****count(*)****");
	       System.out.println("Total Products = "+list1.get(0));
	       
	       Criteria c2 = session.createCriteria(Product.class);
	       c2.setProjection(Projections.count("category")); //count(category), where category is property
	       List list2 = c2.list();
	       System.out.println("****count(category)****");
	       System.out.println("Total Products = "+list2.get(0));
	       
	       Criteria c3 = session.createCriteria(Product.class);
	       c3.setProjection(Projections.sum("cost")); //sum(cost), where cost is property
	       List list3 = c3.list();
	       System.out.println("****sum(cost)****");
	       System.out.println("Total Products Cost= "+list3.get(0));
	       
	       Criteria c4 = session.createCriteria(Product.class);
	       c4.setProjection(Projections.avg("cost")); // where category is property
	       List list4 = c4.list();
	       System.out.println("****abg(cost)****");
	       System.out.println("Avg Products = "+list4.get(0));
	       
	       Criteria c5 = session.createCriteria(Product.class);
	       c5.setProjection(Projections.min("stock")); //count(category), where category is property
	       List list5 = c5.list();
	       System.out.println("****min(stock)****");
	       System.out.println("Min Products = "+list5.get(0));
	       
	       Criteria c6 = session.createCriteria(Product.class);
	       c6.setProjection(Projections.countDistinct("category")); //count(category), where category is property
	       List list6 = c6.list();
	       System.out.println("****max(stock)****");
	       System.out.println("Max Products = "+list6.get(0));
	       
	       Criteria c7 = session.createCriteria(Product.class);
	       c7.setProjection(Projections.max("stock")); //count(category), where category is property
	       List list7 = c7.list();
	       System.out.println("****Distinct Category Count****");
	       System.out.println("Max Products = "+list7.get(0));
	       
	       session.close();
	       sf.close();
	}
	public void ProjectionswithProperties()
	{
		   Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	      
	       System.out.println("****Projections With Properties****");
	       Criteria c1 = session.createCriteria(Product.class);
	       c1.setProjection(Projections.id());
	       List plist1 = c1.list();
	       System.out.println("****ID PROPERTY****");
	       if(plist1.size()>0) {
	    	   for(int i=0;i<plist1.size();i++)
	    	   {
	    		   System.out.println(plist1.get(i));
	    	   }
	       }
	       else {
	    	   System.out.println("PRoduct Data Not Found");
	       }
	       
	       Criteria c2 = session.createCriteria(Product.class);
	       c2.setProjection(Projections.property("name"));
	       List plist2 = c2.list();
	       System.out.println("****Name PROPERTY****");
	       if(plist2.size()>0) {
	    	   for(int i=0;i<plist2.size();i++)
	    	   {
	    		   System.out.println(plist2.get(i));
	    	   }
	       }
	       else {
	    	   System.out.println("Product Data Not Found");
	       }
	       

	       Criteria c3 = session.createCriteria(Product.class);
	       c3.setProjection(Projections.property("cost")); //cost is a property name
	       c3.addOrder(Order.desc("cost")); //descending order
	       List plist3 = c3.list();
	       System.out.println("****COST PROPERTY****");
	       if(plist3.size()>0) {
	    	   for(int i=0;i<plist3.size();i++)
	    	   {
	    		   System.out.println(plist3.get(i));
	    	   }
	       }
	       else {
	    	   System.out.println("Product Data Not Found");
	       }
	       

	       Criteria c4 = session.createCriteria(Product.class);
	       c4.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("name")).add(Projections.property("cost")));
	       
	       List<Object[]> plist4 = c4.list();	       
	       System.out.println("****MULTIPLE PROPERTIES****");
	       if(plist4.size()>0) {
	    	   for(Object[] obj : plist4)
	    	   {
	    		   System.out.println("Product ID:"+obj[0]);
	    		   System.out.println("Product Name:"+obj[1]);
	    		   System.out.println("Product Cost:"+obj[2]);
	    		   System.out.println();
	    		   
	    	   }
	       }
	       else {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       Criteria c5 = session.createCriteria(Product.class);
	       c5.setProjection(Projections.distinct(Projections.property("category")));
	       List plist5 = c5.list();
	       System.out.println("****DISTINCT CATEGORY PROPERTY****");
	       if(plist1.size()>0) {
	    	   for(int i=0;i<plist5.size();i++)
	    	   {
	    		   System.out.println(plist5.get(i));
	    	   }
	       }
	       else {
	    	   System.out.println("PRoduct Data Not Found");
	       }
	       
	       session.close();
	       sf.close();
	}
	public void multiplerestrictions()
	{
		   Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Criteria c1 = session.createCriteria(Product.class);
	       c1.add(Restrictions.and(Restrictions.eq("stock",10), Restrictions.lt("stock",20)));
	       //stock=10 and stock<20 ; where stock is property
	       List<Product> plist1 = c1.list();
	       System.out.println("*****and restrictions*****");
	       System.out.println("Total Products="+plist1.size());
	       if(plist1.size()>0)
	       {
	    	   for(Product p:plist1)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       Criteria c2 = session.createCriteria(Product.class);
	       c2.add(Restrictions.or(Restrictions.eq("stock",15), Restrictions.gt("cost",30000.0)));
	       //stock=15 and cost>30000.0 ; where stock,cost is properties
	       List<Product> plist2 = c2.list();
	       System.out.println("*****or restrictions*****");
	       System.out.println("Total Products="+plist2.size());
	       if(plist2.size()>0)
	       {
	    	   for(Product p:plist2)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       Criteria c3 = session.createCriteria(Product.class);
	       c3.add(Restrictions.not(Restrictions.gt("cost",10000.0)));
	       //cost<=10000.0 ; where cost is property
	       List<Product> plist3 = c3.list();
	       System.out.println("*****not restrictions*****");
	       System.out.println("Total Products="+plist3.size());
	       if(plist3.size()>0)
	       {
	    	   for(Product p:plist3)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       session.close();
	       sf.close();
	}
	public void orderdemo()
	{
		   Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       System.out.println("****order demo****");
	       
	       Criteria c1 = session.createCriteria(Product.class);

	      // c1.addOrder(Order.asc("cost"));
	       c1.addOrder(Order.desc("cost"));

	       //stock=10 and stock<20 ; where stock is property
	       List<Product> plist1 = c1.list();
	       System.out.println("*****and restrictions*****");
	       System.out.println("Total Products="+plist1.size());
	       if(plist1.size()>0)
	       {
	    	   for(Product p:plist1)
	    	   {
	    		   System.out.println(p.toString());
	    	   }
	       }
	       else
	       {
	    	   System.out.println("Product Data Not Found");
	       }
	       
	       session.close();
	       sf.close();
	}
	public void HCQAll()
	{
		Configuration cfg = new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	         
	      SessionFactory sf = cfg.buildSessionFactory();
	      Session session = sf.openSession();
	      
	      System.out.println("****HCQL with Restrictions+ Projections + Order****");
	      
	      Criteria c = session.createCriteria(Product.class);
	      
	      c.add(Restrictions.gt("cost", 20000.0));
	      c.setProjection(Projections.property("vendor")); // vendor is a property name
	      c.addOrder(Order.desc("cost")); // descending order
	      
	      List plist = c.list();
	      System.out.println("****Name property****");
	      if(plist.size()>0) {
	        for(int i=0;i<plist.size();i++) {
	          System.out.println(plist.get(i));
	        }
	      }
	      else {
	        System.out.println("Product Data Not Found");
	      }
	      
	      session.close();
	      sf.close();
	}

	public void pagination()
    {
      Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Criteria c = session.createCriteria(Product.class);
        c.setFirstResult(2); // starts from 3rd record
        c.setMaxResults(10);  // 10 Max Records
        List<Product> plist = c.list();
        System.out.println("*****Pagination*****");      
        System.out.println("Number of Products="+plist.size());
        if(plist.size()>0)
        {
          for(Product p : plist)
          {
            System.out.println(p.toString());
          }
        }
        else
        {
          System.out.println("Product Data Not Found");
        }
        
       
        session.close();
        sf.close();
    }
	
	
}
