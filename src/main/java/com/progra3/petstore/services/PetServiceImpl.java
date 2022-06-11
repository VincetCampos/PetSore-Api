package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progra3.petstore.DAO.PetDao;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.exceptions.NotFoundExceptions;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	PetDao petDao;
	
	@Override
	public List<Pet> listAll() {
		return (List<Pet>) petDao.findAll();
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> optionalPet = petDao.findById(id);
		
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}else {
			throw new NotFoundExceptions("No se encontro a la mascota");
		}
		
	}

	@Override
	public Pet createPet(Pet pet) {
		return petDao.save(pet);
	}

	@Override
	public Pet updatePet(Long id, Pet pet) {
		if(petDao.existsById(id)) {
			pet.setId(id);
			return petDao.save(pet);
			
		}else {
			throw new NotFoundExceptions("No se encontro a la mascota");
		}
	}

	@Override
	public void deletePet(Long id) {
		
		if(petDao.existsById(id)) {
			petDao.deleteById(id);
		}else {
			throw new NotFoundExceptions("No se encontro a la mascota");
		}
		
	}

}
