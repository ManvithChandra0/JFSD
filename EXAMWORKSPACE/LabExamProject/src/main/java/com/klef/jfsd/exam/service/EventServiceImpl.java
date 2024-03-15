package com.klef.jfsd.exam.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.klef.jfsd.exam.model.Event;
import com.klef.jfsd.exam.repository.EventRepository;

public class EventServiceImpl implements EventService
{

	@Autowired
	private EventRepository eventRepository;

	@Override
	public String addevent(Event event) 
	{
		eventRepository.save(event);
		return "Event Added Successfully";	}

	@Override
	public Event viewallevents(int eid) 
	{
		return eventRepository.findAll();	}

	@Override
	public String deleteevent(int eid) 
	{
		return null;
	}
	
	
	

}
