package com.study.pattern;

import java.lang.invoke.MethodHandles;
import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.CacheManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.study.pattern.repository.EmployeRepository;

@SpringBootApplication
@EnableCaching
public class JCacheJavaConfigSpringBootApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass());	

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JCacheJavaConfigSpringBootApplication.class, args);
		EmployeRepository employeRepo = run.getBean(EmployeRepository.class);
		logger.info("===============================================================================");
		logger.info("Employes : {} ", employeRepo.fetchAllEmployes());
		logger.info("===============================================================================");

		logger.info("===============================================================================");
		logger.info("Employes : {} ", employeRepo.fetchAllEmployes());
		logger.info("===============================================================================");

		CacheManager cacheManager = run.getBean(CacheManager.class);

		logger.info("\n\n\n "
				+ "=============================================================================================================================");
		logger.info("The Name of the Cache Manager is --> " + cacheManager.getClass().getName());
		logger.info("\n\n\n "
				+ "=============================================================================================================================");

		Iterable<String> cacheNames = cacheManager.getCacheNames();
		for (String cacheName : cacheNames) {
			logger.info("The CacheNames are {} ", cacheName);
			Cache<Object, Object> cache = cacheManager.getCache(cacheName);
			Iterator<Entry<Object, Object>> allCacheEntries = cache.iterator();
			while (allCacheEntries.hasNext()) {
				Entry<Object, Object> currentEntry = allCacheEntries.next();
				logger.info("Key:  {}  Value {} ", currentEntry.getKey(), currentEntry.getValue());
			}
		}
	}	
}
