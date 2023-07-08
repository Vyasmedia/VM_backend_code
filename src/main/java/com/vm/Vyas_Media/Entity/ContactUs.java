package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table  
public class ContactUs  
{  

@Id  
@Column  
private int id;  
@Column  
private String firstname;  
@Column  
private String lastname;  
@Column  
private String email;  
@Column  
private long mobile;
@Column  
private String message;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}