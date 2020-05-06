package com.kandy.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	
	/*
	 * Bean for Spring Cloud Sleuth provides a Sampler strategy. With the help of
	 * Sampler, we can implement the sampling algorithm that provides control of the
	 * algorithm. By default, we get a procedure that continuously performs the
	 * tracing if a span (correlation: is an individual operation) is already
	 * active.
	 */
	@Bean  
	public Sampler defaultSampler()  
	{  
	   return Sampler.ALWAYS_SAMPLE;  
	}  

}
