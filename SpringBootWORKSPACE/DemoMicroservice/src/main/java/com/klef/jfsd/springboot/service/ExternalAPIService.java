package com.klef.jfsd.springboot.service;

import java.util.List;

public interface ExternalAPIService 
{
	//External API [JSON Placeholder]
	
	public List<Object> viewallposts();
	public Object viewpostbyid(int id);
	
	//Internal API[SpringBootRestAPIProject]
	public List<Object> viewallcustomers();	
}
