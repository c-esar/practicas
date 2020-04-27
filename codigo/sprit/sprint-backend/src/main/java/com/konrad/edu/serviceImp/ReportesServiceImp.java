package com.konrad.edu.serviceImp;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.konrad.edu.IService.IReportesService;
import com.konrad.edu.dao.IHistoriaGymDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportesServiceImp implements IReportesService {

	@Autowired
	private IHistoriaGymDao historiasDao;
	
	@Override
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\basan\\Desktop\\Report";
		// List<Employee> employees = repository.findAll();
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:employees.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		// JRBeanCollectionDataSource dataSource = new
		// JRBeanCollectionDataSource(employees);
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("createdBy", "Java Techie");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        if (reportFormat.equalsIgnoreCase("pdf")) {
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
//        }

		return "report generated in path : " + path;
	}
}
