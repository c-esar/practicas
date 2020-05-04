package com.konrad.edu.serviceImp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.dao.IHistoriaGymDao;
import com.konrad.edu.dao.IHistoriaOcupacionalDao;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
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

	@SuppressWarnings("deprecation")
	@Override
	public String exportReport(String id) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.0.42;databaseName=HC_Historias",
					"sa", "12345");
			File file = ResourceUtils.getFile("classpath:historiasGym.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			HistoriaGYMEntity historia = obtenerlaHistoria(id);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("numeroPersona", historia.getPersona().getSeqPersona());
			parameters.put("imagenK", "");
			parameters.put("patologia", "");
			parameters.put("tiroidea", "");
			parameters.put("luxaciones", "");
			parameters.put("columna", "");
			parameters.put("colesterol", "");
			parameters.put("epilepsia", "");
			parameters.put("renal", "");
			parameters.put("fracturas", "");
			parameters.put("diabetesMellitus", "");
			parameters.put("asma", "");
			parameters.put("hipertensionpersonal", "");
			parameters.put("otrapersonal", "");
			parameters.put("problemaPeso", "");
			parameters.put("cirugias", "");
			parameters.put("otracualpersonal", "");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			JRExporter exporter = new JRPdfExporter();
//			File pdf;
//			pdf = File.createTempFile("historiasGYM.", ".pdf");
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("historiasGYM.pdf"));
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
	public String exportReportOcupacional(String id) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.0.42;databaseName=HC_Historias",
					"sa", "12345");
			File file = ResourceUtils.getFile("classpath:ocupacional.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			HistoriaOcupacionalEntity historia = obtenerlaHistoriaOcupacional(id);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("numeroPersona", historia.getPersona().getSeqPersona());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conexion);
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("historiasOcupacional.pdf"));
			exporter.exportReport();
			return "report generated in path :" + exporter.getReportContext(); 
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
	
	private HistoriaOcupacionalEntity obtenerlaHistoriaOcupacional(String id) {
		return historiaOcupacionalDao.findByPersona(id);	
	}
	
}
