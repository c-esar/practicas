package com.konrad.edu.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConceptoService;
import com.konrad.edu.IService.ICondicionGymService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IDiagnosticaOcupacionalService;
import com.konrad.edu.IService.IFamiliarGymService;
import com.konrad.edu.IService.IHistoriaGymService;
import com.konrad.edu.IService.IHistoriaOcupacionalService;
import com.konrad.edu.IService.ITipoCuestioService;
import com.konrad.edu.IService.ITipoEvaluacionService;
import com.konrad.edu.IService.ITipoHistoriaService;
import com.konrad.edu.IService.ITipoPreguntaHistoriaService;
import com.konrad.edu.IService.ITipoUsuarioService;
import com.konrad.edu.entity.CiudadEntity;
import com.konrad.edu.entity.ConceptoEntity;
import com.konrad.edu.entity.CondicionGymEntity;
import com.konrad.edu.entity.CuestionarioGymEntity;
import com.konrad.edu.entity.DiagnosticoOcupacionalEntity;
import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.FamiliarGymEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;
import com.konrad.edu.entity.HistoriaPreguntasGym;
import com.konrad.edu.entity.PersonaEntity;
import com.konrad.edu.entity.TipoCuestionarioEntity;
import com.konrad.edu.entity.TipoEvaluacionEntity;
import com.konrad.edu.entity.TipoHistoriasEntity;
import com.konrad.edu.entity.TipoPreguntaHistoriaGymEntity;
import com.konrad.edu.entity.TipoUsuarioEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/historiaPaciente")
public class HistoriaController {

	@Autowired
	private IHistoriaOcupacionalService historiaService;

	@Autowired
	private IHistoriaGymService historiaGymService;

	@Autowired
	private IConceptoService conceptoService;

	@Autowired
	private IDiagnosticaOcupacionalService diagnosticaService;

	@Autowired
	private ITipoEvaluacionService tipoEvaluacionService;

	@Autowired
	private ITipoHistoriaService tipoHistoriaService;

	@Autowired
	private ITipoUsuarioService tipoUsuarioService;

	@Autowired
	private ITipoPreguntaHistoriaService tipoPreguntaGym;

	@Autowired
	private ITipoCuestioService tipoCuestion;

	@Autowired
	private IFamiliarGymService familiarservice;

	@Autowired
	private ICondicionGymService condicionService;

	@PostMapping("/crearHistoriaOcupacional")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody HistoriaOcupacionalEncriptacion historiaEntity) {
		HistoriaOcupacionalEntity historianew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			tipoHistoria.setSeqTipoHistoria(1L);
			historiaEntity.setSeqTipoHistoria(tipoHistoria);
			historianew = EncriptacionHistoriaOcupacional(historiaEntity);
			historianew = historiaService.save(historianew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("historia", historianew);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La historia ha sido creada con éxito!");
		response.put("historia", historianew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	private HistoriaOcupacionalEntity EncriptacionHistoriaOcupacional(HistoriaOcupacionalEncriptacion historiaEntity) {
		HistoriaOcupacionalEntity historia = new HistoriaOcupacionalEntity();
		historia.setSeqHistoria(historiaEntity.getSeqHistoria());
		historia.setSeqTipoHistoria(historiaEntity.getSeqTipoHistoria());
		historia.setExamenFisico(EncriptacionExamenFisico(historiaEntity.getExamenFisico()));
		historia.setHistoriaLaboral(historiaEntity.getHistoriaLaboral());
		historia.setAntecedentesHistoriaEntity(historiaEntity.getAntecedentesHistoriaEntity());
		historia.setParaclinicosEntity(historiaEntity.getParaclinicosEntity());
		historia.setTipoEvaluacionEntity(historiaEntity.getTipoEvaluacionEntity());
		historia.setCiudadHistoria(historiaEntity.getCiudadHistoria());
		historia.setConceptoConcepto(historiaEntity.getConceptoConcepto());
		historia.setDiagnosticoOcupacionalEntity(historiaEntity.getDiagnosticoOcupacionalEntity());
		historia.setDiaHistoria(historiaEntity.getDiaHistoria());
		historia.setDespMotivoConsulta(historiaEntity.getDespMotivoConsulta().getBytes());
		historia.setRevisionSistemas(historiaEntity.getRevisionSistemas().getBytes());
		historia.setRecomMedicas(historiaEntity.getRecomMedicas().getBytes());
		historia.setRecomOcupacionales(historiaEntity.getRecomOcupacionales().getBytes());
		historia.setRecomHabitos(historiaEntity.getRecomHabitos().getBytes());
		historia.setOtroEvaluacion(
				historiaEntity.getOtroEvaluacion() == null ? null : historiaEntity.getOtroEvaluacion().getBytes());
		historia.setAceptoCondiciones(historiaEntity.getAceptoCondiciones());
		historia.setPersona(historiaEntity.getPersona());
		return historia;
	}

	@PostMapping("/crearHistoriaGym")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody HistoriaGymEncriptacion historiaEntity) {
		HistoriaGYMEntity historianew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			tipoHistoria.setSeqTipoHistoria(2L);
			historiaEntity.setSeqTipoHistoria(tipoHistoria);
			historianew = EncriptacionHistoriaGym(historiaEntity);
			historianew = historiaGymService.save(historianew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("historia", historianew);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La historia ha sido creada con éxito!");
		response.put("historia", historianew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	private HistoriaGYMEntity EncriptacionHistoriaGym(HistoriaGymEncriptacion historiaEntity) {
		HistoriaGYMEntity historianew = new HistoriaGYMEntity();
		historianew.setObservacionesHistoria(historiaEntity.getObservacionesHistoria().getBytes());
		historianew.setAceptoCondiciones(historiaEntity.getAceptoCondiciones());
		historianew.setConducta(historiaEntity.getConducta() == null ? null : historiaEntity.getConducta().getBytes());
		historianew.setSeqHistoriaGym(historiaEntity.getSeqHistoriaGym());
		historianew.setSeqTipoHistoria(historiaEntity.getSeqTipoHistoria());
		historianew.setExamenFisico(EncriptacionExamenFisico(historiaEntity.getExamenFisico()));
		historianew.setCiudadHistoria(historiaEntity.getCiudadHistoria());
		historianew.setHistoriaPreguntasGyms(historiaEntity.getHistoriaPreguntasGyms());
		historianew.setDiagnosticoOcupacionalEntity(historiaEntity.getDiagnosticoOcupacionalEntity());
		historianew.setCondicionGymEntity(historiaEntity.getCondicionGymEntity());
		historianew.setFamiliarGymEntity(historiaEntity.getFamiliarGymEntity());
		historianew.setCuestionarioGymEntity(historiaEntity.getCuestionarioGymEntity());
		historianew.setPersona(historiaEntity.getPersona());
		historianew.setDiaHistoriaGym(historiaEntity.getDiaHistoriaGym());
		historianew.setOtraCondicion(
				historiaEntity.getOtraCondicion() == null ? null : historiaEntity.getOtraCondicion().getBytes());
		historianew.setOtraFamiliar(
				historiaEntity.getOtraFamiliar() == null ? null : historiaEntity.getOtraFamiliar().getBytes());
		historianew.setTipoCancer(
				historiaEntity.getTipoCancer() == null ? null : historiaEntity.getTipoCancer().getBytes());
		historianew.setConducta(historiaEntity.getConducta() == null ? null : historiaEntity.getConducta().getBytes());
		return historianew;
	}

	private ExamenFisicoEntity EncriptacionExamenFisico(ExamenFisicoEncriptacion examenFisicoEntity) {
		ExamenFisicoEntity examen = new ExamenFisicoEntity();
		examen.setSeqExaFisico(examenFisicoEntity.getSeqExaFisico());
		examen.setNumTesion(examenFisicoEntity.getNumTesion());
		examen.setNumFreCar(examenFisicoEntity.getNumFreCar());
		examen.setNumSat(examenFisicoEntity.getNumSat());
		examen.setNumFrecResp(examenFisicoEntity.getNumFrecResp());
		examen.setNumPeso(examenFisicoEntity.getNumPeso());
		examen.setNumTalla(examenFisicoEntity.getNumTalla());
		examen.setNumImc(examenFisicoEntity.getNumImc());
		examen.setLateralidad(
				examenFisicoEntity.getLateralidad() == null ? null : examenFisicoEntity.getLateralidad().getBytes());
		examen.setDespCapCuello(examenFisicoEntity.getDespCapCuello().getBytes());
		examen.setDespTorax(
				examenFisicoEntity.getDespTorax() == null ? null : examenFisicoEntity.getDespTorax().getBytes());
		examen.setDespAdb(examenFisicoEntity.getDespAdb().getBytes());
		examen.setDespGenitourinario(examenFisicoEntity.getDespGenitourinario().getBytes());
		examen.setDespColumn(examenFisicoEntity.getDespColumn().getBytes());
		examen.setDespMiembros(
				examenFisicoEntity.getDespMiembros() == null ? null : examenFisicoEntity.getDespMiembros().getBytes());
		examen.setDespOsteomuscular(examenFisicoEntity.getDespOsteomuscular().getBytes());
		examen.setDespNeurologico(examenFisicoEntity.getDespNeurologico().getBytes());
		examen.setDespPielfan(examenFisicoEntity.getDespPielfan().getBytes());
		return examen;

	}

	@GetMapping("/listConcepto")
	public List<ConceptoEntity> getListConcepto() {
		return conceptoService.findAll();
	}

	@GetMapping("/listImpresionDiagnostica")
	public List<DiagnosticoOcupacionalEntity> getListImpresionDiagnostica() {
		return diagnosticaService.findAll();
	}

	@GetMapping("/listTipoEvaluacion")
	public List<TipoEvaluacionEntity> getListTipoEvaluacion() {
		return tipoEvaluacionService.findAll();
	}

	@GetMapping("/listTipoHistoria")
	public List<TipoHistoriasEntity> getListTipoHistoria() {
		return tipoHistoriaService.findAll();
	}

	@GetMapping("/listTipoUsuario")
	public List<TipoUsuarioEntity> getListTipoUsuario() {
		return tipoUsuarioService.findAll();
	}

	@GetMapping("/listTipoPreguntaHistoriaGym")
	public List<TipoPreguntaHistoriaGymEntity> getListTipoPreguntaHistoriaGym() {
		return tipoPreguntaGym.findAll();
	}

	@GetMapping("/listTipoCuestionario")
	public List<TipoCuestionarioEntity> getListTipoCuestionario() {
		return tipoCuestion.findAll();
	}

	@GetMapping("/listFamiliarGym")
	public List<FamiliarGymEntity> getListFamiliarGym() {
		return familiarservice.findAll();
	}

	@GetMapping("/listCondicionGym")
	public List<CondicionGymEntity> getListCondicionGym() {
		return condicionService.findAll();
	}
}
