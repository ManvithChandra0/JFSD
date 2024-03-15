package com.klef.jfsd.pagination;

import javax.persistence.*;

@Entity
@Table(name="employee_table")
public class Employee 
{
  
@Id
  @Column(name="pid")
  private int id;
  @Column(name="ename",length = 20,nullable = false)
  private String name;
  @Column(name="edept",length = 20,nullable = false)
  private String dept;
  @Column(name="econtact",length = 20,nullable = false)
  private String contact;
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
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", contact=" + contact + "]";
}

}