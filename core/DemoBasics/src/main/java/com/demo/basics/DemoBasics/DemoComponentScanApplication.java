package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demo.basics.DemoBasics.scope.PersonDAO;
import com.demo.basics.componentscan.ComponentDAO;

@SpringBootApplication
@ComponentScan("com.demo.basics")
public class DemoComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(DemoComponentScanApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext = SpringApplication.run(DemoComponentScanApplication.class, args);
		ComponentDAO  componentDAO = appContext.getBean(ComponentDAO.class);
		PersonDAO personDAO = appContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", componentDAO);
		LOGGER.info("{}", personDAO);
	}
}
