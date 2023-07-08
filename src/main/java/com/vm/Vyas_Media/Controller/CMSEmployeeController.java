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
import com.vm.Vyas_Media.Entity.CMSEmployee;
import com.vm.Vyas_Media.Service.CMSEmployeeService;

@RestController
public class CMSEmployeeController {

	@Autowired
	CMSEmployeeService cmsEmployeeService;

	@GetMapping("/cmsemployee")
	private List<CMSEmployee> getAllCMSEmployee() {
		return cmsEmployeeService.getAllCMSEmployee();
	}

	@GetMapping("/cmsemployee/{id}")
	private CMSEmployee getCMSEmployees(@PathVariable("id") int id) {
		return cmsEmployeeService.getCMSEmployeeById(id);
	}

	@DeleteMapping("/cmsemployee/{id}")
	private void deleteCMSEmployee(@PathVariable("id") int id) {
		cmsEmployeeService.delete(id);
	}

	@PostMapping("/cmsemployees")
	private int saveCMSEmployee(@RequestBody CMSEmployee cmsemployee) {
		cmsEmployeeService.saveOrUpdate(cmsemployee);
		return cmsemployee.getId();
	}

	@PutMapping("/cmsemployees")
	private CMSEmployee update(@RequestBody CMSEmployee cmsemployee) {
		cmsEmployeeService.saveOrUpdate(cmsemployee);
		return cmsemployee;
	}
}
