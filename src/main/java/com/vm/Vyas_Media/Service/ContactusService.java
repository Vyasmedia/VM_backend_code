package com.vm.Vyas_Media.Service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.ContactUs;
import com.vm.Vyas_Media.Repository.ContactUsRepository;  
  
@Service  
public class ContactusService   
{  
@Autowired  
ContactUsRepository contactUsRepository;  

public List<ContactUs> getAllContacts()   
{  
List<ContactUs> contactus = new ArrayList<ContactUs>();  
contactUsRepository.findAll().forEach(contactus1 -> contactus.add(contactus1));  
return contactus;  
}  

public ContactUs getContactsById(int id)   
{  
return contactUsRepository.findById(id).get();  
}   
public void saveOrUpdate(ContactUs contactus)   
{  
	contactUsRepository.save(contactus);  
}  
 
public void delete(int id)   
{  
	contactUsRepository.deleteById(id);  
}  

public void update(ContactUs contactus, int id)   
{  
	contactUsRepository.save(contactus);  
}  
}  