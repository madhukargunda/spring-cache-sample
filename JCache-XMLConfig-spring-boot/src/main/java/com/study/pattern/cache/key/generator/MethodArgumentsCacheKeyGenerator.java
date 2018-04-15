package com.study.pattern.cache.key.generator;

import java.lang.annotation.Annotation;

import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;

import org.springframework.stereotype.Component;

import com.study.pattern.cache.key.MethodArgumentGeneratedCacheKey;

@Component
public class MethodArgumentsCacheKeyGenerator implements CacheKeyGenerator {

	@Override
	public GeneratedCacheKey generateCacheKey(
			CacheKeyInvocationContext<? extends Annotation> cacheKeyInvocationContext) {
		CacheInvocationParameter[] keyParameters = cacheKeyInvocationContext.getAllParameters();
		final Object[] parameters = new Object[keyParameters.length];
		for (int i = 0; i < keyParameters.length; i++) {
				parameters[i] = keyParameters[i].getValue();
			}
		return new MethodArgumentGeneratedCacheKey(parameters);
	}

}
