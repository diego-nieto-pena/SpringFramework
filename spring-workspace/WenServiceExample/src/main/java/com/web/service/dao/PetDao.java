package com.web.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.service.entity.Pet;

@Repository
public interface PetDao extends JpaRepository<Pet, Long> {
	// CRUD
}