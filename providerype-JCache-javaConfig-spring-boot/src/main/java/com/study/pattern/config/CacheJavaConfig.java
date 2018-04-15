package com.study.pattern.config;


import java.util.concurrent.TimeUnit;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//The Ehcache JSR 107 Provider

@Configuration
public class CacheJavaConfig {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	@Bean
	public JCacheManagerCustomizer getJcacheManager(){
		return cm -> {
	
			logger.info("*************************************************************************************************************");
		    logger.info("The CacheManager Provider is    :  {}  ",cm.getClass().getName());
			logger.info("*************************************************************************************************************");
			
			
			//Creating a Cache  
			
			MutableConfiguration<Object, Object> allEmployesCacheConfiguration = new MutableConfiguration<>();
			allEmployesCacheConfiguration.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(Duration.TEN_MINUTES));
			cm.createCache("allEmployesCache", allEmployesCacheConfiguration);
			//TODO : Add additional configuration
			
			// Creating a Cache Name
			
			MutableConfiguration<Object, Object> userCache = new MutableConfiguration<>();
			userCache.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS,1)));
			cm.createCache("userCache", userCache);
			//TODO : Add additional configuration
			
			
			
		};
		
	}

}
