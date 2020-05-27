package com.konrad.edu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.ICertificadoService;
import com.konrad.edu.IService.IConceptoService;
import com.konrad.edu.IService.ICondicionGymService;
import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IDiagnosticaOcupacionalService;
import com.konrad.edu.IService.IEncriptacionDatosService;
import com.konrad.edu.IService.IFamiliarGymService;
import com.konrad.edu.IService.IHistoriaGymService;
import com.konrad.edu.IService.IHistoriaOcupacionalService;
import com.konrad.edu.IService.IPersonaService;
import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.IService.ITipoCuestioService;
import com.konrad.edu.IService.ITipoEvaluacionService;
import com.konrad.edu.IService.ITipoHistoriaService;
import com.konrad.edu.IService.ITipoPreguntaHistoriaService;
import com.konrad.edu.IService.ITipoUsuarioService;
import com.konrad.edu.entity.CertificadoEntity;
import com.konrad.edu.entity.ConceptoEntity;
import com.konrad.edu.entity.CondicionGymEntity;
import com.konrad.edu.entity.DiagnosticoOcupacionalEntity;
import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.FamiliarGymEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;
import com.konrad.edu.entity.PersonaEntity;
import com.konrad.edu.entity.TipoCuestionarioEntity;
import com.konrad.edu.entity.TipoEvaluacionEntity;
import com.konrad.edu.entity.TipoHistoriasEntity;
import com.konrad.edu.entity.TipoPreguntaHistoriaGymEntity;
import com.konrad.edu.entity.TipoUsuarioEntity;
import com.konrad.edu.serviceImp.EncriptacionDatosServiceImp;

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
	
	@Autowired
	private ICertificadoService certificadoService;
	
	@Autowired
	private IReportesService reportesService;
	
	
	private EncriptacionDatosServiceImp encriptacionService = new EncriptacionDatosServiceImp();

	@PostMapping("/crearHistoriaOcupacional")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody HistoriaOcupacionalEncriptacion historiaEntity) {
		HistoriaOcupacionalEntity historianew = null;
		eliminarAlterSql();
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			tipoHistoria.setSeqTipoHistoria(1L);
			historiaEntity.setSeqTipoHistoria(tipoHistoria);
			historianew = encriptacionService.encriptacionHistoriaOcupacional(historiaEntity);
			historianew = historiaService.save(historianew);
			if(historianew == null) {
				response.put("mensaje", "Error al realizar el insertar en la base de datos");
				response.put("error", "Error al realizar el insertar en la base de datos");
				response.put("historia", null);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
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

	@PostMapping("/crearHistoriaGym")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody HistoriaGymEncriptacion historiaEntity) {
		HistoriaGYMEntity historianew = null;
		eliminarAlterSql();
		Map<String, Object> response = new HashMap<>();
		try {
			TipoHistoriasEntity tipoHistoria = new TipoHistoriasEntity();
			tipoHistoria.setSeqTipoHistoria(2L);
			historiaEntity.setSeqTipoHistoria(tipoHistoria);
			historianew = encriptacionService.encriptacionHistoriaGym(historiaEntity);
			historianew = historiaGymService.save(historianew);
			if(historianew == null) {
				response.put("mensaje", "Error al realizar el insertar en la base de datos");
				response.put("error", "Error al realizar el insertar en la base de datos");
				response.put("historia", null);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
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

	@PostMapping("/crearCertificado")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createCertificado(@RequestBody CertificadoEntity certificadoEntity) {
		CertificadoEntity certificadoentity = new CertificadoEntity();
		Map<String, Object> response = new HashMap<>();
		try {
			certificadoentity = certificadoService.save(certificadoEntity);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("certificado", null);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el certificado ha sido creado con éxito!");
		response.put("certificado", certificadoentity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarCertificado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> buscarCertificado(@PathVariable Long id) {
		CertificadoEntity certificadoentity = new CertificadoEntity();
		Map<String, Object> response = new HashMap<>();
		try {
			certificadoentity = certificadoService.findByNumeroHistoria(id);
			if(certificadoentity == null) {
				response.put("mensaje", "Error al buscar certificado");
				response.put("error", "Error al buscar certificado");
				response.put("certificado", null);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al buscar certificado");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("certificado", null);
			System.err.print(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Long>(certificadoentity.getSeqCertificado(), HttpStatus.OK);
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
	
	//eliminacion de alter innecesarios
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
			historiaGymService.alterDiagnostico();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter diagnostico gym"));
		}
		try {
			historiaGymService.alterCondiciones();
		}catch (Exception e) {
			System.err.print(e.getMessage().concat(" alter Concepto gym"));
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
