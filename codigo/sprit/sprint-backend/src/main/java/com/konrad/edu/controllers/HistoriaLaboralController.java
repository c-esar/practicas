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

import com.konrad.edu.IService.IAntecedentesTrabajoService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IEmpresaLaboralService;
import com.konrad.edu.IService.IEnfermedadesLaboralService;
import com.konrad.edu.IService.IFactoresRiesgoService;
import com.konrad.edu.IService.IHistoriaLaboralService;
import com.konrad.edu.IService.ITipoAntecedenteService;
import com.konrad.edu.entity.AntecedentesTrabajoEntity;
import com.konrad.edu.entity.EmpresaLaboralEntity;
import com.konrad.edu.entity.EnfermedadesLaboralEntity;
import com.konrad.edu.entity.FactoresRiesgoEntity;
import com.konrad.edu.entity.HistoriaLaboralEntity;
import com.konrad.edu.entity.TipoAntecedenteEntity;
import com.konrad.edu.entity.TipoDocumentoEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/historiaLaboral")
public class HistoriaLaboralController {

	@Autowired
	private IHistoriaLaboralService historiaLaboralService;
	@Autowired
	private IAntecedentesTrabajoService antecedentesService;
	@Autowired
	private IEmpresaLaboralService empresaLaboralService;
	@Autowired
	private IEnfermedadesLaboralService enfermedadesLaboralService;
	@Autowired
	private IFactoresRiesgoService factoresRiesgoService;
	@Autowired
	private ITipoAntecedenteService tipoAntecedenteService;

	@PostMapping("/createAntecedente")
	@ResponseStatus(HttpStatus.CREATED)
	public AntecedentesTrabajoEntity create(@RequestBody AntecedentesTrabajoEntity antecedentesTrabajoEntity) {
		return antecedentesService.save(antecedentesTrabajoEntity);
	}

	@PostMapping("/createEmpresa")
	@ResponseStatus(HttpStatus.CREATED)
	public EmpresaLaboralEntity create(@RequestBody EmpresaLaboralEntity empresaLaboralEntity) {
		return empresaLaboralService.save(empresaLaboralEntity);
	}

	@PostMapping("/createEnfermedades")
	@ResponseStatus(HttpStatus.CREATED)
	public EnfermedadesLaboralEntity create(@RequestBody EnfermedadesLaboralEntity empresaLaboralEntity) {
		return enfermedadesLaboralService.save(empresaLaboralEntity);
	}

	@PostMapping("/createFactoresRiesgo")
	@ResponseStatus(HttpStatus.CREATED)
	public FactoresRiesgoEntity create(@RequestBody FactoresRiesgoEntity factoresRiesgoEntity) {
		return factoresRiesgoService.save(factoresRiesgoEntity);
	}

	@PostMapping("/createHistoriaLaboral")
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriaLaboralEntity create(@RequestBody HistoriaLaboralEntity historiaLaboralEntity) {
		return historiaLaboralService.save(historiaLaboralEntity);
	}

	@GetMapping("/listTipoAntecedentes")
	public List<TipoAntecedenteEntity> index() {
		return tipoAntecedenteService.findAll();
	}
}
