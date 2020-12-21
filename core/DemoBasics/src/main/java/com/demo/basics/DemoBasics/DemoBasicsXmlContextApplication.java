package com.demo.basics.DemoBasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.basics.DemoBasics.xml.XmlPersonDAO;

public class DemoBasicsXmlContextApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoBasicsXmlContextApplication.class);
	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			XmlPersonDAO  person = appContext.getBean(XmlPersonDAO.class);
			
			System.out.println(person);
			System.out.println(person.getXmlJdbcConnection());
			//logger.info("Loeaded Beans -> {}", (Object) appContext.getBeanDefinitionNames());
			
		}
	}
}
