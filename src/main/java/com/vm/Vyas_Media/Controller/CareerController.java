package com.vm.Vyas_Media.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vm.Vyas_Media.Entity.Career;
import com.vm.Vyas_Media.Service.CareerService;

//mark class as Controller  
@RestController
public class CareerController {

	@Autowired
	CareerService careerService;

	@GetMapping("/career")
	private List<Career> getAllCareer() {
		return careerService.getAllCareer();
	}

	@GetMapping("/career/{id}")
	private Career getCareers(@PathVariable("id") int id) {
		return careerService.getCareerById(id);
	}

	@DeleteMapping("/career/{id}")
	private void deleteCareer(@PathVariable("id") int id) {
		careerService.delete(id);
	}

	@PostMapping("/careers")
	private int saveCareer(@RequestBody Career career) {
		careerService.saveOrUpdate(career);
		return career.getId();
	}

	@PutMapping("/careers")
	private Career update(@RequestBody Career career) {
		careerService.saveOrUpdate(career);
		return career;
	}
}