package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IAseguradoraService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.entity.AseguradoraEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/aseguradora")
public class AseguradoraController {

	@Autowired
	private IAseguradoraService aseguradoraService;

	@GetMapping("/listAseguradora")
	public List<AseguradoraEntity> index() {
		return aseguradoraService.findAll();
	}
}
