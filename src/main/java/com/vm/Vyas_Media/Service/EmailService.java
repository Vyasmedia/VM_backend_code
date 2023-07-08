package com.vm.Vyas_Media.Service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {

	String sendmail(MultipartFile[] file, String to, String subject, String body);

}
