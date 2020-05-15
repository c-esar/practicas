package com.konrad.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IPersonaService;

@RestController
public class ContextoPrincipal {
	
	@GetMapping("/")
	public String contextoInicio() {
		return "Aplicación iniciada con éxito";
	}
}
