package com.konrad.edu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.konrad.edu.entity.TipoHistoriasEntity;

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
	public ResponseEntity<?> create(@RequestBody PersonaEntity persona) {
		PersonaEntity personaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			tipoHistoria.setSeqTipoHistoria(1L);
			persona.getHistorias().get(0).setSeqTipoHistoria(tipoHistoria);
			personaNew = personaService.save(persona);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", personaNew);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona ha sido creada con éxito!");
		response.put("persona", personaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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
	public ResponseEntity<?> buscar(@PathVariable String numeroDocumento) {
		PersonaEntity personaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
		 personaNew = personaService.findByNumeroDocumento(numeroDocumento);
		}catch(DataAccessException e) {
			response.put("mensaje", "La persona con Documento".concat(numeroDocumento).concat("no existe en la base de datos"));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if(personaNew == null) {
			response.put("mensaje", "La persona con Documento".concat(numeroDocumento).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PersonaEntity>(personaNew, HttpStatus.OK);
	}
}
