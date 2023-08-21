package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;
import javax.persistence.Id; 
import javax.persistence.Entity;   
import javax.persistence.Table;  
  
  
public class Journalist {
	
	@Id  
	@Column  
	private int id;  
	
	@Column  
	private String name;  
	
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

	public Journalist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Journalist(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;

	}
	@Override
	public String toString() {
		return "Journalist [id=" + id + ", name=" + name + "]";
	}

	
}
