package com.progra3.petstore.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;

@RestController
@RequestMapping("/mascotas")
public class PetController {
	
	@Autowired
	PetService service;
	
	@GetMapping
	public List<Pet> findAll(){
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	public Pet findPet(@PathVariable long id) {
		return service.findById(id);
	}
	
	//Validacion en creacion
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Pet createPet(@Valid @RequestBody Pet pet) {
		return service.createPet(pet);
	}
	
	//Validacion en actualizar
	@PutMapping("/{id}")
	public Pet updatePet(@PathVariable long id, @Valid @RequestBody Pet pet) {
		return service.updatePet(id, pet);
	}
	
	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable long id) {
		service.deletePet(id);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
}
