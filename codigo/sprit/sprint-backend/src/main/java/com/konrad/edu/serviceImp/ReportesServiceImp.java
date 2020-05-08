package com.konrad.edu.serviceImp;

import java.io.File;
import java.io.IOException;
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
import com.konrad.edu.dao.IHistoriaGymDao;
import com.konrad.edu.dao.IHistoriaOcupacionalDao;
import com.konrad.edu.dao.IPersonaDao;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.PersonaEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class ReportesServiceImp implements IReportesService {

	@Autowired
	private IHistoriaGymDao historiasDao;

	@Autowired
	private IHistoriaOcupacionalDao historiaOcupacionalDao;
	
	@Autowired
	private IPersonaDao personaDao;

	private static JasperViewer viewer; 
	@SuppressWarnings("deprecation")
	@Override
	public String exportReport(String id, int historias) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.0.42;databaseName=HC_Historias",
					"sa", "12345");
			File file = ResourceUtils.getFile("classpath:historiasGym.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			HistoriaGYMEntity historia = obtenerlaHistoria(id);
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
			parameters.put("numeroPersona", historia.getPersona().getSeqPersona());
			parameters.put("imagenK", "");

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
			for(int i=0; i<persona.getHistorias().size(); i++) {
				if(persona.getHistorias().get(i).getSeqHistoria().intValue() == historias) {
					historia.setHistorias(persona.getHistorias());
					break;
				}
			}
			for (int i = 0; i < historia.getHistorias().get(0).getAntecedentesHistoriaEntity().size(); i++) {
				switch (historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getTipoAntecedenteEntity()
						.getNomAntecedente()) {
				case "PATOLOGICOS": {
					parameters.put("patologicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("patologicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "QUIRURGICOS": {
					parameters.put("quirurgicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("quirurgicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "ALERGICOS": {
					parameters.put("alergicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("alergicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "FARMACOLOGICOS": {
					parameters.put("farmacologicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("farmacologicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TRAUMATICOS": {
					parameters.put("traumaticosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("traumaticoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TOXICOS": {
					parameters.put("toxicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("toxicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "INMUNOLOGICOS": {
					parameters.put("inmunologicosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("inmunologicoscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "MENARQUIA": {
					parameters.put("menarquiaplanificacion",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getPlanificacion());
					parameters.put("menarquiaccv", historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getCcv() == null ? ""
							: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getCcv());
					parameters.put("menarquiafur", historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFur() == null ? ""
							: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFur());
					parameters.put("menarquiafur",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getMernarquia() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getMernarquia());
					if(historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getMenarquiaList() != null) {
						switch (historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getMenarquiaList()) {
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
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("hospitalarioscual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "FAMILIARES": {
					parameters.put("familiaresSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("familiarescual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				case "TABAQUISMO": {
					parameters.put("tabaquimosSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("tabaquimosfrecuencia",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					parameters.put("tabaquimosanos", historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getAnosHabito());
					parameters.put("tabaquimosfumador",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getExFumador().equalsIgnoreCase("S") ? "SI"
									: "NO");
					break;
				}
				case "CONSUMO ALCOHOL": {
					parameters.put("consumoSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("consumofrecuencia",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					break;
				}
				case "ACTIVIDAD FÍSICA": {
					parameters.put("actividadSN",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getEstadoAntecedente().equalsIgnoreCase("S")
									? "SI"
									: "NO");
					parameters.put("actividadfrecuencia",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getFrecuencia());
					parameters.put("actividadtipo",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getTipo() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getTipo());
					break;
				}
				case "ACTIVIDAD EXTRA LABORAL": {
					parameters.put("actividadlaboralcual",
							historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente() == null ? ""
									: historia.getHistorias().get(0).getAntecedentesHistoriaEntity().get(i).getDespAntecedente());
					break;
				}
				default:
					break;
				}
			}
			String impresionDiagnostica = "";
			for (int i = 0; i < historia.getHistorias().get(0).getDiagnosticoOcupacionalEntity().size(); i++) {
				impresionDiagnostica += historia.getHistorias().get(0).getDiagnosticoOcupacionalEntity().get(i).getCodDiagnostico() + "-"
						+ historia.getHistorias().get(0).getDiagnosticoOcupacionalEntity().get(i).getAfectacionPrincipal();
				if (i < historia.getHistorias().get(0).getDiagnosticoOcupacionalEntity().size() - 1) {
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
