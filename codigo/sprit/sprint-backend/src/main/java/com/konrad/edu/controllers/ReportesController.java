package com.konrad.edu.controllers;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IReportesService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	private IReportesService reportesService;

	@GetMapping("/historiaGym/{id}")
	public String reportesHistoriasGym(@PathVariable String id) {
			return reportesService.exportReport(id);
	}
	
	@GetMapping("/historiaOcupacional/{id}")
	public String reportesHistoriasOcupacional(@PathVariable String id) {
			return reportesService.exportReportOcupacional(id);
	}
}
