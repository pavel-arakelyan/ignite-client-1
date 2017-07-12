package com.examples.ignite;

import javax.cache.configuration.Factory;

/**
 * @author pavel.arakelyan
 */
public class CustomCacheLoaderFactory
		implements Factory<CustomLoader> {

	private static final long serialVersionUID = 7993486374740146730L;

	public CustomLoader create() {
		return new CustomLoader();
	}
}
