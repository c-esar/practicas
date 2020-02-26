package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.entity.Persona;
import com.konrad.edu.service.IPersonaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/persona")
public class PersonaController  {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/listPersonas")
	public List<Persona> index(){
		return personaService.findAll();
	}
}
