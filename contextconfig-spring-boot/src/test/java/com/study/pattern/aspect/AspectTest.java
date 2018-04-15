package com.study.pattern.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.pattern.bo.Customer;
import com.study.pattern.config.AspectConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AspectConfig.class,Customer.class})
public class AspectTest {
	
	@Autowired
	private Customer customer;
	
	@Test
	public void testMethod(){
		
	}

}
