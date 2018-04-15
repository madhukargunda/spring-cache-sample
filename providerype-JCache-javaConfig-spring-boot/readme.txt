Version 1 :

Usecase :

Having common configuration for all CacheProvider Vendors for JSR 107 using spring boot.


Description

1.JCache exposes a Configuration and MutableConfiguration classes that we can use to configure some settings for cache .
2.When we are using Spring boot , it creates automatically CacheManager and we can auto wire where ever we need .
3.Jcache API provides a mechanism to identify the CacheProvider and Creates the Cache.
4.In this Example we can replace the Jcache Providers without changing the code.