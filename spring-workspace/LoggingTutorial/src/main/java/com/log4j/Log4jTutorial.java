package com.log4j;

import org.apache.log4j.Logger;

public class Log4jTutorial {

	private static final Logger logger = Logger.getLogger(Log4jTutorial.class);
	
	
	public static void main(String[] args) {
		
		try {
			int c = 0;
			int b = 1;
			int d = 1/0;
		} catch(Exception e) {
			logger.error("Error at math operation: " + e.getMessage());
		}
		
		
		System.out.println("Hola :)");
		logger.info("INFo Tutorial Log4j");
		logger.error("ERROR Tutorial Log4j");
		logger.warn("WARn Tutorial Log4j");
	}

}
