package com.study.pattern.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.pattern.bo.Employe;

@Configuration
public class CacheConfiguration {
	
	@Value("/employes/employes.json")
	private Resource employesJson;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Bean
	public List<Employe> getAllEmployesFromJson() throws Exception {	
		Employe[] allEmployes = objectMapper.readValue(employesJson.getInputStream(),Employe[].class);	
		return Collections.unmodifiableList(Arrays.asList(allEmployes));		
	}
	
	@Bean
    public Collection<Cache> cacheManager() {
      Collection<Cache> cacheList =  new ArrayList<>();
      ConcurrentMapCache c1= new ConcurrentMapCache("directory");
      ConcurrentMapCache c2=new ConcurrentMapCache("addresses");
      cacheList.add(c1);
      cacheList.add(c2);
      return cacheList;     
    }
	

}
