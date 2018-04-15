package com.study.pattern.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.study.pattern.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public LoggingAspect getLoggingAspect(){
		return new LoggingAspect();
		
	}

}
