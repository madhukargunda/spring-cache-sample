package com.study.pattern.cache.key;

import java.util.Arrays;

import javax.cache.annotation.GeneratedCacheKey;

public class MethodArgumentGeneratedCacheKey implements GeneratedCacheKey {

	private static final long serialVersionUID = 1L;

	  private final Object[] parameters;
	  private final int hashCode;

	  /**
	   * Constructs a default cache key
	   *
	   * @param parameters the paramters to use
	   */
	  public MethodArgumentGeneratedCacheKey(Object[] parameters) {
	    this.parameters = parameters;
	    this.hashCode = Arrays.deepHashCode(parameters);
	  }

	  @Override
	  public int hashCode() {
	    return this.hashCode;
	  }

	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    if (this.hashCode != obj.hashCode())
	      return false;
	    MethodArgumentGeneratedCacheKey other = (MethodArgumentGeneratedCacheKey) obj;
	    return Arrays.deepEquals(this.parameters, other.parameters);
	  }
}
