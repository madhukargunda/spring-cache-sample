package com.study.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationPropertiesSpringBootApplication implements CommandLineRunner {

	@Value("${application.name}")
	private String applicationName;
	
	@Value("${application.user.name}")
	private String userName;
	
	
	Logger log = LoggerFactory.getLogger(getClass().getName());
			
	public static void main(String[] args) {
		SpringApplication.run(ApplicationPropertiesSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application Name : {} , username : {} ",applicationName,userName);
		
	}
	
	
	
}
