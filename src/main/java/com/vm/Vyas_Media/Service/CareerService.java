package com.vm.Vyas_Media.Service;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.Career;
import com.vm.Vyas_Media.Repository.CareerRepository;
 
@Service  
public class CareerService {
 
	@Autowired  
	CareerRepository careerRepository;  
	  
	public List<Career> getAllCareer()   
	{  
	List<Career> career = new ArrayList<Career>();  
	careerRepository.findAll().forEach(career1 -> career.add(career1));  
	return career;  
	}  
	 
	public Career getCareerById(int id)   
	{  
	return careerRepository.findById(id).get();  
	}  
	 
	public void saveOrUpdate(Career career)   
	{  
		careerRepository.save(career);  
	}  

	public void delete(int id)   
	{  
		careerRepository.deleteById(id);  
	}  
	
	public void update(Career career, int id)   
	{  
		careerRepository.save(career);  
	}  
	}  