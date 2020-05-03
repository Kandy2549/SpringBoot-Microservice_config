package com.kandy.microservices.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandy.microservices.bean.ExchangeValue;

public interface ExchangeValueRepositry extends JpaRepository<ExchangeValue,Long>  {

	
	//creating query method  
	ExchangeValue findByFromAndTo(String from, String to);  
	
}
