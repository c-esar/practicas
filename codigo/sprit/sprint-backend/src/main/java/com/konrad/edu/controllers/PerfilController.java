package com.konrad.edu.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IPerfilService;
import com.konrad.edu.IService.IPersonaService;
import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;
import com.konrad.edu.entity.PersonaEntity;
import com.konrad.edu.entity.TipoHistoriasEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/login")
public class PerfilController {

	@Autowired
	private IPerfilService perfilService;

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/sesion/{nomUsuario}/{pass}")
	public ResponseEntity<?> RecibirSesion(@PathVariable("nomUsuario") String nom_usuario,
			@PathVariable("pass") String password) {
		System.out.println("entre" + nom_usuario + password);
		Map<String, Object> response = new HashMap<>();
		PerfilEntity p = null;
		try {
			password = perfilService.Encriptar(password);
			p = perfilService.getSession(nom_usuario, password);
			if (p != null) {
				p.getPersona().get(0).setPerfil(null);
				p.getPersona().get(0).setHistorias(null);
				p.getPersona().get(0).setHistoriasGym(null);
			}
			if (p != null && p.getEstado() != null && p.getEstado().equalsIgnoreCase("a")) {
				System.out.println("entre activo");
				p.setEstado(IConstantes.ESTADO_SESION_ACTIVO);
			} else {
				System.out.println("entre inactivo");
				p.setEstado(IConstantes.ESTADO_SESION_INACTIVO);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", p);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona ha sido creada con éxito!");
		response.put("persona", p);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/labels")
	public LabelConstantes getLabels() {
		LabelConstantes tmp = perfilService.getLabels();
		System.out.println(tmp.toString());
		return tmp;
	}

	@PostMapping("/creacionUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody PerfilEntity persona) {
		PerfilEntity personaNew = null;
		PersonaEntity personaEntity = null;
		Map<String, Object> response = new HashMap<>();
		try {
			personaEntity = persona.getPersona().get(0);
			persona.getPersona().clear();
			String password = persona.getPassword();
			password = perfilService.Encriptar(password);
			persona.setPassword(password);
			personaNew = perfilService.save(persona);
			if (personaNew != null) {
				personaEntity.setPerfil(new PerfilEntity());
				personaEntity.getPerfil().setSeqPerfil(personaNew.getSeqPerfil());
				personaEntity = personaService.save(personaEntity);
				if (personaEntity != null) {
					personaEntity.setPerfil(null);
					personaEntity.setHistorias(null);
					personaEntity.setHistoriasGym(null);
				}
			}
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

	@GetMapping("/obtenerPersona/{numeroDocumento}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> obtenerPersona(@PathVariable("numeroDocumento") String numero_documento) {
		PerfilEntity personaNew = null;
		PersonaEntity tmp = null;
		Map<String, Object> response = new HashMap<>();
		try {
			personaNew = perfilService.findHcPerfilesByNumeroDocumneto(numero_documento);
			personaNew.setPassword(null);
			if (personaNew != null) {
				tmp = personaNew.getPersona().get(0);
				tmp.setHistorias(null);
				tmp.setHistoriasGym(null);
				tmp.setPerfil(null);
				personaNew.getPersona().clear();
				personaNew.getPersona().add(tmp);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error no se encuentra registrado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", personaNew);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			if (personaNew == null) {
				personaNew = new PerfilEntity();
				PersonaEntity persona = new PersonaEntity();
				persona = personaService.findByNumeroDocumento(numero_documento);
				if (persona != null) {
					personaNew.getPersona().add(persona);
					personaNew.getPersona().get(0).setHistorias(null);
					personaNew.getPersona().get(0).setHistoriasGym(null);
				}
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error no se encuentra registrado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", personaNew);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona ha sido encontrada con éxito!");
		response.put("persona", personaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
