package com.progra3.petstore.DAO;

import org.springframework.data.repository.CrudRepository;

import com.progra3.petstore.entities.Pet;

public interface PetDao extends CrudRepository<Pet, Long>{

}
