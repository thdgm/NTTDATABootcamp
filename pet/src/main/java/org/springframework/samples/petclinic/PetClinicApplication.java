/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.services.VetServices;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */

/*
 * 
1.Crear un objeto Vet sin Speciality
2.Persistir el objeto Vet en BBDD
3.Consultar por ID y comprobar que se ha creado correctamente
4.Editar el elemento recién creado para añadir una Speciality concreta
5.Listar todos los veterinarios existentes
6.Subirlo a Github
 * 
 */

@SpringBootApplication
@ComponentScan("org.springframework.samples.*")
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication {

	@Autowired
	private VetServices vs;
	
	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
		return (args) -> {
			
			//New Vet Object
			Vet newVet = new Vet();
			newVet.setFirstName("Diego");
			newVet.setId(201);
			newVet.setLastName("Garcia");
			
			Specialty newSpeciality = new Specialty();
			newSpeciality.setId(201);
			newSpeciality.setName("Nueva");
			
			System.out.println("Creado:");
			System.out.println(newVet);
			
			//Insert newVet into DB

			vs.insertNewVet(newVet);
			
			//Check newVet into DB

			vs.getVetById(newVet.getId());
			
			
			//Check newVet into DB

			vs.updateVet(newVet.getId(), newSpeciality);
			
			//Check newVet into DB

			vs.getAllVets();
			
		};
	}

}
