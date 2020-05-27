package com.konrad.edu.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.iterators.ArrayListIterator;
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
import com.konrad.edu.IService.IEncriptacionDatosService;
import com.konrad.edu.IService.IHistoriaGymService;
import com.konrad.edu.IService.IHistoriaOcupacionalService;
import com.konrad.edu.IService.IPersonaService;
import com.konrad.edu.entity.AntecedentesHistoriaEntity;
import com.konrad.edu.entity.CiudadEntity;
import com.konrad.edu.entity.ConceptoEntity;
import com.konrad.edu.entity.DiagnosticoOcupacionalEntity;
import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaLaboralEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;
import com.konrad.edu.entity.ParaclinicosEntity;
import com.konrad.edu.entity.PersonaEntity;
import com.konrad.edu.entity.TipoEvaluacionEntity;
import com.konrad.edu.entity.TipoHistoriasEntity;
import com.konrad.edu.serviceImp.EncriptacionDatosServiceImp;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IHistoriaOcupacionalService historiaService;

	@Autowired
	private IHistoriaGymService historiaGymService;
	
	private EncriptacionDatosServiceImp encriptacionService = new EncriptacionDatosServiceImp();

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
		HistoriaOcupacionalEntity ocupacional = null;
		HistoriaGYMEntity gym = null;
		String error = "";
		eliminarAlterSql();
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			if (!persona.getHistorias().isEmpty()) {
				tipoHistoria.setSeqTipoHistoria(1L);
				persona.getHistorias().get(0).setSeqTipoHistoria(tipoHistoria);
				ocupacional = encriptacionService.encriptacionHistoriaOcupacional(persona.getHistorias().get(0));
				persona.setHistorias(null);
				try {
					persona.setImagenEncriptada(persona.getImagen() == null ? null : persona.getImagen().getBytes());
					personaNew = personaService.save(persona);
				} catch (DataAccessException e) {
					System.err.print(
							"No se puede guardar la informacion, la persona ya estaba o sucedio problemas en la base de datos");
					response.put("mensaje", "Error al realizar el insertar en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				try {
					ocupacional.getPersona().setSeqPersona(personaNew.getSeqPersona());
					ocupacional = historiaService.save(ocupacional);
					if(ocupacional == null) {
						personaService.delete(ocupacional.getPersona().getSeqPersona().longValue());
						System.err.print("No se puede guardar la informacion de la persona, pero no la historia");
						response.put("mensaje", "Error al realizar el insertar en la base de datos");
						response.put("error", "Error al realizar el insertar en la base de datos");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				} catch (DataAccessException e) {
					personaService.delete(ocupacional.getPersona().getSeqPersona().longValue());
					System.err.print("No se puede guardar la informacion de la persona, pero no la historia");
					response.put("mensaje", "Error al realizar el insertar en la base de datos");
					response.put("error", "Error al realizar el insertar en la base de datos");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			} else if (!persona.getHistoriaGym().isEmpty()) {
				tipoHistoria.setSeqTipoHistoria(2L);
				persona.getHistoriaGym().get(0).setSeqTipoHistoria(tipoHistoria);
				gym = this.encriptacionService.encriptacionHistoriaGym(persona.getHistoriaGym().get(0));
				persona.setHistoriaGym(null);
				try {
					persona.setImagenEncriptada(persona.getImagen() == null ? null : persona.getImagen().getBytes());
					personaNew = personaService.save(persona);
				} catch (DataAccessException e) {
					System.err.print(
							"No se puede guardar la informacion, la persona ya estaba o sucedio problemas en la base de datos");
					response.put("mensaje", "Error al realizar el insertar en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				try {
					gym.getPersona().setSeqPersona(personaNew.getSeqPersona());
					gym = historiaGymService.save(gym);
					if(gym == null) {
						personaService.delete(gym.getPersona().getSeqPersona().longValue());
						System.err.print("No se puede guardar la informacion de la persona, pero no la historia");
						response.put("mensaje", "Error al realizar el insertar en la base de datos");
						response.put("error", "Error al realizar el insertar en la base de datos");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				} catch (DataAccessException e) {
					personaService.delete(gym.getPersona().getSeqPersona().longValue());
					System.err.print("No se puede guardar la informacion de la persona, pero no la historia");
					response.put("mensaje", "Error al realizar el insertar en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
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

	@PutMapping("/actualizarPersonaDatos")
	public ResponseEntity<?> update(@RequestBody PersonaEntity persona) {
		PersonaEntity personaUp = null;
		Map<String, Object> response = new HashMap<>();
		try {
			persona.setHistoriaGymEncriptacion(null);
			persona.setHistoriaGym(null);
			persona.setHistorias(null);
			persona.setHistoriasEncriptacion(null);
			persona.setImagenEncriptada(persona.getImagen() == null ? null : persona.getImagen().getBytes());
			personaUp = personaService.save(persona);
			if (personaUp != null) {
				personaUp.setPerfil(null);
				personaUp.setHistoriasEncriptacion(null);
				personaUp.setHistoriaGymEncriptacion(null);
			} else {
				response.put("mensaje", "Error al realizar al actualizar en la base de datos");
				response.put("error", "Error al realizar al actualizar en la base de datos");
				response.put("persona", personaUp);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", personaUp);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona ha sido actualizado con éxito!");
		response.put("persona", personaUp);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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
		eliminarAlterSql();
		try {
			personaNew = personaService.findByNumeroDocumento(numeroDocumento);
			if (personaNew != null) {
				
				for (int i = 0; i < personaNew.getHistoriaGymEncriptacion().size(); i++) {
					personaNew.getHistoriaGymEncriptacion().get(i).setPersona(null);
				}
				for (int i = 0; i < personaNew.getHistoriasEncriptacion().size(); i++) {
					personaNew.getHistoriasEncriptacion().get(i).setPersona(null);
				}
				if (personaNew.getImagenEncriptada() != null) {
					personaNew.setImagen(new String(personaNew.getImagenEncriptada()));
				}
//				 personaNew.setHistorias(null);
//				 personaNew.setHistoriasGym(null);
				if (personaNew.getPerfil() != null) {
					personaNew.getPerfil().getPersona().clear();
				}
			}
		} catch (DataAccessException e) {
			response.put("mensaje",
					"La persona con Documento".concat(numeroDocumento).concat("no existe en la base de datos"));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (personaNew == null) {
			response.put("mensaje",
					"La persona con Documento ".concat(numeroDocumento).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PersonaEntity>(personaNew, HttpStatus.OK);
	}

	@GetMapping("/listPersonas/informe/{tipoUsuario}")
	public ResponseEntity<?> informeListPersonas(@PathVariable List<String> tipoUsuario) {
		List<PersonaEntity> personaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			personaNew = (List<PersonaEntity>) personaService.findAllTipoUsuario(tipoUsuario);
			if (personaNew != null) {
				for (int i = 0; i < personaNew.size(); i++) {
					personaNew.get(i).setHistoriasEncriptacion(null);
					personaNew.get(i).setHistoriaGymEncriptacion(null);
					personaNew.get(i).setPerfil(null);
				}
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "No se encontro ningún resultado");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (personaNew == null) {
			response.put("mensaje", "No se encontro ningún resultado");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PersonaEntity>>(personaNew, HttpStatus.OK);
	}
	
	private void eliminarAlterSql() {
		try {
			historiaService.alterConcepto();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter Concepto ocupacional"));
		}
		try {
			historiaService.alterdiagnostico();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter diagnostico ocupacional"));
		}
		try {
			historiaGymService.alterCondiciones();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter Concepto gym"));
		}
		try {
			historiaGymService.alterDiagnostico();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter diagnostico gym"));
		}
		try {
			historiaGymService.alterFamiliares();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter Familiares Gym"));
		}
		try {
			historiaGymService.alterUsuarios();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter usuarios"));
		}
	}
}
