package com.konrad.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConceptoService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IDiagnosticaOcupacionalService;
import com.konrad.edu.IService.IHistoriaService;
import com.konrad.edu.entity.ConceptoEntity;
import com.konrad.edu.entity.DiagnosticoOcupacionalEntity;
import com.konrad.edu.entity.HistoriasEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/historiaPaciente")
public class HistoriaController {

	@Autowired
	private IHistoriaService historiaService;

	@Autowired
	private IConceptoService conceptoService;
	
	@Autowired
	private IDiagnosticaOcupacionalService diagnosticaService;

	@PostMapping("/createHistoria")
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriasEntity create(@RequestBody HistoriasEntity historiaEntity) {
		return historiaService.save(historiaEntity);
	}

	@GetMapping("/listConcepto")
	public List<ConceptoEntity> getListConcepto() {
		return conceptoService.findAll();
	}
	
	@GetMapping("/listImpresionDiagnostica")
	public List<DiagnosticoOcupacionalEntity> getListImpresionDiagnostica() {
		return diagnosticaService.findAll();
	}
}
