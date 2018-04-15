package com.study.pattern.config;

import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
		logger.info("The Name of the Cache Manager is From CacheManager Class --> "+this.cacheManager.getClass().getName());	
		logger.info("\n\n\n "+"=============================================================================================================================");	

		Iterable<String> cacheNames = cacheManager.getCacheNames();
		for (String cacheName : cacheNames) {
			logger.info("The CacheNames are {} ",cacheName);				
			Cache<Object, Object> cache = cacheManager.getCache(cacheName);
		    Iterator<Entry<Object, Object>> allCacheEntries= cache.iterator();
		    while(allCacheEntries.hasNext()){
		        Entry<Object, Object> currentEntry = allCacheEntries.next();
		        logger.info("Key:  {}  Value {} ",currentEntry.getKey(), currentEntry.getValue());
		    }
		}		
	}
	
}
