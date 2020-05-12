package com.konrad.edu.serviceImp;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.dao.IHistoriaGymDao;
import com.konrad.edu.dao.IHistoriaOcupacionalDao;
import com.konrad.edu.dao.IPersonaDao;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.PersonaEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Service
public class ReportesServiceImp implements IReportesService {

	@Autowired
	private IHistoriaGymDao historiasDao;

	@Autowired
	private IHistoriaOcupacionalDao historiaOcupacionalDao;
	
	@Autowired
	private IPersonaDao personaDao;

	@SuppressWarnings("deprecation")
	@Override
	public String exportReport(String id, int historias) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.0.42;databaseName=HC_Historias",
					"sa", "12345");
			File file = ResourceUtils.getFile("classpath:historiasGym.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			PersonaEntity persona = obtenerlaHistoriaOcupacional(id);
			HistoriaGYMEntity historia = new HistoriaGYMEntity();
			for(int i=0; i<persona.getHistoriaGymEncriptacion().size(); i++) {
				if(persona.getHistoriaGymEncriptacion().get(i).getSeqHistoriaGym().intValue() == historias) {
					historia = persona.getHistoriaGymEncriptacion().get(i);
					break;
				}
			}
			Map<String, Object> parameters = new HashMap<>();
			String impresionDiagnostica = "";
			for (int i = 0; i < historia.getHistoriaPreguntasGyms().size(); i++) {
				switch (historia.getHistoriaPreguntasGyms().get(i).getTipoPreguntaHistoriaGymEntity()
						.getNomPregunta()) {
				case "EMBARAZO": {
					parameters.put("embarazo",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					break;
				}
				case "FUMA": {
					parameters.put("fumaSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
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
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("licorcuantos",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					break;
				}
				case "EJERCICIO": {
					parameters.put("ejercicioSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
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
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("energizantecuantas",
							String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()) == null ? ""
									: String.valueOf(historia.getHistoriaPreguntasGyms().get(i).getCantidad()));
					break;
				}
				case "PSICOACTIVAS": {
					parameters.put("psicoactivasSN",
							historia.getHistoriaPreguntasGyms().get(i).getEstadoPregunta().equalsIgnoreCase("S")
									? "SI"
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
						+ historia.getDiagnosticoOcupacionalEntity().get(i).getAfectacionPrincipal();
				if (i < historia.getDiagnosticoOcupacionalEntity().size() - 1) {
					impresionDiagnostica += ";  ";
				}
			}
			parameters.put("impresionDiagnostica", impresionDiagnostica);
			parameters.put("numeroPersona", persona.getSeqPersona());
			InputStream stream = new ByteArrayInputStream(persona.getImagen().getBytes());
			Image image = ImageIO.read(stream);
			parameters.put("imagen", image);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			JRExporter exporter = new JRPdfExporter();
//			File pdf;
//			pdf = File.createTempFile("historiasGYM.", ".pdf");
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("historiasGYM.pdf"));
			exporter.exportReport();
//			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
			return "report generated in path :";
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

	private HistoriaGYMEntity obtenerlaHistoria(String id) {
		return historiasDao.findByPersona(id);
	}

	@Override
	public File exportReportOcupacional(String id, int historias) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.0.42;databaseName=HC_Historias",
					"sa", "12345");
			File file = ResourceUtils.getFile("classpath:ocupacional.jrxml");
			Map<String, Object> parameters = new HashMap<>();
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			PersonaEntity persona = obtenerlaHistoriaOcupacional(id);
			PersonaEntity historia = new PersonaEntity();
			for(int i=0; i<persona.getHistoriasEncriptacion().size(); i++) {
				if(persona.getHistoriasEncriptacion().get(i).getSeqHistoria().intValue() == historias) {
					historia.getHistoriasEncriptacion().add(persona.getHistoriasEncriptacion().get(i));
					break;
				}
			}
			for (int i = 0; i < historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().size(); i++) {
				switch (historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getTipoAntecedenteEntity()
						.getNomAntecedente()) {
				case "PATOLOGICOS": {
					parameters.put("patologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("patologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "QUIRURGICOS": {
					parameters.put("quirurgicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("quirurgicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "ALERGICOS": {
					parameters.put("alergicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("alergicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "FARMACOLOGICOS": {
					parameters.put("farmacologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("farmacologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TRAUMATICOS": {
					parameters.put("traumaticosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("traumaticoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TOXICOS": {
					parameters.put("toxicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("toxicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "INMUNOLOGICOS": {
					parameters.put("inmunologicosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("inmunologicoscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "MENARQUIA": {
					parameters.put("menarquiaplanificacion",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getPlanificacion());
					parameters.put("menarquiaccv", historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getCcv() == null ? ""
							: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getCcv());
					parameters.put("menarquiafur", historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFur() == null ? ""
							: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFur());
					parameters.put("menarquiafur",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getMernarquia() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getMernarquia());
					if(historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getMenarquiaList() != null) {
						switch (historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getMenarquiaList()) {
						case "GESTACIONES": {
							parameters.put("G", "X");
							break;
						}
						case "PARTOS": {
							parameters.put("P", "X");
							break;
						}
						case "CESAREAS": {
							parameters.put("C", "X");
							break;
						}
						case "ABORTOS": {
							parameters.put("A", "X");
							break;
						}
						case "VIVOS": {
							parameters.put("V", "X");
							break;
						}

						default:
							break;
						}
					}
					break;
				}
				case "HOSPITALARIOS": {
					parameters.put("hospitalariosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("hospitalarioscual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "FAMILIARES": {
					parameters.put("familiaresSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("familiarescual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TABAQUISMO": {
					parameters.put("tabaquimosSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("tabaquimosfrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					parameters.put("tabaquimosanos", historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getAnosHabito());
					parameters.put("tabaquimosfumador",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getExFumador().equalsIgnoreCase("S") ? "SI"
									: "NO");
					break;
				}
				case "CONSUMO ALCOHOL": {
					parameters.put("consumoSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("consumofrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					break;
				}
				case "ACTIVIDAD FÍSICA": {
					parameters.put("actividadSN",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("actividadfrecuencia",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					parameters.put("actividadtipo",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getTipo() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getTipo());
					break;
				}
				case "ACTIVIDAD EXTRA LABORAL": {
					parameters.put("actividadlaboralcual",
							historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistoriasEncriptacion().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				default:
					break;
				}
			}
			String impresionDiagnostica = "";
			for (int i = 0; i < historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().size(); i++) {
				impresionDiagnostica += historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().get(i).getCodDiagnostico() + "-"
						+ historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().get(i).getAfectacionPrincipal();
				if (i < historia.getHistoriasEncriptacion().get(0).getDiagnosticoOcupacionalEntity().size() - 1) {
					impresionDiagnostica += "\n";
				}
			}
			parameters.put("impresionDiagnostica", impresionDiagnostica);
			parameters.put("numeroPersona", persona.getSeqPersona());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			JRExporter exporter = new JRPdfExporter();        
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ocupacional"+persona.getNomPrimerNombre()+".pdf"));
	        exporter.exportReport();
	        String ruta = System.getProperty("user.dir");
	        System.out.print(ruta);
	        File archivo = new File(ruta+"\\ocupacional"+persona.getNomPrimerNombre()+".pdf");
			return archivo;
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

	private PersonaEntity obtenerlaHistoriaOcupacional(String id) {
		return personaDao.findByPersonaOcupacional(id);
	}

	@Override
	public String exportReportCertificado(String id, int historia) {
		return null;
	}
}
