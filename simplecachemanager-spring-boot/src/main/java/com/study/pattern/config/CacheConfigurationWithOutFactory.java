package com.study.pattern.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfigurationWithOutFactory {

   @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
          new ConcurrentMapCache("allEmployesCache"), 
          new ConcurrentMapCache("userCache")));
        return cacheManager;
   }
}
