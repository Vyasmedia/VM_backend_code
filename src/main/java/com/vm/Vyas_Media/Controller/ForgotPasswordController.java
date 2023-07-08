package com.vm.Vyas_Media.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vm.Vyas_Media.Service.ForgotPasswordService;

@RestController
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email) {

		String response = forgotPasswordService.forgotPassword(email);

		if (!response.startsWith("Invalid")) {
			response = "http://localhost:8081/reset-password?token=" + response;
		}
		return response;
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token,
			@RequestParam String password) {

		return forgotPasswordService.resetPassword(token, password);
	}
}