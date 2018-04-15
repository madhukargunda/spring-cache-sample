Usecase 

How to switch different cache provider using spring boot

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
	
 5.In this example we are changing the cache provider by updating the cacheType property in properties file
 
   spring.cache.type=hazelcast	

 6.Through CommandLine arguments also we can change the proider type
 
   --spring.cache.type=infinispan  or -Dspring.cache.type=infinispan
 
 