package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.ICiudadService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.entity.CiudadEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private ICiudadService ciudadService;
	
	@GetMapping("/listCiudad")
	public List<CiudadEntity> index(){
		return ciudadService.findAll();
	}
}
