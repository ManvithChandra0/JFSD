package SetterDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientController 
{
	public static void main(String [] args)
	{
		System.out.println("***ApplicationContext as Spring IoC Container***");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		Student s = (Student)context.getBean("studentbean"); //at this line object will be created at run-time
		System.out.println("***Setter Dependency Injection***");
		System.out.println(s.toString());
		
		//display id, name,email
		System.out.println("Student ID: "+s.getId());
		System.out.println("Student Name: "+s.getName());
		System.out.println("Student Email: "+s.getEmail());
		
		context.close();
		
		
	}
}
