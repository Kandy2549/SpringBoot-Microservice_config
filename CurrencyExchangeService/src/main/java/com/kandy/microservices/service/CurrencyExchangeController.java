package com.kandy.microservices.service;

import java.math.BigDecimal;

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
	

	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		//taking the exchange value  
		ExchangeValue exchangeValue= exchangeValueRepo.findByFromAndTo(from,to);  
		
		//picking port from the environment  
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));  
		return exchangeValue;  
	}
}
