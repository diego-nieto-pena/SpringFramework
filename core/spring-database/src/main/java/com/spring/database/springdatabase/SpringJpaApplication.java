package com.spring.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.springdatabase.entity.Person;
import com.spring.database.springdatabase.repository.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*logger.info("User 10001 -> {}", repository.findById(10001));
		
		logger.info("Insert new user 10004 -> {}", repository.insert(new Person("Jhon", "Tokio", new Date())));
		
		logger.info("Update user 10002 -> {}", repository.insert(new Person(10002, "Chris", "Tampa", new Date())));
		
		repository.deleteById(10001);
		
		logger.info("Persons {}", repository.findAll());*/
	}
}
