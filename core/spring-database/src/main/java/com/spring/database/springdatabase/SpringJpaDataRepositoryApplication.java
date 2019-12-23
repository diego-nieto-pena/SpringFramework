package com.spring.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.springdatabase.entity.Person;
import com.spring.database.springdatabase.repository.PersonSpringDataRepository;

@SpringBootApplication
public class SpringJpaDataRepositoryApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDataRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User 10001 -> {}", repository.findById(10001));
		// SELECT * FROM PERSON WHERE id = 10001
		
		logger.info("Insert new user 10004 -> {}", repository.save(new Person("Jhon", "Tokio", new Date())));
		//INSERT INTO PERSON (id, name, location, birth_date) values (1, 'nico', 'tokio', 2019)
		
		logger.info("Update user 10002 -> {}", repository.save(new Person(10002, "Chris", "Tampa", new Date())));
		
		repository.deleteById(10001);
		
		logger.info("Persons {}", repository.findAll());
	}
}