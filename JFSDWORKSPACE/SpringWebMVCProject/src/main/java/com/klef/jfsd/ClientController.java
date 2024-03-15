package com.klef.jfsd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView demo()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");		//home is jsp file name
		
		return mv;
	}
	
	@RequestMapping(path = "/demo1")	//by default get Method
	public ModelAndView demo1()
	{
		ModelAndView mv = new ModelAndView("test"); 	//test is jsp file name
		
		return mv;	
	}

	@RequestMapping("/demo2")	//by default get Method
	public ModelAndView demo2()		//URI name and method name can be different
	{
		ModelAndView mv = new ModelAndView("main"); 	//test is jsp file name
		
		return mv;	
	}

	@GetMapping("demo3")
	public ModelAndView demo3()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");		//admin is jsp file name
		
		return mv;
	}


	@GetMapping("demo4")
	public ModelAndView demo4()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");		//user is jsp file name
		mv.addObject("name","klu");
		return mv;
	}
	
	
	
	
	
	
}
