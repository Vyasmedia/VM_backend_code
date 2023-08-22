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
import com.vm.Vyas_Media.Entity.ContactUs;
import com.vm.Vyas_Media.Service.ContactusService;  

@RestController  
@RequestMapping("/cms")
public class ContactusController   
{  

@Autowired  
ContactusService contactusService;  
  
@GetMapping("/contact")  
private List<ContactUs> getAllContacts()   
{  
return contactusService.getAllContacts();  
}  
 
@GetMapping("/contact/{id}")  
private ContactUs getContacts(@PathVariable("id") int id)   
{  
return contactusService.getContactsById(id);  
}  

@DeleteMapping("/contact/{id}")  
private void deleteContact(@PathVariable("id") int id)   
{  
	contactusService.delete(id);  
}  
  
@PostMapping("/contacts")  
private int saveContact(@RequestBody ContactUs contactus)   
{  
	contactusService.saveOrUpdate(contactus);  
return contactus.getId();  
}  
  
@PutMapping("/contacts")  
private ContactUs update(@RequestBody ContactUs contactus)   
{  
	contactusService.saveOrUpdate(contactus);  
return contactus;  
}  
}  
