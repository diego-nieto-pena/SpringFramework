package com.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.microservices.currencyexchangeservice.exception.EntityNotFoundException;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeJpaRepository;

@RestController
public class CurrencyExchangeController {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired 
	private Environment environment;
	
	@Autowired 
	CurrencyExchangeJpaRepository repository;
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws EntityNotFoundException {
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		
		if(exchangeValue == null) {
			throw new EntityNotFoundException("Entity not found from - to " + from + " - "+ to);
		}
		
		logger.info("{}", exchangeValue);
		
		exchangeValue.setPort(port);
		return exchangeValue;
	}
}
