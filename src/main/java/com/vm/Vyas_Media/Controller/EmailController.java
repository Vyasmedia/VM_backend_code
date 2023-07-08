package com.vm.Vyas_Media.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.vm.Vyas_Media.Service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
 private EmailService emailservice;
 
 public EmailController(EmailService emailservice) {
	this.emailservice=emailservice;
}

@PostMapping("/send")
 public String sendmail(@RequestParam(value="file" , required=false)  MultipartFile[] file,String to,String subject,String body) {
	return emailservice.sendmail(file,to,subject,body);
 }
}
