package com.kandy.microservices.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.kandy.microservices.bean.ExchangeValue;
import com.kandy.microservices.repositry.ExchangeValueRepositry;



@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepositry exchangeValueRepo;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 
	

	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		//taking the exchange value  
		ExchangeValue exchangeValue= exchangeValueRepo.findByFromAndTo(from,to);  
		logger.info("{}"+exchangeValue);
		//picking port from the environment  
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));  
		return exchangeValue;  
	}
}
