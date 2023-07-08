package com.vm.Vyas_Media.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vm.Vyas_Media.Entity.Journalist;

@RestController
@RequestMapping("/journalist")
public class JournalistController {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(JournalistController.class);
	
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/info")
	public ResponseEntity<?> addJournalistInformation(@RequestParam("file")MultipartFile file,@RequestParam("userData") String userData ) {
		this.logger.info("add journalist info");
		logger.info("file info:{}", file.getOriginalFilename());
		logger.info("userData:{}", userData);
		
		Journalist journalist =null;
		try { 
			journalist =mapper.readValue(userData,Journalist.class);
		}
		catch(JsonProcessingException e){
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid request");
		}	
		this.logger.info("journalist info is : {}",journalist);
		return ResponseEntity.ok("done");
	}

}