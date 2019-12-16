package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.basics.DemoBasics.scope.PersonDAO;

@SpringBootApplication
public class DemoBasicsScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(DemoBasicsScopeApplication.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext = SpringApplication.run(DemoBasicsScopeApplication.class, args);
		PersonDAO  person1 = appContext.getBean(PersonDAO.class);
		PersonDAO  person2 = appContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", person1);
		LOGGER.info("{}", person1.getJdbcConnection());
		LOGGER.info("{}", person2);
		LOGGER.info("{}", person2.getJdbcConnection());
	}
}
