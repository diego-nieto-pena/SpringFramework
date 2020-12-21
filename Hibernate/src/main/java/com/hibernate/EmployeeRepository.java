package com.hibernate;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate2.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository { //DAO --> repository

	@Autowired
	EntityManager manager;
	
	public void insert(Employee e) {
		manager.persist(e);
	}
	
	public List<Employee> findAll() {
		return manager
				.createQuery("select e from Employee e", Employee.class)
				.getResultList();
	}
	
}
