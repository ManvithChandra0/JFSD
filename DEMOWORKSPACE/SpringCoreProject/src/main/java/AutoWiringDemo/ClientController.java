package AutoWiringDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientController 
{
	public static void main(String [] args)
	{
		System.out.println("***ApplicationContext as Spring IoC Container***");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		Person p = (Person)context.getBean("personbean"); //at this line object will be created at run-time
		System.out.println("**AutoWiring Demo**");
		System.out.println(p.toString());
		
		Address a = (Address)context.getBean("addressbean"); //at this line object will be created at run-time
		System.out.println(a.toString());
		context.close();
	}
}
