package com.study.pattern.cache.key.generator;

import java.lang.annotation.Annotation;

import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;

import org.springframework.stereotype.Component;

import com.study.pattern.cache.key.DefaultStringGeneratedCacheKey;

@Component
public class MethodNameCacheKeyGenerator implements CacheKeyGenerator {

	@Override
	public GeneratedCacheKey generateCacheKey(
			CacheKeyInvocationContext<? extends Annotation> cacheKeyInvocationContext) {
		return new DefaultStringGeneratedCacheKey(cacheKeyInvocationContext.getMethod().getName());
	}
}
