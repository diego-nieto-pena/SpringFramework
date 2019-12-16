package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.basics.DemoBasics.algo.BinarySearchImpl;

@Configuration
@ComponentScan
public class DemoBasicsApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoBasicsApplication.class);
	public static void main(String[] args) {
		
		int[] arr = {1,5,8,9,11,22,44,13,78,91,2};
		int number = 13;
		
		try(ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(DemoBasicsApplication.class)) {
			BinarySearchImpl  binary = appContext.getBean(BinarySearchImpl.class);
			BinarySearchImpl  binary2 = appContext.getBean(BinarySearchImpl.class);
			
			logger.info("{}", binary);
			logger.info("{}", binary2);
			
			int index = binary.searchNumber(arr, number);
			
			logger.info("Number found at: " + index);
		}
	}
}
