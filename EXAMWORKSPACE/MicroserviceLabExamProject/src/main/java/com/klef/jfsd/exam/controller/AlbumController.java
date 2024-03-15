package com.klef.jfsd.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.exam.repository.AlbumRepositorty;
import com.klef.jfsd.exam.service.AlbumAPIService;
import com.klef.jfsd.exam.model.Album;


@RestController
public class AlbumController
{
	@Autowired
	private AlbumAPIService apiService;
	
	@GetMapping("/")
	public String demo()
	{
		return "ExternalAPI Using Jsonplaceholder To Display Albums ";
	}
	
	@GetMapping("viewallalbums")
	public List<Album> viewallalbums()
	{
		return apiService.viewAllAlbums();
	}
	
	@GetMapping("viewalbums/{id}")
	public Object viewalbums(@PathVariable("id") int id)
	{
		return apiService.viewalbumsbyid(id);
	}
	
	


}
