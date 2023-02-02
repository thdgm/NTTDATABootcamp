package org.springframework.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.services.VetServices;
import org.springframework.stereotype.Controller;

@Controller
public class VetJpaController {

	@Autowired
	private VetServices vs;
	
}
