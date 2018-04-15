package com.study.pattern.cache.key;

import java.lang.annotation.Annotation;

import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.CacheKeyGenerator;
import javax.cache.annotation.CacheKeyInvocationContext;
import javax.cache.annotation.GeneratedCacheKey;

public class DefaultCacheKeyGenerator implements CacheKeyGenerator {

	@Override
	public GeneratedCacheKey generateCacheKey(
			CacheKeyInvocationContext<? extends Annotation> cacheKeyInvocationContext) {
		
		CacheInvocationParameter[] keyParameters = cacheKeyInvocationContext.getKeyParameters();
		StringBuilder builder  = new StringBuilder();
		for (CacheInvocationParameter cacheInvocationParameter : keyParameters) {
			builder.append(cacheInvocationParameter.getValue());
		}
		
		return null;
	}

}


