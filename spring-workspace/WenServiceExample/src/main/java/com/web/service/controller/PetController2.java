package com.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.dao.PetDao;
import com.web.service.entity.Pet;

@RestController
public class PetController2 {
	@Autowired //--> inyectando una dependencia
	private PetDao petDao; 
	
}
