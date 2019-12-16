package com.spring.database.springdatabase.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.database.springdatabase.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person p = findById(id);
		entityManager.remove(p);
	}
	
	public List<Person> findAll() {
		 TypedQuery<Person> namedQuery = entityManager.createNamedQuery("findAll", Person.class);
		 return namedQuery.getResultList();
	}
}