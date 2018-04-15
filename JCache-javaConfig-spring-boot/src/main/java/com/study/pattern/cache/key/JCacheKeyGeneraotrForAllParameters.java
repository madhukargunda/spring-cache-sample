package com.study.pattern.cache.key;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandles;

import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JCacheKeyGeneraotrForAllParameters implements CacheKeyGenerator {
	
	private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());	
	
	private static String CACHE_KEY="allEmployes";

	@Override
	public GeneratedCacheKey generateCacheKey(CacheKeyInvocationContext<? extends Annotation> arg0) {
		logger.info("The Name of the Cache is : {}  ",arg0.getMethod().getName());
		CacheInvocationParameter[] keyParameters = arg0.getKeyParameters();
		for (CacheInvocationParameter cacheInvocationParameter : keyParameters) {
			logger.info("TThe Parameter Key is  {}",cacheInvocationParameter.getValue());
		}
		
		if(arg0.getMethod().getName().equals("fetchAllEmployes")){
			return new AllEmployesCacheKey(CACHE_KEY);
		}
		
		return null;
	}

}
