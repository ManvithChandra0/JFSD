package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.service.ExternalAPIService;

@RestController
public class RestAPIController
{
	@Autowired
	private ExternalAPIService apiService;
	
	@GetMapping("/")
	public String demo()
	{
		return "<b>MicroService Demo using ExternalAPI</b>";
	}
	
	@GetMapping("viewallalbums")
	public List<Object> viewallposts()
	{
		return apiService.viewallposts();
	}
	
	@GetMapping("viewalbums/{id}")
	public Object viewpost(@PathVariable("id") int id)
	{
		return apiService.viewpostbyid(id);
	}
	
	@GetMapping("viewallcustomers")
	public List<Object> viewallcustomers()
	{
		return apiService.viewallcustomers();
	}
}