package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Contact;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.AdminService;

import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")

public class Admincontroller {
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	@ResponseBody
	public String Admin()
	{
		return "Admin sdp microservice";
	}
	
	@GetMapping("adminlogin") 
	   public ModelAndView adminlogin(){
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminlogin");
	     return mv;
	   }
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request) {
	     String uname = request.getParameter("uname");
    	 String pwd = request.getParameter("pwd");
    	 
    	 Admin a = adminService.checkadminlogin(uname, pwd);
	     ModelAndView mv = new ModelAndView();

	     if(a!=null) {
	    	 mv.setViewName("adminhome");
	     }
	     else {
	    	 mv.setViewName("adminlogin");
	    	 mv.addObject("message","Login Failed");
	     }
	     return mv;

	}
	@GetMapping("viewallusers")
	public ModelAndView viewallusers() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallusers");
		
		List<User> userlist = adminService.viewallusers();
		mv.addObject("userdata", userlist);
		
		return mv;
	}
	

	@GetMapping("adminhome")
    public ModelAndView adminhome()
    {
    long empcount=adminService.usercount();
      ModelAndView mv = new ModelAndView();
      mv.setViewName("adminhome");
      mv.addObject("ecount", empcount);
      return mv;
    }
	@GetMapping("view")
	   public ModelAndView viewuserdemo(@RequestParam("id") int eid)
	   {
	     User user = adminService.viewuserbyid(eid);
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewuserbyid");
	     mv.addObject("user", user);
	     return mv;
	   }
	@GetMapping("deleteuser")
	   public ModelAndView deleteuser()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("deleteuser");
	     
	     List<User> userlist =  adminService.viewallusers();
	     
	     mv.addObject("userdata", userlist);
	     
	     return mv;
	   }
	
	@GetMapping("delete/{id}")
	public String deleteaction(@PathVariable("id") int eid) {
		adminService.deleteuser(eid);
		return "redirect:/deleteuser";
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
		
		
		
		@GetMapping("viewallcontact")
		public ModelAndView viewallcontact() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("viewallcontact");
			List<Contact> contactlist = adminService.viewallcontact();
			mv.addObject("contactdata", contactlist);
			
			return mv;
		}

}
