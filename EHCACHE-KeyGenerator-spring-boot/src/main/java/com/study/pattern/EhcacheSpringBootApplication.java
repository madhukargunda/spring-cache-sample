package com.study.pattern;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.study.pattern.repository.EmployeRepository;

import net.sf.ehcache.Element;

@SpringBootApplication
@EnableCaching
public class EhcacheSpringBootApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass());	

	public static void main(String[] args) {
	 ConfigurableApplicationContext run = SpringApplication.run(EhcacheSpringBootApplication.class, args);
	 EmployeRepository employeRepo = run.getBean(EmployeRepository.class);
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.fetchAllEmployes());
	 logger.info("===============================================================================");
	 
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.fetchAllEmployes());
	 logger.info("===============================================================================");
	 
	 
	 
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.getFirstEmploye());
	 logger.info("===============================================================================");
	 
	 logger.info("===============================================================================");
	 logger.info("Employes : {} " ,employeRepo.getFirstEmploye());
	 logger.info("==============================================================================="); 
	 
	 
	 logger.info("==============================[First time]=============================");
	 logger.info("Employes : {} " ,employeRepo.getEmployeByFirstNameAndLastName("Romin", "Irani"));
	 logger.info("===============================================================================");
	 
	 logger.info("=============================[end]============================");
	 logger.info("Employes : {} " ,employeRepo.getEmployeByFirstNameAndLastName("Romin", "Irani"));
	 logger.info("===============================================================================");
	 
	CacheManager cacheManager = run.getBean(CacheManager.class);

	logger.info("\n\n\n "
			+ "=============================================================================================================================");
	logger.info("The Name of the Cache Manager is --> " + cacheManager.getClass().getName());
	logger.info("\n\n\n "
			+ "=============================================================================================================================");

		
	Collection<String> cacheNames = cacheManager.getCacheNames();
	for (String name : cacheNames) {
		Cache cache = cacheManager.getCache(name);
		logger.info("Cache Class Type : {}  " , cache.getNativeCache().getClass().getName());
		net.sf.ehcache.Cache ehcache = (net.sf.ehcache.Cache)cache.getNativeCache();
		List keys = ehcache.getKeys();
		for (Object object : keys) {
			Element element = ehcache.get(object);
			logger.info("Key : {} , Value : {} ",object,element.toString());
		}
	}
	
	
	
	
	
	}
}
