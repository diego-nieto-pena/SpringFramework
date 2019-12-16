package com.spring.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.webservices.restfulwebservices.bean.Person;
import com.spring.webservices.restfulwebservices.exception.PersonNotFoundException;
import com.spring.webservices.restfulwebservices.service.PersonDaoService;


@RestController
public class PersonController {
	@Autowired
	PersonDaoService service;
	
	@GetMapping(path="/people")
	public List<Person> getPeople() {
		return service.findAll();
	}
	
	@GetMapping("/people/{id}")
	public Resource<Person> getPersonWithName(@PathVariable Integer id) {
		Person person = service.findById(id);
		if(person == null) {
			throw new PersonNotFoundException("ID : " + id);
		}
		
		Resource<Person> resource = new Resource<Person>(person);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getPeople());
		
		resource.add(linkTo.withRel("all-people"));
				
		return resource;
	}
	
	@PostMapping("/people")
	public ResponseEntity<Object> savePerson(@Valid @RequestBody Person person) {
		Person savedPerson = service.save(person);
		
		URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}").
		buildAndExpand(savedPerson.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/people/{id}")
	public void deletePerson(@PathVariable Integer id) {
		Person person = service.deleteById(id);

		if(person == null) {
			throw new PersonNotFoundException("ID : " + id);
		}
	}
}
