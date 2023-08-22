package com.vm.Vyas_Media.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vm.Vyas_Media.Entity.AdvertiseWithUs;
import com.vm.Vyas_Media.Service.AdvertiseWithUsService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AdvertiseWithUsController {
	
	@Autowired  
	AdvertiseWithUsService advertiseWithUsService;  
	   
	@GetMapping("/advertiseWithus")  
	private List<AdvertiseWithUs> getAllAdvertiseWithUs()   
	{  
	return advertiseWithUsService.getAllAdvertiseWithUs();  
	}  
	  
	@GetMapping("/advertiseWithus/{id}")  
	private AdvertiseWithUs getCareers(@PathVariable("id") int id)   
	{  
	return advertiseWithUsService.getAdvertiseWithUsById(id);  
	}  
	  
	@DeleteMapping("/advertiseWithus/{id}")  
	private void deleteAdvertiseWithUs(@PathVariable("id") int id)   
	{  
		advertiseWithUsService.delete(id);  
	}  
	  
	@PostMapping("/advertiseWithUs")  
	private int saveAdvertiseWithUs(@RequestBody AdvertiseWithUs advertiseWithUs)   
	{  
		advertiseWithUsService.saveOrUpdate(advertiseWithUs);  
	return advertiseWithUs.getId();  
	}  
	   
	@PutMapping("/advertiseWithUs")  
	private AdvertiseWithUs update(@RequestBody AdvertiseWithUs advertiseWithUs)   
	{  
		advertiseWithUsService.saveOrUpdate(advertiseWithUs);  
	return advertiseWithUs;  
	}

}
