package com.kandy.microservices.bean;

public class LimitConfiguration {

	
	private int maximum;  
	private int minimum;
	
	
	//TODO no-argument constructor  
	protected LimitConfiguration()  
	{  
	}  
	
	
	//TODO generating getters  
	public int getMaximum()   
	{  
	return maximum;  
	}  
	public int getMinimum()   
	{  
	return minimum;  
	}  
	
	
	//TODO genetrating constructor using fields  
	public LimitConfiguration(int maximum, int minimum)   
	{  
	super();  
	this.maximum = maximum;  
	this.minimum = minimum;  
	}  
	
	
}
