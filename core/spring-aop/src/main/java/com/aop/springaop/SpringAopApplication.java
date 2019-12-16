package com.aop.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aop.springaop.business.Business1;
import com.aop.springaop.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	Business1 business1;
	
	@Autowired
	Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}", business1.doSomeBusiness());
		/*try {
			business1.throwException();
		} catch(Exception e) {
			logger.error("{}", e);
		}*/
		
		logger.info("{}", business2.doSomeBusiness());
	}
}