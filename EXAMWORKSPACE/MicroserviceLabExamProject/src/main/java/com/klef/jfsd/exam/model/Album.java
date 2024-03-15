package com.klef.jfsd.exam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="album_table")
public class Album
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;
  public int getId() {
	return id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public void setId(int id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
@Override
public String toString() {
	return "Album [id=" + id + ", userId=" + userId + ", title=" + title + "]";
}

public void setUserId(String userId) {
	this.userId = userId;
}

@Column(name="userId",nullable=false,length = 50)
  private String userId;
  @Column(name="title",nullable=false,length = 20000)
  private String title;
  
}