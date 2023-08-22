package com.vm.Vyas_Media.Entity;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity    
@Table  
public class Career {
	@Id  
	@Column  
	private int id;  
	@Column  
	private String fullname; 
	@Column  
	private String email;  
	@Column  
	private long contactno;
//	 @CreationTimestamp
//	    @Column(updatable = false)
//    private Date birthDay; 
	   @JsonFormat(pattern="yyyy-MM-dd")
	    private LocalDate birthDay;
	@Column  
	private String address;  
	@Column  
	private String education;
	@Column  
	private String role;
	@Column  
	private int experience;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	} 


	public Career() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Career(int id, String fullname, String email, long contactno, LocalDate birthDay, String address,
			String education, String role, int experience) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.contactno = contactno;
		this.birthDay = birthDay;
		this.address = address;
		this.education = education;
		this.role = role;
		this.experience = experience;
	}
 
    
}