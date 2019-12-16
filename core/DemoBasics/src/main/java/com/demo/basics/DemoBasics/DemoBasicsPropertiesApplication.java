package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.demo.basics.props.PropertiesService;

@Configuration
@ComponentScan("com.demo.basics.props")
@PropertySource("classpath:application.properties")
public class DemoBasicsPropertiesApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoBasicsPropertiesApplication.class);
	public static void main(String[] args) {
		
		try(ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(DemoBasicsPropertiesApplication.class)) {
			PropertiesService  service = appContext.getBean(PropertiesService.class);
			
			logger.info("{}", service.returnServiceUrl());
		}
	}
}
