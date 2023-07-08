package com.vm.Vyas_Media.Service;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.AdvertiseWithUs;
import com.vm.Vyas_Media.Repository.AdvertiseWithUsRepository;

@Service 
public class AdvertiseWithUsService {
	
	@Autowired  
	AdvertiseWithUsRepository advertiseWithUsRepository; 
	
	public List<AdvertiseWithUs> getAllAdvertiseWithUs()   
	{  
	List<AdvertiseWithUs> advertiseWithUs = new ArrayList<AdvertiseWithUs>();  
	advertiseWithUsRepository.findAll().forEach(advertiseWithUs1 -> advertiseWithUs.add(advertiseWithUs1));  
	return advertiseWithUs;  
	}  
	 
	public AdvertiseWithUs getAdvertiseWithUsById(int id)   
	{  
	return advertiseWithUsRepository.findById(id).get();  
	}  
	 
	public void saveOrUpdate(AdvertiseWithUs advertiseWithUs)   
	{  
		advertiseWithUsRepository.save(advertiseWithUs);  
	}  

	public void delete(int id)   
	{  
		advertiseWithUsRepository.deleteById(id);  
	}  
	
	public void update(AdvertiseWithUs advertiseWithUs, int id)   
	{  
		advertiseWithUsRepository.save(advertiseWithUs);  
	}

}


 
 

 
 
	  
  
	