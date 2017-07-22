package com.examples.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IgniteBootClientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IgniteBootClientApplication.class, args);
	}

	public void run(String... strings) throws Exception {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setPeerClassLoadingEnabled(true);
		cfg.setIgniteInstanceName("grid_2");
		Ignition.setClientMode(true);
		Ignite ignite = Ignition.start(cfg);
		IgniteCache<String, String> cache = ignite.getOrCreateCache(new CacheConfiguration<String, String>()
				.setName("test-cache").setCacheLoaderFactory(new CustomCacheLoaderFactory()).setReadThrough(true));
		System.out.println(cache.get("Bbb"));
	}
}
