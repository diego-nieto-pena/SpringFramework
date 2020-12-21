package com.web.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.dao.PetDao;
import com.web.service.entity.Pet;

@RestController
public class PetController {

	@Autowired //--> inyectando una dependencia
	private PetDao petDao; 
	
	@GetMapping(path="/find")
	public List<Pet> getAll() {
		return petDao.findAll();
	}
	
	@PostMapping(path="/create")
	public Pet create(@RequestBody Pet pet) {
		Pet newPet = petDao.save(pet);
		return newPet;
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable Long id) {
		petDao.deleteById(id);
	}
	
	@PutMapping(path="/update/{id}")
	public Pet update(@RequestBody Pet pet, @PathVariable Long id) throws Exception {
		
		Optional<Pet> petOptional = petDao.findById(id);
		
		Pet newPet = null;
		
		if(petOptional.isPresent()) {
			Pet oldPet = petOptional.get();	
			oldPet.setBreed(pet.getBreed());
			oldPet.setName(pet.getName());
			
			newPet = petDao.save(oldPet);
		} else {
			throw new Exception("PET NOT FOUND");
		}
		
		return newPet;
	}
}