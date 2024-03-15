package com.klef.jfsd.exam.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.klef.jfsd.exam.model.Album;
import com.klef.jfsd.exam.repository.AlbumRepositorty;

@Service
public class AlbumAPIServiceImpl implements AlbumAPIService
{
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AlbumRepositorty albumRepositorty;

	
//	@Override
//	public List<Object> viewAllAlbums() {
//		String apiurl = "https://jsonplaceholder.typicode.com/albums";
//		Object[] data = restTemplate.getForObject(apiurl, Object[].class);
//		return Arrays.asList(data);
//	}
	   @Override
	    public List<Album> viewAllAlbums() {
	        String apiUrl = "https://jsonplaceholder.typicode.com/albums";
	        Album[] albums = restTemplate.getForObject(apiUrl, Album[].class);
	        albumRepositorty.saveAll(Arrays.asList(albums));
	        return Arrays.asList(albums);
	    }

	@Override
	public Object viewalbumsbyid(int id) {
		String apiurl = "https://jsonplaceholder.typicode.com/albums/"+id;
		Object obj = restTemplate.getForObject(apiurl, Object.class);
		return obj;
		
	}


}
	



