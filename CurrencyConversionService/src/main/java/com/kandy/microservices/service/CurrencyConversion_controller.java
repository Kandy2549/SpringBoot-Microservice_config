package com.kandy.microservices.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kandy.microservices.bean.CurrencyConversionBean;
import com.kandy.microservices.figien.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversion_controller {

	@Autowired
	private CurrencyExchangeServiceProxy figenProxy;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}") //where {from} and {to} represents the column   
	//return a bean back  
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)  
	{  
		
		//setting variables to currency exchange service  
		Map<String, String>uriVariables=new HashMap<>();  
		uriVariables.put("from", from);  
		uriVariables.put("to", to);  
		
		//calling the currency-exchange-service  
		ResponseEntity<CurrencyConversionBean>responseEntity=new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);  
		CurrencyConversionBean response=responseEntity.getBody();  
		
		//creating a new response bean and getting the response back and taking it into Bean  
		return new CurrencyConversionBean(response.getId(), from,to,response.getConversionMultiple(), quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	
	}  
	
	
	
	
	@GetMapping("/currency-converter-figen/from/{from}/to/{to}/quantity/{quantity}") //where {from} and {to} represents the column   
	//return a bean back  
	public CurrencyConversionBean convertCurrencyByFigenProxy(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)  
	{  
		System.out.println("Inside Controller");
		CurrencyConversionBean response=figenProxy.retrieveExchangeValue(from, to);
		//creating a new response bean
		//getting the response back and taking it into Bean
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

	}  
	
	
}
