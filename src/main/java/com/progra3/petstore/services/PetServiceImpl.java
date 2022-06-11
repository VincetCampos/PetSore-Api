package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progra3.petstore.DAO.PetDao;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.exceptions.NotFoundException;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	PetDao petDao;
	
	@Override
	public List<Pet> listAll() {
		return (List<Pet>) petDao.findAll();
	}

	@Override
	public Pet findById(long id) {
		Optional<Pet> optionalPet = petDao.findById(id);
		
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}else {
			throw new NotFoundException("No se encontro a la mascota");
		}
		
	}

	@Override
	public Pet createPet(Pet pet) {
		return petDao.save(pet);
	}

	@Override
	public Pet updatePet(long id, Pet pet) {
		if(petDao.existsById(id)) {
			pet.setId(id);
			return petDao.save(pet);
			
		}else {
			throw new NotFoundException("No se encontro a la mascota");
		}
	}

	@Override
	public void deletePet(long id) {
		
		if(petDao.existsById(id)) {
			petDao.deleteById(id);
		}else {
			throw new NotFoundException("No se encontro a la mascota");
		}
		
	}

}
