package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    
@Table 
public class CMSEmployee {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	
	@Column  
	private String name; 
	
	@Column  
	private String department;  
	
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public CMSEmployee() {
		super();
	}
	public CMSEmployee(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}	
}
