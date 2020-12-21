package com.spring.database.springdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.database.springdatabase.entity.Person;

public interface PersonSpringDataRepository extends
							JpaRepository<Person, Integer>{

	Person findBytwitterUserName(String username);
}
