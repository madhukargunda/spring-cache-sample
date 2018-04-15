package com.study.pattern.aspect;

import java.lang.invoke.MethodHandles;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TimingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Before("@annotation(com.study.pattern.annotation.Time)")
	public void invokeThisAdviceForTimeAnnotation(){
		logger.debug("invokeThisAdviceForTimeAnnotation ");	
	}
	
	//@Before("within(com.study.pattern.service..*)")
	public void invokeThisAdviceForaAllAnnotation(){
		logger.debug("invokeThisAdviceForTimeAnnotation ");	
	}

}
