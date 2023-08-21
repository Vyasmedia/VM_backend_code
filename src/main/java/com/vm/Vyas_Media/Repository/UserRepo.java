package com.vm.Vyas_Media.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.Vyas_Media.Entity.User;


public interface UserRepo extends JpaRepository<User, Integer>{
		
	Optional<User> findByEmail(String email);
	
}
