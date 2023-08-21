package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CMSRequest {
	
    private String headline; 
	
  
	private String subHeadline;  

	private String description;  
	
	private String hashtag;
	
	private String name; 
	
	private String department;
	
	
	}