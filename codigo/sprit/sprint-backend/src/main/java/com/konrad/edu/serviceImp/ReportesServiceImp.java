package com.konrad.edu.serviceImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.dao.ICertificadoDao;
import com.konrad.edu.dao.ICertificadoGymDao;
import com.konrad.edu.dao.IPersonaDao;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.PersonaEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportesServiceImp implements IReportesService {

	@Autowired
	private IPersonaDao personaDao;

	@Autowired
	private ICertificadoDao certificadoDao;
	
	@Autowired
	private ICertificadoGymDao certificadoGymDao;

	// reporte historia gym
	@Override
	public String exportReport(String id, int historias, String documentoMedico) {
		try {
			Connection conexion = DriverManager
					.getConnection(IConstantes.JDBC_REPORTE, IConstantes.USER_DB, IConstantes.PASS_DB);
			File file = ResourceUtils.getFile("classpath:historiasGym.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			PersonaEntity persona = this.obtenerInformacion(id);
			HistoriaGYMEntity historia = new HistoriaGYMEntity();
			for (int i = 0; i < persona.getHistoriaGymEncriptacion().size(); i++) {
				if (persona.getHistoriaGymEncriptacion().get(i).getSeqHistoriaGym().intValue() == historias) {
					historia = persona.getHistoriaGymEncriptacion().get(i);
					break;
				}
			}
			Map<String, Object> parameters = new HashMap<>();
			String impresionDiagnostica = "";
			PersonaEntity medico = personaDao.findByPersonaMedico(historia.getPersonaMedico().toString());
			for (int i = 0; i < historia.getHistoriaPreguntasGyms().size(); i++) {
				switch (historia.getHistoriaPreguntasGyms().get(i).getTipoPreguntaHistoriaGymEntity()
						.getNomPregunta()) {
				case "EMBARAZO": {
					parameters.put("embarazo",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					break;
				}
				case "FUMA": {
					parameters.put("fumaSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					parameters.put("fumacuantos",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					parameters.put("fumatiempo",
							historia.getHistoriaPreguntasGyms().get(i).getTiempoFumando() == null ? ""
									: historia.getHistoriaPreguntasGyms().get(i).getTiempoFumando());
					break;
				}
				case "LICOR": {
					parameters.put("licorSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					parameters.put("licorcuantos",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					break;
				}
				case "EJERCICIO": {
					parameters.put("ejercicioSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					parameters.put("ejerciciocuales",
							historia.getHistoriaPreguntasGyms().get(i).getDespCuales() == null ? ""
									: historia.getHistoriaPreguntasGyms().get(i).getDespCuales());
					parameters.put("ejerciciocuantas",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					break;
				}
				case "ENERGIZANTES": {
					parameters.put("energizanteSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					parameters.put("energizantecuantas",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					break;
				}
				case "PSICOACTIVAS": {
					parameters.put("psicoactivasSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S") ? "SI"
									: "NO");
					parameters.put("psicoactivascuales",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getDespCuales()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getDespCuales()));
					break;
				}
				}
			}
			for (int i = 0; i < historia.getDiagnosticoOcupacionalEntity().size(); i++) {
				impresionDiagnostica += historia.getDiagnosticoOcupacionalEntity().get(i).getCodDiagnostico() + "-"
						+ historia.getDiagnosticoOcupacionalEntity().get(i).getDesDiagnostico();
				if (i < historia.getDiagnosticoOcupacionalEntity().size() - 1) {
					impresionDiagnostica += ";  ";
				}
			}
			String rolUsuario = "";
			for (int i = 0; i < historia.getPersona().getRolUsuario().size(); i++) {
				rolUsuario += historia.getPersona().getRolUsuario().get(i).getNomTipoUsuario();
				if (i < historia.getPersona().getRolUsuario().size() - 1) {
					rolUsuario += ";  ";
				}
			}

			parameters.put("impresionDiagnostica", impresionDiagnostica);
			parameters.put("numeroPersona", persona.getSeqPersona());
			parameters.put("numeroHistoria", historias);
			parameters.put("rolUsuario", rolUsuario);
			if (persona.getImagenEncriptada() != null) {
				persona.setImagen(new String(persona.getImagenEncriptada()));
				persona.setImagen(new String(persona.getImagenEncriptada()));
				parameters.put("imagenPaciente", crearImagenPaciente(persona.getImagen(), "paciente"));
			}
			if (medico.getImagenEncriptada() != null) {
				medico.setImagen(new String(medico.getImagenEncriptada()));
				parameters.put("imagenMedico", crearImagenPaciente(medico.getImagen(), "medico"));
			}
			parameters.put("documentoMedico", medico.getNumeroDocumento());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			File pdf = File.createTempFile("output.", ".pdf");
			System.out.println("Lo exportamos a " + pdf.getAbsolutePath());
			FileOutputStream pdffinal = new FileOutputStream(pdf);
			JasperExportManager.exportReportToPdfStream(jasperPrint, pdffinal);
			pdffinal.close();
			byte[] inFileBytes = Files.readAllBytes(Paths.get(pdf.getAbsolutePath()));
			byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
			String base64EncryptedString = "";
			base64EncryptedString = new String(encoded);
			System.out.print(base64EncryptedString);
			return base64EncryptedString;
		} catch (IOException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (JRException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return null;

	}

	// reporte historia ocupacional
	@Override
	public String exportReportOcupacional(String id, int historias, String documentoMedico) {
		try {
			Connection conexion = DriverManager
					.getConnection(IConstantes.JDBC_REPORTE, IConstantes.USER_DB, IConstantes.PASS_DB);
			File file = ResourceUtils.getFile("classpath:ocupacional.jrxml");
			Map<String, Object> parameters = new HashMap<>();
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			PersonaEntity persona = this.obtenerInformacion(id);
			PersonaEntity historia = new PersonaEntity();
			for (int i = 0; i < persona.getHistoriasEncriptacion().size(); i++) {
				if (persona.getHistoriasEncriptacion().get(i).getSeqHistoria().intValue() == historias) {
					historia.getHistoriasEncriptacion().add(persona.getHistoriasEncriptacion().get(i));
					break;
				}
			}
			PersonaEntity medico = this.personaDao
					.findByPersonaMedico(historia.getHistoriasEncriptacion().get(0).getPersonaMedico().toString());
			for (int i = 0; i < historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
					.size(); i++) {
				switch (historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
						.getTipoAntecedenteEntity().getNomAntecedente()) {
				case "PATOLOGICOS": {
					parameters.put("patologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("patologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "QUIRURGICOS": {
					parameters.put("quirurgicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" : 
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("quirurgicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "ALERGICOS": {
					parameters.put("alergicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("alergicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "FARMACOLOGICOS": {
					parameters.put("farmacologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" : 
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("farmacologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "TRAUMATICOS": {
					parameters.put("traumaticosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("traumaticoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "TOXICOS": {
					parameters.put("toxicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("toxicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "INMUNOLOGICOS": {
					parameters.put("inmunologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("inmunologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "MENARQUIA": {
					parameters.put("menarquiaplanificacion", historia.getHistoriasEncriptacion().get(0)
							.getAntecedentesHistoriaEntity().get(i).getPlanificacion());
					parameters.put("menarquiaccv",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getCcv() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getCcv());
					parameters.put("menarquiafur",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getFur() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getFur());
					parameters.put("menarquia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getMernarquia() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getMernarquia());
					break;
				}
				case "HOSPITALARIOS": {
					parameters.put("hospitalariosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" : 
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("hospitalarioscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "FAMILIARES": {
					parameters.put("familiaresSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("familiarescual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				case "TABAQUISMO": {
					parameters.put("tabaquimosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("tabaquimosfrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getFrecuencia() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getFrecuencia());
					parameters.put("tabaquimosanos", historia.getHistoriasEncriptacion().get(0)
							.getAntecedentesHistoriaEntity().get(i).getAnosHabito());
					parameters.put("tabaquimosfumador", 
							historia.getHistoriasEncriptacion().get(0)
							.getAntecedentesHistoriaEntity().get(i).getExFumador() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0)
							.getAntecedentesHistoriaEntity().get(i).getExFumador().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					break;
				}
				case "CONSUMO ALCOHOL": {
					parameters.put("consumoSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("consumofrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getFrecuencia() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getFrecuencia());
					break;
				}
				case "ACTIVIDAD FÍSICA": {
					parameters.put("actividadSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
							.getEstadoAntecedente() == null ? "NO" :
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getEstadoAntecedente().toString().equalsIgnoreCase("S") ? "SI" : "NO");
					parameters.put("actividadfrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getFrecuencia() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getFrecuencia());
					parameters.put("actividadtipo",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getTipo() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getTipo());
					break;
				}
				case "ACTIVIDAD EXTRA LABORAL": {
					parameters.put("actividadlaboralcual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i)
									.getDespAntecedente() == null ? ""
											: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity()
													.get(i).getDespAntecedente());
					break;
				}
				default:
					break;
				}
			}
			String impresionDiagnostica = "";
			for (int i = 0; i < historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity()
					.size(); i++) {
				impresionDiagnostica += historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity()
						.get(i).getCodDiagnostico() + "-"
						+ historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().get(i)
								.getDesDiagnostico();
				if (i < historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().size() - 1) {
					impresionDiagnostica += "\n";
				}
			}
			parameters.put("impresionDiagnostica", impresionDiagnostica);
			parameters.put("numeroPersona", persona.getSeqPersona());
			parameters.put("numeroHistoria", historias);
			if (persona.getImagenEncriptada() != null) {
				persona.setImagen(new String(persona.getImagenEncriptada()));
				parameters.put("imagenPaciente", crearImagenPaciente(persona.getImagen(), "paciente"));
			}
			if (medico.getImagenEncriptada() != null) {
				medico.setImagen(new String(medico.getImagenEncriptada()));
				parameters.put("imagenMedico", crearImagenPaciente(medico.getImagen(), "medico"));
			}
			parameters.put("documentoMedico", medico.getNumeroDocumento());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			File pdf = File.createTempFile("ocupacional", ".pdf");
			System.out.println("Lo exportamos a " + pdf.getAbsolutePath());
			FileOutputStream pdffinal = new FileOutputStream(pdf);
			JasperExportManager.exportReportToPdfStream(jasperPrint, pdffinal);
			pdffinal.close();
			byte[] inFileBytes = Files.readAllBytes(Paths.get(pdf.getAbsolutePath()));
			byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
			String base64EncryptedString = "";
			base64EncryptedString = new String(encoded);
			System.out.print(base64EncryptedString);
			return base64EncryptedString;
		} catch (IOException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (JRException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	// crear imagen para reporte
	private String crearImagenPaciente(String imagen, String id) {
		String[] palabras = imagen.split(",");
		String imgentmp = palabras[1];
		File img = null;
		try {
			img = File.createTempFile("imagen" + id, ".jpg");
			FileOutputStream imageOutFile = new FileOutputStream(img.getAbsolutePath());
			imageOutFile.write(java.util.Base64.getDecoder().decode(imgentmp.getBytes()));
			imageOutFile.close();
		} catch (IOException e) {
			System.err.print("Error al crear imagen " + id);
			e.printStackTrace();
		}

		return img.getAbsolutePath();
	}

	private PersonaEntity obtenerInformacion(String id) {
		return personaDao.findByPersonaOcupacional(id);
	}

	// crear reporte certificado ocupacional
	@Override
	public String exportReportCertificado(String id, int historia, String documentoMedico) {
		try {
			Connection conexion = DriverManager
					.getConnection(IConstantes.JDBC_REPORTE, IConstantes.USER_DB, IConstantes.PASS_DB);
			File file = ResourceUtils.getFile("classpath:certificado.jrxml");
			Map<String, Object> parameters = new HashMap<>();
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			String certificado = certificadoDao.findByNumeroCertificado(id);
			PersonaEntity medico = this.personaDao.findByPersonaMedico(certificado);
			if (medico.getImagenEncriptada() != null) {
				medico.setImagen(new String(medico.getImagenEncriptada()));
				parameters.put("imagenMedico", crearImagenPaciente(medico.getImagen(), "medico"));
			}
			parameters.put("historia", id);
			parameters.put("licsalud", medico.getLicenciaSalud());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			File pdf = File.createTempFile("certificado", ".pdf");
			System.out.println("Lo exportamos a " + pdf.getAbsolutePath());
			FileOutputStream pdffinal = new FileOutputStream(pdf);
			JasperExportManager.exportReportToPdfStream(jasperPrint, pdffinal);
			pdffinal.close();
			byte[] inFileBytes = Files.readAllBytes(Paths.get(pdf.getAbsolutePath()));
			byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
			String base64EncryptedString = "";
			base64EncryptedString = new String(encoded);
			System.out.print(base64EncryptedString);
			return base64EncryptedString;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (JRException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	//certificado gym
	@Override
	public String exportReportCertificadoGym(String id, int historia, String documentoMedico) {
		try {
			Connection conexion = DriverManager
					.getConnection(IConstantes.JDBC_REPORTE, IConstantes.USER_DB, IConstantes.PASS_DB);
			File file = ResourceUtils.getFile("classpath:certificadoGym.jrxml");
			Map<String, Object> parameters = new HashMap<>();
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			String certificado = certificadoGymDao.findGymByNumeroCertificado(id);
			PersonaEntity medico = this.personaDao.findByPersonaMedico(certificado);
			if (medico.getImagenEncriptada() != null) {
				medico.setImagen(new String(medico.getImagenEncriptada()));
				parameters.put("imagenMedico", crearImagenPaciente(medico.getImagen(), "medico"));
			}
			parameters.put("historia", id);
			parameters.put("licsalud", medico.getLicenciaSalud());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			File pdf = File.createTempFile("certificadoGym", ".pdf");
			System.out.println("Lo exportamos a " + pdf.getAbsolutePath());
			FileOutputStream pdffinal = new FileOutputStream(pdf);
			JasperExportManager.exportReportToPdfStream(jasperPrint, pdffinal);
			pdffinal.close();
			byte[] inFileBytes = Files.readAllBytes(Paths.get(pdf.getAbsolutePath()));
			byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
			String base64EncryptedString = "";
			base64EncryptedString = new String(encoded);
			System.out.print(base64EncryptedString);
			return base64EncryptedString;
		} catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (JRException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
}
