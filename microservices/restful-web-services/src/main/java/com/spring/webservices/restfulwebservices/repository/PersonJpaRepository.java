package com.spring.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.webservices.restfulwebservices.bean.Person;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Integer>{

}
