package org.springframework.samples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Repository;

@Repository
public interface VetJpaRepository extends JpaRepository<Vet,Integer> {
	@Modifying
	@Query("update vets v set v.specialties = ?1 where v.id = ?2")
	void setSpecialties(Specialty spec, Integer id);
}
