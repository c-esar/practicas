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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.entity.PersonaEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	private IReportesService reportesService;

	@GetMapping("/historiaGym/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> reportesHistoriasGym(@PathVariable String id) {
		String enviarRuta = null;
		Map<String, Object> response = new HashMap<>();
		try {
			enviarRuta = reportesService.exportReport(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", enviarRuta);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se ha realizado la consulta!");
		response.put("persona", enviarRuta);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/historiaOcupacional/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> reportesHistoriasOcupacional(@PathVariable String id) {
		String enviarRuta = null;
		Map<String, Object> response = new HashMap<>();
		try {
			enviarRuta = reportesService.exportReportOcupacional(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("persona", enviarRuta);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Se ha realizado la consulta!");
		response.put("persona", enviarRuta);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
