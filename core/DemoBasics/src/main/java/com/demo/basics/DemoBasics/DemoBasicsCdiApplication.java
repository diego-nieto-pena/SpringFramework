package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.basics.DemoBasics.cdi.SomeCdiBusiness;

@Configuration
@ComponentScan
public class DemoBasicsCdiApplication {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(DemoBasicsCdiApplication.class);
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DemoBasicsCdiApplication.class);
		SomeCdiBusiness business = appContext.getBean(SomeCdiBusiness.class);
		
		logger.info("{} -dao {}", business, business.getSomeCdiDao());
	}
}