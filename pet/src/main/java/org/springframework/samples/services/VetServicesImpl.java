package org.springframework.samples.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.repositories.VetJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class VetServicesImpl implements VetServices {

	@Autowired
	VetJpaRepository vetRepo;
	
	//Insert new Vet instance in DB
	@Override 
	public void insertNewVet(Vet v) {
		vetRepo.save(v);
	}
	
	//Get Vet instance by ID
	@Override 
	public Vet getVetById(Integer id){
		return vetRepo.findById(id).get();
	}
	
	//Update Vet instance by ID adding Speciality
	@Override 
	public void updateVet(Integer id, Specialty s) {
		vetRepo.setSpecialties(s,id);
	}
	
	//Get all Vets 
	@Override 
	public Collection<Vet> getAllVets() {
		return vetRepo.findAll();
	}
}
