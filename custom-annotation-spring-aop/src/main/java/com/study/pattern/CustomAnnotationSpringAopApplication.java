package com.study.pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.study.pattern.service.CustomerService;

@SpringBootApplication
public class CustomAnnotationSpringAopApplication {
	
	@Autowired
	CustomerService customerSercvice;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CustomAnnotationSpringAopApplication.class, args);
		CustomerService bean = run.getBean(CustomerService.class);
		bean.sayHello();
	}
}
