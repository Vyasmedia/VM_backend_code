package com.vm.Vyas_Media.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.CMSEmployee;
import com.vm.Vyas_Media.Repository.CMSEmployeeRepository;

@Service 
public class CMSEmployeeService {
	
	@Autowired  
	CMSEmployeeRepository cmsEmployeeRepository;  
	  
	public List<CMSEmployee> getAllCMSEmployee()   
	{  
	List<CMSEmployee> cmsemployee = new ArrayList<CMSEmployee>();  
	cmsEmployeeRepository.findAll().forEach(cmsemployee1 -> cmsemployee.add(cmsemployee1));  
	return cmsemployee;  
	}  
	 
	public CMSEmployee getCMSEmployeeById(int id)   
	{  
	return cmsEmployeeRepository.findById(id).get();  
	}  
	 
	public void saveOrUpdate(CMSEmployee cmsemployee)   
	{  
		cmsEmployeeRepository.save(cmsemployee);  
	}  

	public void delete(int id)   
	{  
		cmsEmployeeRepository.deleteById(id);  
	}  
	
	public void update(CMSEmployee cmsemployee, int id)   
	{  
		cmsEmployeeRepository.save(cmsemployee);  
	}  
}
