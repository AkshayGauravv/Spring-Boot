package com.springboot.virtualnugetts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.virtualnugetts.caching.HazelCastCache;

@EnableEurekaClient
@EnableJpaRepositories
@SpringBootApplication
@EnableCaching
public class VirtualNuggetsDemo {

	public static void main(String[] args) {
		SpringApplication.run(VirtualNuggetsDemo.class, args);
		HazelCastCache hazel = new HazelCastCache();

		System.out.println("Cache is used Now..." + hazel.hazelCastConfig());
	}
}
