package com.study.pattern.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

public class CacheConfigurationwithFactory {
	

	
	public SimpleCacheManager cacheManager(){
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<Cache>();
		caches.add(cacheBean().getObject());
		cacheManager.setCaches(caches );
		return cacheManager;
	}
	
	
	public ConcurrentMapCacheFactoryBean cacheBean(){
		ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		cacheFactoryBean.setName("default");
		return cacheFactoryBean;
	}
	

}
