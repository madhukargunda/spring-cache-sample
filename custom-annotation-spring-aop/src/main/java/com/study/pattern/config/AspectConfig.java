package com.study.pattern.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.study.pattern.aspect.TimingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public TimingAspect getTimingAspect(){
		return new TimingAspect();
	}

}
