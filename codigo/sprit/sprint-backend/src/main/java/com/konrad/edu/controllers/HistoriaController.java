package com.konrad.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IHistoriaService;
import com.konrad.edu.entity.HistoriasEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/historiaPaciente")
public class HistoriaController {

	@Autowired
	private IHistoriaService historiaService;

	@PostMapping("/createHistoria")
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriasEntity create(@RequestBody HistoriasEntity historiaEntity) {
		return historiaService.save(historiaEntity);
	}
}
