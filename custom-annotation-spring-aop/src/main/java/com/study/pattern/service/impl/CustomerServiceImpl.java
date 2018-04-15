package com.study.pattern.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.study.pattern.annotation.Time;
import com.study.pattern.service.CustomerService;


@Service	
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	@Time
	public void sayHello() {
		logger.debug("Calling the sayHello method");

	}

}
