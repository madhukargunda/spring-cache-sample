
What is CacheHit / CacheFut
How to display Cache Attributes

Usecase :

1.This Example Uses the Spring Boot and Ehcache as the direct Provider which uses the Spring KeyGenerator to Generate the Cache Keys.
2.Spring boot try to scans the classpath and identifies the provider if ehcache.xml 
         or 
     specify the ehcache.xml file path in application.properties file
3.If we didn't specify above spring boot uses the org.springframework.cache.concurrent.ConcurrentMapCacheManager as the CacheManager.







Version 1 :

Switch the cache library with out touching the code ,For this we need common interface that build  by Spring framework.
There are few Cache Libraries alreadY exist , For these Spring provides a adapters for common interface.


  1.Prior to spring boot 1.3.0 developer has to add the manually cache configuration based on the provider.
    With Spring Boot 1.3.0, the last step of adding the bean definitions also bean eliminated. 

  2.Spring uses the ConcurrentMapCacheManager as the default Implementation if developer  does not provides any provider

     a.SimpleCacheManager 
     b.ConcurrentMapCacheManager 
    
       which uses the JDK ConcurrentMap ,This is Spring default caching
    
    	Generic
		EhCache 2.x
		Hazelcast
		Infinispan
		JCache (JSR-107)
		Redis
		Guava
		Simple
   

  3.The Spring Boot starter provides a simple cache provider which stores values in an instance of ConcurrentHashMap. 
    This is the simplest possible thread-safe implementation of the caching mechanism.
    
  4.Spring framework introduced caching abstraction with org.springframework.cache.CacheManager as the Central interface. 
    This interface has few built-in implementations, including:

	1.ConcurrentMapCacheManager
	2.EhCacheCacheManager
	3.NoOpCacheManager
	4.SimpleCacheManager
	5.GemFireCacheManager
	
	
  3.EhCacheCaheManager is the adapter for Spring and EhCache  Implementation and developer needs to have a ehcache provider in classpath.
  	
  
  
  a.Don't provide any provider it will instantiate the ConcurrentHashMqp based on org.springframework.cache.concurrent.ConcurrentMapCacheManager
  
  
  b.Add ehcache provider in classpath (ehcache dependency in pom ,spring checks for ehcache.xml file or file location in properties
    if not found 