package com.study.pattern.keygenerator;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Component;

@Component
public class MethodArgumetsCacheKeyGenertor implements KeyGenerator {
	
	private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());	

	@Override
	public Object generate(Object target, Method method, Object... params) {
		
		if(params.length==0){
			return new SimpleKey(method.getName());
		}else {
			
			logger.info("The List Of Parameters ARE  ................. {} ",params.toString());
			return new SimpleKey(params);}
	}

}
