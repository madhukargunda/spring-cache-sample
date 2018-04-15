package com.study.pattern.repository;

import java.util.List;

import com.study.pattern.bo.Employe;

public interface EmployeRepository {	
	List<Employe> fetchAllEmployes();
	Employe getFirstEmploye();
	Employe getEmployeByFirstNameAndLastName(String firstName,String lastName);
}
