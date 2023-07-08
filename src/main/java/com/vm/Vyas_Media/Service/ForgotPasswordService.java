package com.vm.Vyas_Media.Service;

import java.time.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.ForgotPassword;
import com.vm.Vyas_Media.Repository.ForgotPasswordRepository;

@Service
public class ForgotPasswordService {

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	@Autowired
	private ForgotPasswordRepository forgotPasswordRepository;

	public String forgotPassword(String email) {

		Optional<ForgotPassword> userOptional = Optional
				.ofNullable(forgotPasswordRepository.findByEmail(email));

		if (!userOptional.isPresent()) {
			return "Invalid email id.";
		}

		ForgotPassword user = userOptional.get();
		user.setToken(generateToken());
		user.setTokenCreationDate(LocalDateTime.now());

		user = forgotPasswordRepository.save(user);

		return user.getToken();
	}

	public String resetPassword(String token, String password) {

		Optional<ForgotPassword> userOptional = Optional
				.ofNullable(forgotPasswordRepository.findByToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";

		}

		ForgotPassword user = userOptional.get();

		user.setPassword(password);
		user.setToken(null);
		user.setTokenCreationDate(null);

		forgotPasswordRepository.save(user);

		return "Your password successfully updated.";
	}

	/**
	 * Generate unique token. You may add multiple parameters to create a strong
	 * token.
	 * 
	 * @return unique token
	 */
	private String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}

	/**
	 * Check whether the created token expired or not.
	 * 
	 * @param tokenCreationDate
	 * @return true or false
	 */
	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}
}