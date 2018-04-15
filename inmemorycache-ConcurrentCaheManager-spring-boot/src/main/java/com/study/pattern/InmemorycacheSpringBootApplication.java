package com.study.pattern;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.study.pattern.repository.EmployeRepository;

@SpringBootApplication
@EnableCaching
public class InmemorycacheSpringBootApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass());	

	public static void main(String[] args) {
	 ConfigurableApplicationContext run = SpringApplication.run(InmemorycacheSpringBootApplication.class, args);
	 EmployeRepository employeRepo = run.getBean(EmployeRepository.class);
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.fetchAllEmployes());
	 logger.info("===============================================================================");
	 
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.fetchAllEmployes());
	 logger.info("===============================================================================");
	}
}
