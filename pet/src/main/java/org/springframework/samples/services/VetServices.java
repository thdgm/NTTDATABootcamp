package org.springframework.samples.services;

import java.util.Collection;

import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

public interface VetServices {

	//Insert new Vet instance in DB
	void insertNewVet(Vet v);
	
	//Get Vet instance by ID
	Vet getVetById(Integer id);
	
	//Update Vet instance by ID adding Speciality
	void updateVet(Integer id,Specialty s);
	
	//Get all Vets 
	Collection<Vet> getAllVets();
}
