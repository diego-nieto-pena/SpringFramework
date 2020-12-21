package com.hibernate2.entity;

import javax.persistence.Entity;

//TAREAS DE LAURA: l4j, inheritance y bigdecimal


@Entity
public class FullTimeEmployee extends Employee {

	private long salary;
	
	public FullTimeEmployee() {
		
	}
	
	public FullTimeEmployee(String name, long salary) {
		super(name);
		this.salary = salary;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + "]";
	}
}
