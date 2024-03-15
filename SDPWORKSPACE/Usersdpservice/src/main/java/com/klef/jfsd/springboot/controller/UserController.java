package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Contact;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.model.WeatherData;
import com.klef.jfsd.springboot.repository.WeatherDataRepository;
import com.klef.jfsd.springboot.service.UserService;
import com.klef.jfsd.springboot.service.WeatherService;

import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")

public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	
	@GetMapping("userreg")
	public ModelAndView userregistraion() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userreg");
		return mv;
		
	}
	@GetMapping("userlogin")
	public ModelAndView userlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userlogin");
		return mv;
		
	}
	@PostMapping("checkuserlogin")
	public  ModelAndView checkuserlogin(HttpServletRequest request) {
	     ModelAndView mv = new ModelAndView();
	     
	     String email = request.getParameter("email");
	     String pwd = request.getParameter("pwd");
	     
	     User user = userService.checkuserlogin(email, pwd);
	     if(user!=null) {
	    	 
	    	 HttpSession session = request.getSession();
	    	 
	    	 session.setAttribute("eid", user.getId());
	    	 session.setAttribute("ename", user.getName());
	    	 
	    	 
	    	 
	    	 mv.setViewName("userhome");
	     }
	     else {
	    	 mv.setViewName("userlogin");
	    	 mv.addObject("message","Login Failed");
	     }

	     return mv;
	}
	@GetMapping("userhome")
	   public ModelAndView userhome(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("userhome");
    	 HttpSession session = request.getSession();
    	  
    	 int eid = (int)session.getAttribute("eid"); // eid is a session variable 
    	 String ename =(String)session.getAttribute("ename");  // ename is a session variable
    	 
    	 mv.addObject("eid",eid);
    	 mv.addObject("ename",ename);

	     
	     return mv;
	   }
	
	
	
	@PostMapping("insertuser")
	public ModelAndView insertaction(HttpServletRequest request) {
	     ModelAndView mv = new ModelAndView();
	     String msg = null;
	     try 
	     {
	    	 String name = request.getParameter("name");
	    	 String email = request.getParameter("email");
	    	 String pwd = request.getParameter("pwd");
	    	 String location = request.getParameter("location");
	    	 String contact = request.getParameter("contact");
	    	 
	    	 User user = new User();
	    	  user.setName(name);
	          user.setEmail(email);
	          user.setPassword(pwd);
	          user.setLocation(location);
	          user.setContact(contact);
	          user.setActive(true);
	    	 
	          msg = userService.adduser(user);
	          mv.setViewName("displaymsg");
	          mv.addObject("message",msg);
	     } 
	     catch (Exception e) 
	     {
			mv.setViewName("displayerror");
			
			msg = e.getMessage();
	        mv.addObject("message",msg);
	     }
	     return mv;
	}
	
	@GetMapping("updateprofile")
	   public ModelAndView updateuser(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     
	     HttpSession session = request.getSession();
	     
	     mv.setViewName("updateprofile");
	     
	     mv.addObject("eid", session.getAttribute("eid"));
	     mv.addObject("ename", session.getAttribute("ename"));
	     
	     int id = (int) session.getAttribute("eid");
	     
	     User user = userService.viewuserbyid(id);
	     
	     mv.addObject("user", user);
	     
	     return mv;
	   }
	   
	   @PostMapping("update")
	   public ModelAndView updateaction(HttpServletRequest request)
	   {
	     String msg = null;
	     
	     ModelAndView mv = new ModelAndView();
	     
	       HttpSession session = request.getSession();
	     
	     mv.addObject("eid", session.getAttribute("eid"));
	     mv.addObject("ename", session.getAttribute("ename"));
	     
	     int id = (int) session.getAttribute("eid");
	     
	    try
	    {
	      String name = request.getParameter("name");
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      String location = request.getParameter("location");
	      String contact = request.getParameter("contact");
	      
	      User user = new User();
	       user.setId(id);
	       user.setName(name);
	       user.setEmail(email);
	       user.setPassword(pwd);
	       user.setLocation(location);
	       user.setContact(contact);
	       
	       
	       msg = userService.updateuser(user);
	       
	       mv.setViewName("userlogin");
	       mv.addObject("message",msg);
	      
	    }
	    catch(Exception e)
	    {
	      msg = e.getMessage();
	      
	      mv.setViewName("updateerror");
	       mv.addObject("message",msg);
	    }
	     
	    
	     return mv;

	   }
		@GetMapping("about")
		   public ModelAndView about()
		   {
		     ModelAndView mv = new ModelAndView();
		     mv.setViewName("about");
		     return mv;
		   }
		@GetMapping("contact")
		   public ModelAndView contact()
		   {
		     ModelAndView mv = new ModelAndView();
		     mv.setViewName("contact");
		     return mv;
		   }
		@GetMapping("weather")
		   public ModelAndView weather()
		   {
		     ModelAndView mv = new ModelAndView();
		     mv.setViewName("weather");
		     return mv;
		   }
		@GetMapping("map")
		   public ModelAndView map()
		   {
		     ModelAndView mv = new ModelAndView();
		     mv.setViewName("map");
		     return mv;
		   }
		
		@GetMapping("news")
		   public ModelAndView news()
		   {
		     ModelAndView mv = new ModelAndView();
		     mv.setViewName("news");
		     return mv;
		   }
		
		@PostMapping("insertcontact")
		public ModelAndView insertcontact(HttpServletRequest request) {
		     ModelAndView mv = new ModelAndView();
		     String msg = null;
		     try 
		     {
		    	 String name = request.getParameter("name");
		    	 String email = request.getParameter("email");
		    	 String msgs=request.getParameter("message");
		    	 
		    	 Contact contact=new Contact();
		    	 
		    	 contact.setName(name);
		    	 contact.setEmail(email);
		    	 contact.setMessage(msgs);
		    	 
		          msg = userService.insertcontact(contact);
		          mv.setViewName("contact");
		          mv.addObject("message",msg);
		     } 
		     catch (Exception e) 
		     {
				mv.setViewName("contact");
				
				msg = e.getMessage();
		        mv.addObject("message",msg);
		     }
		     return mv;
		}
	    @Autowired
	    private WeatherService weatherService;
	    @Autowired
	    private WeatherDataRepository weatherDataRepository;

	    @GetMapping("weatherdb")
	    public String weatherdb(Model model) {
	        // Fetch and display weather data from the database
	        List<WeatherData> weatherDataList = weatherDataRepository.findAll();
	        model.addAttribute("weatherDataList", weatherDataList);
	        return "weatherdb";
	    }

	  
	    @PostMapping("search")
	    public String searchWeather(@RequestParam("city") String city, Model model) {
	        WeatherData weatherData = weatherService.fetchWeatherData(city);
	        model.addAttribute("weatherData", weatherData);
	        return "weatherdb";
	    }
		
}
