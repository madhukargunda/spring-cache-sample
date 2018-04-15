package com.study.pattern.config;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerCheck implements CommandLineRunner {	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	CacheManager cacheManager;
	
	@Autowired
	public CacheManagerCheck(CacheManager cacheManager){
		this.cacheManager = cacheManager;
	}

	@Override
	public void run(String... args) throws Exception {
		getCacheLogAndStatistics();		
	}
	
	private void getCacheLogAndStatistics()
	{
		logger.info("\n\n\n "+"=============================================================================================================================");		
		logger.info("The Name of the Cache Manager is --> "+this.cacheManager.getClass().getName());	
		logger.info("\n\n\n "+"=============================================================================================================================");	

		Collection<String> cacheNames = cacheManager.getCacheNames();
		logger.info("The Size of the Cache is =========="+cacheNames.size());	
		
		cacheNames.stream().forEach(cacheName -> {
			Cache cache = cacheManager.getCache(cacheName);
			logger.info("The Cache class type   {} ",cache.getClass().getName());
			Object nativeCache = cache.getNativeCache();
			logger.debug("The Cache Provider  Name is   : "+nativeCache.getClass());			
			if(nativeCache instanceof org.springframework.cache.Cache){
				org.springframework.cache.Cache scache =  (org.springframework.cache.Cache) cache.getNativeCache();
				logger.debug("The Default Cache is Spring Cache ");
			}	
		});
	}
}
