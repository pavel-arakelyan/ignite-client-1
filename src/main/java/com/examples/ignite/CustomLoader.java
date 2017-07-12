package com.examples.ignite;

import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;
import java.io.Serializable;
import java.util.Map;

/**
 * @author pavel.arakelyan on 7/10/17.
 */
public class CustomLoader implements CacheLoader<String, String>, Serializable{

	public String load(String s) throws CacheLoaderException {
		return "as";
	}

	public Map<String, String> loadAll(Iterable<? extends String> iterable) throws CacheLoaderException {
		throw new UnsupportedOperationException("asdasdasdasd");
	}
}
