package com.konrad.edu.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContextoPrincipal {

	@GetMapping("/")
	public String contextoInicio() {
		return "Aplicación iniciada con éxito";
	}
}
