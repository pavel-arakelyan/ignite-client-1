package com.examples.ignite;

import com.hazelcast.cache.HazelcastCachingProvider;
import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.cache.impl.HazelcastClientCachingProvider;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.CacheConfig;
import com.hazelcast.config.CacheConfiguration;
import com.hazelcast.config.UserCodeDeploymentConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;

@SpringBootApplication
//@ImportResource("classpath:application-config.xml")
public class IgniteBootClientApplication implements CommandLineRunner{
//
//	@Autowired
//	CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(IgniteBootClientApplication.class, args);
	}

	public void run(String... strings) throws Exception {
//		IgniteConfiguration cfg = new IgniteConfiguration();
//		cfg.setPeerClassLoadingEnabled(true);
//		Ignition.setClientMode(true);
//		Ignite ignite = Ignition.start(cfg);
//		IgniteCache<String, String> cache = ignite.getOrCreateCache(new CacheConfiguration<String, String>()
//				.setName("test-cache").setCacheLoaderFactory(new CustomCacheLoaderFactory()).setReadThrough(true));
//		System.out.println(cache.get("Aasd"));
		ClientConfig clientConfig = new ClientConfig();
//		clientConfig.setClassLoader(getClass().getClassLoader());
		HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
//		UserCodeDeploymentConfig distCLConfig = client.getConfig().getUserCodeDeploymentConfig();
//		distCLConfig.setEnabled( true )
//				.setClassCacheMode( UserCodeDeploymentConfig.ClassCacheMode.ETERNAL )
//				.setProviderMode( UserCodeDeploymentConfig.ProviderMode.LOCAL_CLASSES_ONLY )
//				.setBlacklistedPrefixes( "com.foo" )
//				.setProviderFilter( "HAS_ATTRIBUTE:lite" );
		CacheManager cacheManager  = HazelcastClientCachingProvider.createCachingProvider(client).getCacheManager();
//		CacheManager cacheManager = Caching.getCachingProvider().getCacheManager(Caching.getCachingProvider().getDefaultURI(), Caching.getCachingProvider().getDefaultClassLoader());
		Cache<String,String> cache = cacheManager.createCache("aaa", new CacheConfig<String, String>()
			.setCacheLoaderFactory(new CustomCacheLoaderFactory()).setReadThrough(true));
		System.out.println(cache.get("Aasd"));

	}
}
