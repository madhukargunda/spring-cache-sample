package com.study.pattern.repository.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.study.pattern.bo.Employe;
import com.study.pattern.repository.EmployeRepository;

@Repository
public class EmployeRepositoryImpl implements EmployeRepository {
	
	private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());	

	@Autowired
	List<Employe> employeList;
	
	@Override
	@Cacheable(value="allEmployesCache" ,key="'allEmployes'")
	public List<Employe> fetchAllEmployes() {	
		logger.info("Invoking the getAllEmployes method");
		return employeList;
	}

	@Override
	@Cacheable(value="userCache" , key="#root.methodName")
	public Employe getFirstEmploye() {
		return employeList.get(0);
	}

	@Override
	@Cacheable(value="userCache" , key="#firstName,#lastName")
	public Employe getEmployeByFirstNameAndLastName(String firstName,String lastName) {
		logger.debug("Invoking the getEmployeByFirstNameAndLastName :");
		Optional<Employe> findFirst = employeList.stream().filter(e -> e.getFirstName().equalsIgnoreCase(firstName) && e.getLastName().equalsIgnoreCase(lastName)).findFirst();
	   if(findFirst.isPresent()){
		   return findFirst.get();
	   } else
		return null;
	}
	
	

	

}
