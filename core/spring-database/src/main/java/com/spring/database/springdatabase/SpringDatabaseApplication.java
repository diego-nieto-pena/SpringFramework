package com.spring.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.springdatabase.beans.DataBaseConnection;
import com.spring.database.springdatabase.dao.PersonJdbcDao;
import com.spring.database.springdatabase.entity.Person;

@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao; 
	
	@Autowired
	@Qualifier("mysql")
	private DataBaseConnection dataBaseConnection;
	
	@Autowired
	@Qualifier("mysql")
	private DataBaseConnection dataBaseConnection2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("Bean1: " + dataBaseConnection);
		System.out.println("Bean1 - jdbc: " + dataBaseConnection.getJdbcConnection());
		
		
		System.out.println("Bean2: " + dataBaseConnection2);
		System.out.println("Bean2 - jdbc: " + dataBaseConnection2.getJdbcConnection());*/
		logger.info("All Users -> {}", personJdbcDao.findAll());
		logger.info("User with id 10001 -> {}", personJdbcDao.findById(10001));
		logger.info("Delete user with id 10003 rows affected {}", personJdbcDao.deleteById(10003));
		
		logger.info("Insert new user RA {}", personJdbcDao.insert(new Person(10004, "Diego", "Berlin", new Date())));
		logger.info("Update person RA {}", personJdbcDao.update(new Person(10001, "Fernando", "Paris", new Date())));
	}
}
