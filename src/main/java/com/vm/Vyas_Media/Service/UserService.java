package com.vm.Vyas_Media.Service;

import java.util.List;

import com.vm.Vyas_Media.Payload.UserDto;


public interface UserService {

	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
	

}
