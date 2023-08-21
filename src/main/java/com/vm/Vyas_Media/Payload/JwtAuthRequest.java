package com.vm.Vyas_Media.Payload;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	
	private String password;	
	
}
