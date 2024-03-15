package AnnotationsDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationConifg 
{
//	@Bean
	@Bean(name = "customerbean")
	public Customer setterdemo()
	{
		Customer c = new Customer();
		c.setId(100);
		c.setName("KLU");
		c.setAge(23.5f);
		c.setSalary(12000.50);
		c.setMaritalstatus(true);
		
		List<String> productslist = new ArrayList<String>();
		productslist.add("mobile");
		productslist.add("watch");
		productslist.add("laptop");
		
		c.setProducts(productslist);
		return c;
		
	}
//	@Bean
	@Bean("facultybean")
	public Faculty constructordemo()
	{
		Faculty f = new Faculty(4654, "KLU",40.5f, 23000.0, true,Arrays.asList("MSWD","EP","JFSD"));
		return f;
	}
}