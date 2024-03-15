package com.klef.jfsd.exam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Event_table")
public class Event
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private int id;
	@Column(name="event_name",nullable=false,length = 50)
	private String name;
	
	@Column(name="event_salary",nullable=false)
	private double salary;
	@Column(name="event_email",nullable=false,unique = true,length = 30)
	private String email;
	@Column(name="event_password",nullable=false,length = 30)
	private String password;
	@Column(name="event_location",nullable=false)
	private String location;
	@Column(name="event_contact",nullable=false,unique = true)
	private String contact;
	@Column(name="event_active",nullable=false)
	private boolean active; // true or false
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + ", password="
				+ password + ", location=" + location + ", contact=" + contact + ", active=" + active + "]";
	}
	
	}
