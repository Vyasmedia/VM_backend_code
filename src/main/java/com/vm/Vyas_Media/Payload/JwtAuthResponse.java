package com.vm.Vyas_Media.Payload;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
	
	
}
