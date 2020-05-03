package com.kandy.microservices.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "limit-service")
public class Configuration {

	
	private int maximum;  
	private int minimum;  
	
	
	public void setMaximum(int maximum)   
	{  
	this.maximum = maximum;  
	}  
	public void setMinimum(int minimum)   
	{  
	this.minimum = minimum;  
	}  
	public int getMaximum()   
	{  
	return maximum;  
	}  
	public int getMinimum()   
	{  
	return minimum;  
	}  
	
	
}
