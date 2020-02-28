package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IPersonaService;
import com.konrad.edu.entity.PersonaEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/listPersonas")
	public List<PersonaEntity> index() {
		return personaService.findAll();
	}

	@GetMapping("/listPersonas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonaEntity show(@PathVariable Long id) {
		return personaService.findById(id);
	}

	@PostMapping("/crearPersona")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonaEntity create(@RequestBody PersonaEntity persona) {
		return personaService.save(persona);
	}

	@PutMapping("/listPersonas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonaEntity update(@RequestBody PersonaEntity persona, @PathVariable Long id) {
		PersonaEntity perActual = personaService.findById(id);
		perActual.setNomPrimerNombre(persona.getNomPrimerNombre());

		return personaService.save(perActual);
	}

	@DeleteMapping("/listPersonas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personaService.delete(id);
	}

	@GetMapping("/buscarDocumento/{numeroDocumento}")
	@ResponseStatus(HttpStatus.OK)
	public PersonaEntity buscar(@PathVariable String numeroDocumento) {
		return personaService.findByNumeroDocumento(numeroDocumento);
	}
}
