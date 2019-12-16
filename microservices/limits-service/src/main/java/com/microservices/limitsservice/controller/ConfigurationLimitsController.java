package com.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.ConfigurationLimits;
import com.microservices.limitsservice.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConfigurationLimitsController {

	@Autowired
	Configuration configuration;
	
	@GetMapping(path="/limits")
	public ConfigurationLimits getConfigurationLimits() {
		return new ConfigurationLimits(configuration.getMinimum(), configuration.getMaximum());
	}
	
	@GetMapping("/throw-exception")
	@HystrixCommand(fallbackMethod="fallBackRetrieveConfiguration")
	public ConfigurationLimits throwExceptionMethod() {
		throw new RuntimeException("Runtime Exception!");
	}
	
	public ConfigurationLimits fallBackRetrieveConfiguration() {
		return new ConfigurationLimits(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
}
