package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate2.entity.Course;

@Transactional
@Repository
//@ComponentScan("com.hibernate2.entity")
public class CourseDao {

	//CRUD -> D.A.O
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void createUpdate(Course c) {
		entityManager.merge(c);//create / update
	}
	
	public void delete(Course c) {
		entityManager.detach(c);
	}
}
