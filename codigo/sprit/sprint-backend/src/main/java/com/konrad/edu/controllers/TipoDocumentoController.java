package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.ITipoDocumentoService;
import com.konrad.edu.entity.TipoDocumentoEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {

	@Autowired
	private ITipoDocumentoService tipodocumento;

	@GetMapping("/listTipoDocumento")
	public List<TipoDocumentoEntity> index() {
		return tipodocumento.findAll();
	}
}