package ConstructorDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientController 
{

	public static void main(String[] args) 
	{
		System.out.println("***ApplicationContext as Spring IoC Container***");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		Employee e = (Employee)context.getBean("empbean"); //at this line object will be created at run-time
		System.out.println("**constructor Dependency Injection**");
		System.out.println(e.toString());
		
		context.close();
		
	}

}
