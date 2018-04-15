package com.study.pattern.cache.key;

import java.util.Objects;

import javax.cache.annotation.GeneratedCacheKey;

public class DefaultStringGeneratedCacheKey implements GeneratedCacheKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cacheKey;

	public DefaultStringGeneratedCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cacheKey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DefaultStringGeneratedCacheKey that = (DefaultStringGeneratedCacheKey) o;
        return Objects.equals(this.cacheKey, that.cacheKey);
    }
}
