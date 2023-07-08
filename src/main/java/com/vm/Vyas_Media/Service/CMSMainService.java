package com.vm.Vyas_Media.Service;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.CMSMain;
import com.vm.Vyas_Media.Repository.CMSMainRepository;
 
@Service  
public class CMSMainService {
 
	@Autowired  
	CMSMainRepository cmsmainRepository;  
	  
	public List<CMSMain> getAllCMSMain()   
	{  
	List<CMSMain> cmsmain = new ArrayList<CMSMain>();  
	cmsmainRepository.findAll().forEach(cmsmain1 -> cmsmain.add(cmsmain1));  
	return cmsmain;  
	}  
	 
	public CMSMain getCMSMainById(int id)   
	{  
	return cmsmainRepository.findById(id).get();  
	}  
	 
	public void saveOrUpdate(CMSMain cmsmain)   
	{  
		cmsmainRepository.save(cmsmain);  
	}  

	public void delete(int id)   
	{  
		cmsmainRepository.deleteById(id);  
	}  
	
	public void update(CMSMain cmsmain, int id)   
	{  
		cmsmainRepository.save(cmsmain);  
	}  
	}  