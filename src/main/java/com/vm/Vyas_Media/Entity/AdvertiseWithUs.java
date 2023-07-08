package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    
@Table
public class AdvertiseWithUs {
	@Id  
	@Column  
	private int id; 
	@Column  
	private String fullname; 
	@Column  
	private String email; 
	@Column  
	private String companyName;
	@Column  
	private String companyType;
	@Column  
	private String websitelink;
	@Column  
	private String addressCompany;
	@Column  
	private String addressUser;
	@Column  
	private long phone1;
	@Column  
	private long phone2;
	@Column  
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getWebsitelink() {
		return websitelink;
	}
	public void setWebsitelink(String websitelink) {
		this.websitelink = websitelink;
	}
	public String getAddressCompany() {
		return addressCompany;
	}
	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}
	public String getAddressUser() {
		return addressUser;
	}
	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}
	public long getPhone1() {
		return phone1;
	}
	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}
	public long getPhone2() {
		return phone2;
	}
	public void setPhone2(long phone2) {
		this.phone2 = phone2;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AdvertiseWithUs() {
		super();
	}
	public AdvertiseWithUs(int id, String fullname, String email, String companyName, String companyType,
			String websitelink, String addressCompany, String addressUser, long phone1, long phone2, String message) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.companyName = companyName;
		this.companyType = companyType;
		this.websitelink = websitelink;
		this.addressCompany = addressCompany;
		this.addressUser = addressUser;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.message = message;
	}
	
	
}
