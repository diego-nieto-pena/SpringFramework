package com.spring.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.webservices.restfulwebservices.bean.Person;

@Component
public class PersonDaoService {

private static List<Person> persons = new ArrayList<>();
	
	private static int personCounter = 3; 
	
	static  {
		persons.add(new Person(1, "John", "123", new Date()));
		persons.add(new Person(2, "Eve", "street 123", new Date()));
		persons.add(new Person(3, "Adam","street cx3", new Date()));
	}
	
	public List<Person> findAll() {
		return persons;
	}
	
	public Person findById(int id) {
		for(Person person: persons) {
			if(person.getId() == id) {
				return person;
			}
		}
		return null;
	}
	
	public Person save(Person person) {
		if(person.getId()==null) {
			person.setId(++personCounter);
		}
		persons.add(person);
		return person;
	}
	
	
	public Person deleteById(int id) {
		Iterator<Person> iterator = persons.iterator();
		
		while(iterator.hasNext()) {
			Person person = iterator.next();
			iterator.remove();
			if(person.getId() == id) {
				return person;
			}
		}
		
		return null;
	}
}
