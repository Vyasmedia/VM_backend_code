package com.vm.Vyas_Media;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vm.Vyas_Media.Entity.Role;
import com.vm.Vyas_Media.Enum.AppConstants;
import com.vm.Vyas_Media.Repository.RoleRepo;

@SpringBootApplication
public class VyasMediaApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	public static void main(String[] args) {
		
		SpringApplication.run(VyasMediaApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			Role role2 = new Role();
			role2.setId(AppConstants.EMPLOYEE_USER);
			role2.setName("ROLE_EMPLOYEE"); 
			
			List<Role> roles = List.of(role, role1, role2);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
}
