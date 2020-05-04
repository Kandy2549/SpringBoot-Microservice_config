package com.kandy.microservices.figien;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kandy.microservices.bean.CurrencyConversionBean;

@FeignClient(name="netflix-zuul-api-server")  
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	/*
	 *  Changed @GetMapping url from /currency-exchange/from/{from}/to/{to} to
	 * /currency-exchange-service/currency-exchange/from/{from}/to/{to} due to
	 * implementation of zuul api
	 * 
	 */	
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")		
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
