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
import com.vm.Vyas_Media.Entity.CMSMain;
import com.vm.Vyas_Media.Service.CMSMainService;
 
@RestController
public class CMSMainController {

@Autowired  
CMSMainService cmsMainService;  
   
@GetMapping("/cmsmain")  
private List<CMSMain> getAllCMSMain()   
{  
return cmsMainService.getAllCMSMain();  
}  
  
@GetMapping("/cmsmain/{id}")  
private CMSMain getCMSMains(@PathVariable("id") int id)   
{  
return cmsMainService.getCMSMainById(id);  
}  
  
@DeleteMapping("/cmsmain/{id}")  
private void deleteCMSMain(@PathVariable("id") int id)   
{  
	cmsMainService.delete(id);  
}  
  
@PostMapping("/cmsmains")  
private int saveCMSMain(@RequestBody CMSMain cmsmain)   
{  
	cmsMainService.saveOrUpdate(cmsmain);  
return cmsmain.getId();  
}  
   
@PutMapping("/cmsmains")  
private CMSMain update(@RequestBody CMSMain cmsmain)   
{  
	cmsMainService.saveOrUpdate(cmsmain);  
return cmsmain;  
}
}