package com.spring.database.springdatabase.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.database.springdatabase.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?",
				new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM person WHERE id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date)"
				+ " values (?, ?, ?, ?)", 
				new Object[] {person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update(" update person set name=?, location=?, birth_date=? where id=?", 
				new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
}