package com.spring.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.webservices.restfulwebservices.bean.Person;
import com.spring.webservices.restfulwebservices.bean.Post;
import com.spring.webservices.restfulwebservices.exception.PersonNotFoundException;
import com.spring.webservices.restfulwebservices.repository.PersonJpaRepository;
import com.spring.webservices.restfulwebservices.repository.PostJpaRepository;

@RestController
public class PersonJpaController {
	
	@Autowired
	PersonJpaRepository repository;
	
	@Autowired
	PostJpaRepository postRepository;

	@GetMapping(path="/jpa/people")
	public List<Person> getPeople(){
		return repository.findAll();
	}
	
	@GetMapping(path="/jpa/people/{id}")
	public Person getPersonById(@PathVariable Integer id) {
		Optional<Person> personOpt = repository.findById(id);
		
		if(!personOpt.isPresent()) {
			throw new PersonNotFoundException("Person not found id: " + id);
		}
		
		return personOpt.get();
	}
	
	@GetMapping(path="/jpa/people/{id}/post")
	public List<Post> getPersonPost(@PathVariable int id) {
		Optional<Person> personOpt = repository.findById(id);
		
		if(!personOpt.isPresent()) {
			throw new PersonNotFoundException("Person Not Found id: " + id);
		}
		
		return personOpt.get().getPost();
	}
	
	@PostMapping(path="/jpa/people/{id}/post")
	public Resource<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		
		Optional<Person> personOpt = repository.findById(id);
		
		if(!personOpt.isPresent()) {
			throw new PersonNotFoundException("Person not found id: " + id);
		}
		
		post.setPerson(personOpt.get());
		
		Post createdPost = postRepository.save(post);
		
		
		Resource<Post> resource = new Resource<Post>(createdPost);
				
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getPersonPost(id));
		
		resource.add(linkTo.withRel("person-post"));
		
		return resource;
	}
}
