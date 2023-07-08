package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class CMSMain {
	@Id  
	@Column  
	private int id;  
	@Column  
	private String headline; 
	@Column  
	private String subHeadline;  
	@Column  
	private String description;  
	@Column  
	private String hashtag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getSubHeadline() {
		return subHeadline;
	}
	public void setSubHeadline(String subHeadline) {
		this.subHeadline = subHeadline;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public CMSMain() {
		super();
	}
	public CMSMain(int id, String headline, String subHeadline, String description, String hashtag) {
		super();
		this.id = id;
		this.headline = headline;
		this.subHeadline = subHeadline;
		this.description = description;
		this.hashtag = hashtag;
	}
	
}
