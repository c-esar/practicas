package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.ILocalidadService;
import com.konrad.edu.entity.LocalidadEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/localidad")
public class LocalidadController {

	@Autowired
	private ILocalidadService localidadService;

	@GetMapping("/listLocalidad")
	public List<LocalidadEntity> index() {
		return localidadService.findAll();
	}
}
