package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Event;

public interface EventService
{
	public String addevent(Event event);
	public Event viewallevents(int eid);
	public String deleteevent(int eid);
	

}
