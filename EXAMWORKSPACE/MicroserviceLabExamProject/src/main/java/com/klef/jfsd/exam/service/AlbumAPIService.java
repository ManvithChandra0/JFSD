package com.klef.jfsd.exam.service;

import java.util.List;
import com.klef.jfsd.exam.model.Album;


public interface AlbumAPIService 
{
	
	public List<Album> viewAllAlbums();
	public Object viewalbumsbyid(int id);

	
}
